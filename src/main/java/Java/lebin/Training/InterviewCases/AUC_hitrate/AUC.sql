SELECT
     '单列插直播粗排ctr_auc',
      b.exp_name,
      (b.rank_click - 0.5 *b.true_positive_num*(b.true_positive_num + 1)) /(b.true_neg_num*b.true_positive_num) AS auc,
           --rank_click 代表第i条样本的序号（概率预估得分从小到大排，排在第rank个位置）
           --true_positive_num，true_neg_num 分别是正样本的个数和负样本的个数
           --rank_click 只把正样本的序号加起来
      b.cnt
    from(
        SELECT
          a.exp_name as exp_name,
          sum(if(a.live_click=0, 1, 0)) AS true_neg_num,--label为0的标记为1
          sum(if(a.live_click>0, 1, 0)) AS true_positive_num,--label为1的标识为1
          sum(if(a.live_click>0, rank, 0)) AS rank_click,--记录label=1的rank值  记录被点击的样本的序(rank)  如果预估的很准，那么被点击的样本的序要大于不被点击的样本的序
          count(1) AS cnt
        from (
                 SELECT aa.live_click  as live_click,exp_name,
                 row_number()  over(PARTITION by (aa.exp_name) ORDER BY (cast(aa.branch_ctr as DOUBLE)) ASC  ) AS rank
            from (
                select live_click,
                CASE
                   when lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "") in ("base1","base2") then 'base'
                   when lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "") in ("exp4","exp8") then 'exp'
                   else 'other'
                  END as exp_name,--当前的实验组  eg. exp1，exp2，base1，base2 as exp_name,--当前的实验组  eg. exp1，exp2，base1，base2
                branch_ctr
                    FROM reco.reco_convert_kafka_to_hive_eshop_hot_live
                 WHERE p_date = '20211221' and (p_hour >= '20' and p_hour <= '22')
                   and uid != '-' and uid is not NULL and live_realshow != '-'
                  and reason != 1238
                  and live_realshow > 0 and live_realshow is not NULL
                  and cast(branch_ctr as DOUBLE) > 0.0 and cast(tower_ctr as DOUBLE) > 0.0
                  and lookupCurrentExp("ad_dsp_uid_WqCueY_2688", uid, "") = 'merchant_1pp_rerank_v2_copy' --当前的世界
                                  and lookupCurrentGroup("ad_dsp_uid_WqCueY_2688", uid, "")  in ("exp4","exp8","base1","base2")


                     )aa
            ) a
        group by a.exp_name)b
