set spark.sql.adaptive.maxNumPostShufflePartitions=200;
set hive.specify.execution.engine.enforce.name=spark;
delete jar viewfs:///home/system/hive/resources/abtest/kuaishou-abtest-core-latest.jar;
add jar viewfs:///home/system/hive/resources/abtest/kuaishou-abtest-core-latest.jar;
create temporary function lookupCurrentExp as 'com.kuaishou.abtest.udf.LookupCurrentExp';
create temporary function lookupCurrentGroup as 'com.kuaishou.abtest.udf.LookupCurrentGroup';

--保量
SELECT
  '单列插直播粗排ctr',
  exp_name,
  avg(auc) AS uauc,
  sum(cnt*auc) / sum(cnt) AS wuauc,
  sum(cnt) AS cnt
from(
    SELECT
      exp_name,
      uid,
      (rank_click - 0.5 *true_positive_num*(true_positive_num + 1)) /(true_neg_num*true_positive_num) AS auc,
           --rank_click 代表第i条样本的序号（概率得分从小到大排，排在第rank个位置）
           --true_positive_num，true_neg_num 分别是正样本的个数和负样本的个数
           --rank_click 只把正样本的序号加起来
      cnt
    from(
        SELECT
          exp_name,
          uid,
          sum(if(live_click=0, 1, 0)) AS true_neg_num,--label为0的标记为1
          sum(if(live_click>0, 1, 0)) AS true_positive_num,--label为1的标识为1
          sum(if(live_click>0, rank, 0)) AS rank_click,--记录label=1的rank值  记录被点击的样本的序(rank)  如果预估的很准，那么被点击的样本的序要大于不被点击的样本的序
          count(1) AS cnt
        from(
            SELECT
              exp_name,uid,live_click,
              row_number() over(PARTITION by uid,exp_name ORDER BY p_ctr ASC) AS rank
            from(
                SELECT
                CASE
                   when lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "") in ("base1","base2") then 'base'
                   when lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "") in ("exp4","exp8") then 'exp'
                   else 'other'
                  END as exp_name,
                  uid AS uid,
                  live_click as live_click,
                  cast(branch_ctr as DOUBLE) as p_ctr
                FROM
                  reco.reco_convert_kafka_to_hive_eshop_hot_live
                WHERE
                  p_date = '20211220' and  (p_hour >= '20' and p_hour <= '22' )  and uid != '-' and uid is not NULL and live_realshow != '-'
                  and reason != 1238
                  and live_realshow > 0 and live_realshow is not NULL and cast(branch_ctr as DOUBLE) > 0.0 and cast(tower_ctr as DOUBLE) > 0.0
                  and lookupCurrentExp("ad_dsp_uid_WqCueY_2688", uid, "") = 'merchant_1pp_rerank_v2_copy' --当前的世界
                                  and lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "")  in ("exp4","exp8","base1","base2")

              ) A
          ) B
        GROUP BY
          exp_name,
          uid
      ) C
    WHERE
      true_neg_num > 0 AND true_positive_num > 0 --保证当前用户下既有正样本又有负样本
  ) D
GROUP BY
exp_name