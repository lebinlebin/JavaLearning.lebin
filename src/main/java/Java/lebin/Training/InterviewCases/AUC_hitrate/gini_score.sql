--
SELECT
  'model_gini_auc',
  exp_name,
  (2 * gmv_rank / sum_gmv / cnt - 1) AS model_gini_auc,
  cnt
from(
    SELECT
      exp_name,
      sum(gmv) AS sum_gmv,
      sum(gmv * rank) AS gmv_rank,
      count(1) AS cnt
    from(
        SELECT
          exp_name,gmv,
          row_number() over(PARTITION by exp_name ORDER BY score ASC, gmv ASC ) AS rank
        from(
            select
--              if(cast(live_watch_item_buy_cnt_v2 as int)>0, 1, 0) as y,
              live_watch_item_buy_v2/100 as gmv,--gmv的值
--              live_watch_item_buy_cnt_v2 as order_num,
--               live_watch_item_buy_v2/100 as gmv,
--              cast(live_click as int) as y,--0/1 label
              -- xauc只需要计算相对关系
--              cast(follow_offline_ua_score as double) as score,--score_i
              (cast(tower_ctr as DOUBLE) * cast(tower_cvr as DOUBLE) * cast(sc_pexp_gmv as DOUBLE) ) as score, --score_i
--              lookupCurrentGroup('{{ab_world}}', uid, did) as dt,
              lookupCurrentGroup("ad_dsp_merchant_did_14",  0, did) as exp_name --当前的实验组  eg. exp1，exp2，base1，base2
            from
              reco.reco_convert_kafka_to_hive_eshop_hot_live_bigriver
            where
              (p_date = '20220928'  and  p_hour in ('13') )
              and uid != '-'
              and uid is not NULL
              and live_realshow != '-'
              and live_realshow > 0
              and live_realshow is not NULL
              and liseshop=1
              and cast(tower_ctr as double) > 0.0
              and cast(tower_cvr as double) > 0.0
              and cast(sc_pexp_gmv as double) > 0.0
              and cast(follow_offline_ua_score as double) > 0.0
              and cast(follow_prerank_score as double) >0.0
              and merchant_single_redirect_flag = '1'
              and lookupCurrentExp('ad_dsp_merchant_did_15', 0, did) =  'merchant_1pp_mc_sort_optimize_new' --当前的世界
              and lookupCurrentGroup("ad_dsp_merchant_did_15",  0, did)  in ("exp3","base1","base2")
          ) a
      ) b
    group by exp_name
  ) c