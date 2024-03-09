import numpy as np
from sklearn.metrics import roc_curve
from sklearn.metrics import auc

from sklearn.metrics import roc_auc_score
def calcAUC(labels, probs):
    N = 0
    P = 0
    neg_prob = []
    pos_prob = []
    for _,i in enumerate(labels):
        if (i == 1):
            P += 1
            pos_prob.append(probs[_])
        else:
            N += 1
            neg_prob.append(probs[_])
    number = 0
    for pos in pos_prob:
        for neg in neg_prob:
            if (pos > neg):
                number += 1
            elif (pos == neg):
                number += 0.5
    return number / (N * P)

y = np.array([1,0,0,0,1,0,1,0,])
pred = np.array([0.9, 0.8, 0.3, 0.1,0.4,0.9,0.66,0.7])
print('auc=',calcAUC(y,pred))
print('roc_auc=',roc_auc_score(y,pred))

def auc_calculate(labels,preds,n_bins=100):
    postive_len = sum(labels)   #正样本数量（因为正样本都是1）
    negative_len = len(labels) - postive_len #负样本数量
    total_case = postive_len * negative_len #正负样本对
    pos_histogram = [0 for _ in range(n_bins)]
    neg_histogram = [0 for _ in range(n_bins)]
    bin_width = 1.0 / n_bins
    for i in range(len(labels)):
        nth_bin = int(preds[i]/bin_width)
        if labels[i]==1:
            pos_histogram[nth_bin] += 1
        else:
            neg_histogram[nth_bin] += 1
    accumulated_neg = 0
    satisfied_pair = 0
    for i in range(n_bins):
        satisfied_pair += (pos_histogram[i]*accumulated_neg + pos_histogram[i]*neg_histogram[i]*0.5)
        accumulated_neg += neg_histogram[i]
    return satisfied_pair / float(total_case)
def get_relevance_score_from_fr_rank(relevance_score_def, fr_rank, relevance_score=None):
    for i in relevance_score_def:
        if fr_rank[i] == 0:
            relevance_score[i] = relevance_score_def[0]
        elif fr_rank[i] == 1:
            relevance_score[i] = relevance_score_def[1]
        elif fr_rank[i] == 2:
            relevance_score[i] = relevance_score_def[2]
        elif fr_rank[i] > 2 and  fr_rank[i] < 10 :
            relevance_score[i] = relevance_score_def[3]
        else:
            relevance_score[i] = relevance_score_def[4]
    return  relevance_score
# def calcNDCG(relevance_scorelist, fr_rank):
#     for i in arange(len(relevance_scorelist)):




if __name__ == '__main__':
    y = np.array([1,0,0,0,1,0,1,0,])
    pred = np.array([0.9, 0.8, 0.3, 0.1,0.4,0.9,0.66,0.7])

    fpr, tpr, thresholds = roc_curve(y, pred, pos_label=1)
    print("sklearn:",auc(fpr, tpr))
    print("验证:",auc_calculate(y,pred))


    #NDCG
    relevance_score_def = np.array([7, 5, 5, 3, 3, 3, 3, 1])
    fr_rank = np.array([7, 5, 5, 3, 3, 3, 3, 1])
    relevance_score = []
    relevance_scorelist = get_relevance_score_from_fr_rank(relevance_score_def, fr_rank,relevance_score)
    NDCG_score = calcNDCG(relevance_scorelist, fr_rank)





    
    .enrich_attr_by_lua(
    import_common_attr=["relevance_score_list","list_fr_rank"],
    function_for_common="calculate",
    export_common_attr=["IDCG"],
    lua_script="""
        function calculate()
          local DCG = 0
          local IDCG = 0
          local temp = {}
          for i = 1, #relevance_score_list do
            temp[i] = {}
            if(list_fr_rank[i] == -1) then
                temp[i][1] = 1000000
            else
                temp[i][1] = list_fr_rank[i] + 1
            end
            temp[i][2] = relevance_score_list[i]
          end

          --按照相关性从大到小排序，理想排序，其实这里不需要跑
          table.sort(temp, function(a,b) return a[2] > b[2] end)   
          for i = 1, #temp do
            IDCG = IDCG + math.log(2) * ( 2^(temp[i][2]) - 1 ) / math.log( temp[i][1]+1 )
          end
          return IDCG
        end
      """)


# 计算Top-K准确率和召回率的函数
def top_k_accuracy(predictions, labels, k=1):
    # 计算准确度
    correct_predictions = sum(1 for true_label, pred_label in zip(labels, predictions) if true_label in pred_label[:k])
    accuracy = correct_predictions / len(labels)

    # 计算召回率
    all_labels_set = set(labels)
    true_predicted_set = set(
        true_label for true_label, pred_label in zip(labels, predictions) for label in pred_label[:k] if
        label in all_labels_set)
    recall = len(true_predicted_set) / len(all_labels_set)

    return accuracy, recall


# 示例使用
predictions = [["item1", "item4", "item5"], ["item1", "item2", "item3"], ["item1", "item2", "item3"]]
labels = ["item1", "item3", "item5"]

accuracy, recall = top_k_accuracy(predictions, labels, k=2)
print(f"Top-2 准确率: {accuracy}")
print(f"Top-2 召回率: {recall}")
