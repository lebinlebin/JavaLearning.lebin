import numpy as np
from matplotlib.pylab import plt
from sklearn.metrics import roc_auc_score
#############################AUC########################################


# 预测分数和实际的好坏情况
scores = np.array([0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05])
actual = np.array(['坏', '坏', '好', '好', '坏', '好', '好', '好', '坏', '好'])
# 找出所有的正负样本对
positive_scores = scores[actual == '坏']
negative_scores = scores[actual == '好']
print("positive_scores",positive_scores)
print("negative_scores",negative_scores)
pairs = [(p, n) for p in positive_scores for n in negative_scores]
# 计算模型预测正确的样本对的数量
correct_pairs = sum(1 for p, n in pairs if p > n)
# 计算AUC
auc = correct_pairs / len(pairs)
print("AUC: ", auc)


#也可以直接使用sklearn的包来进行计算：
from sklearn import metrics
# 将实际的好坏情况转换为二进制标签
binary_actual = (actual == '坏').astype(int)
# 计算AUC
auc = metrics.roc_auc_score(binary_actual, scores)
print("AUC: ", auc)


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

if __name__ == '__main__':
    y = np.array([1,0,0,0,1,0,1,0,])
    pred = np.array([0.9, 0.8, 0.3, 0.1,0.4,0.9,0.66,0.7])

    fpr, tpr, thresholds = roc_curve(y, pred, pos_label=1)
    print("sklearn:",auc(fpr, tpr))
    print("验证:",auc_calculate(y,pred))

###########################GINI #############################################
"""
Gini系数的取值范围在-1到1之间，0表示模型预测无好于随机猜测，1则表示模型预测完全正确。它是一种常用的模型性能评估指标，
可以帮助我们理解模型在区分正负样本方面的能力。
Gini通常用来评估评分卡模型能在多大程度上区分好坏，

当样本中坏样本极少时可用gini=2AUC-1近似计算，当坏样本较多，或者好坏样本接近1:1时，那就得对gini单独计算比较准确。

Gini：评估模型对“头部消费者”的预测能力。
	a. 问：为什么Gini能够评估“头部”预测能力？
	答：Gini评价的是模型对于不同关注对的分辨能力，即“差异性”。而单列电商单次请求透出一般只有一个，所以需要重点评估模型对头部“关注对”分辨力。（类似于wuauc）
"""
# Predicted credit risk scores and actual binary labels
predict = [0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05]
actual = [1, 1, 0, 0, 1, 0, 0, 0, 1, 0]
def compute_gini_coefficient(predict, actual):
    # Combine the predicted scores and actual labels into a single array
    data = np.array(list(zip(predict, actual)), dtype=[('predict', float), ('actual', int)])
    # Sort the data based on the predicted scores (in descending order)
    print("####################################")
    print(data)
    #[::-1]表示从后向前输出，就是排序之后从大向小输出
    data = np.sort(data, order='predict')[::-1]
    print("--------------------------------------")
    print(data)
    n = len(data)

    # Calculate the cumulative share of positive (good) labels
    cumulative_pos = np.cumsum(data['actual']) / np.sum(data['actual'])
    cumulative_neg = np.cumsum(1 - data['actual']) / np.sum(1 - data['actual'])

    # Calculate the area between Lorenz curve and perfect equality
    # np.trapz的图形解释: https://blog.csdn.net/jacke121/article/details/118811618
    area_between_curve = np.trapz(cumulative_pos, cumulative_neg) - 0.5

    # Calculate the area under perfect equality
    area_under_curve = 0.5

    # Compute the Gini coefficient
    gini_coefficient = area_between_curve / area_under_curve

    return gini_coefficient,cumulative_pos,cumulative_neg


# Compute Gini coefficient
gini_coefficient,cumulative_pos,cumulative_neg = compute_gini_coefficient(predict, actual)

# Compute AUC
auc = roc_auc_score(actual, predict)

# Verify Gini = 2 * AUC - 1
gini_verified = 2 * auc - 1

print(f'Gini Coefficient: {gini_coefficient:.4f}')
print(f'AUC: {auc:.4f}')
print(f'Gini (Verified): {gini_verified:.4f}')

plt.plot(cumulative_neg, cumulative_pos, color='r')
plt.plot([0, 1], [0, 1], linestyle='--', color='b')
plt.xlabel('FPR')
plt.ylabel('TPR')
plt.title('ROC Curve')
plt.show()


# ###
# # np.cumsum(a, axis=0)
# # 用于将数组按列累加，譬如
# import numpy as np
# a = np.array([[1, 2, 3], [4, 5, 6]])
# b = np.cumsum(a, axis=0)
# print(b)
# # 输出结果为
# # [[1 2 3]
# #  [5 7 9]]
# ##########------------------------------------------------
# np.cummsum(a, axis=1)
# # 用于将数组按行累加，譬如
# import numpy as np
# a = np.array([[1, 2, 3], [4, 5, 6]])
# b = np.cumsum(a, axis=1)
# print(b)
#
# # 输出结果为
# # [[1 3 6]
# #  [4 9 15]]


"""
KS
定义
在信贷风控中，KS(Kolmogorov-Smirnov)指标用于衡量模型区分能力的强弱。具体来说，KS值是好坏用户累积分布曲线之间的最大差值，即 max(abs(TPR-FPR))，表示模型在对好坏用户进行分类时的最大预测准确度。
性质
KS值的取值范围是0到1，数值越大表示模型的区分能力越强。当KS值等于1时，模型完美地区分了好用户和坏用户，即好用户和坏用户的累积分布曲线没有重叠。反之，当KS值接近于0时，模型无法有效地区分好用户和坏用户，即好用户和坏用户的累积分布曲线几乎重合。
计算
我们还是用手动方式和调用sklearn包的方式来计算KS的值。
手动计算的步骤如下：
.将数据根据模型预测分数从0到1排序。
.计算好坏用户累积数量。
.计算好用户和坏用户的累积分布，即FPR和TPR。
.计算好用户和坏用户的累积分布之间的最大差值，即KS值。
"""
import numpy as np

# 数据和标签
scores = np.array([0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05])
actual = np.array(['坏', '坏', '好', '好', '坏', '好', '好', '好', '坏', '好'])
binary_actual = (actual == '坏').astype(int)

# 手动计算KS值
n = len(binary_actual)
sorted_indices = np.argsort(scores)[::-1]
sorted_actual = binary_actual[sorted_indices]
cum_TP = np.cumsum(sorted_actual == 1) / np.sum(sorted_actual == 1)
cum_FP = np.cumsum(sorted_actual == 0) / np.sum(sorted_actual == 0)

# 计算好用户和坏用户的累积分布曲线
cum_bad = cum_TP
cum_good = cum_FP

# 计算KS值
ks_manual = np.max(np.abs(cum_good - cum_bad))
print("KS (手动计算): ", ks_manual)
# 按照 KS=max(|FPR-TPR|)公式调用sklearn的包进行计算：
from sklearn.metrics import roc_curve
# 使用sklearn包计算KS值
fpr, tpr, _ = roc_curve(binary_actual, scores)
ks_sklearn = np.max(np.abs(tpr - fpr))
print("KS (sklearn包计算): ", ks_sklearn)

"""
Lift
定义
提升度指标Lift是用于衡量模型在目标用户中的区分能力。Lift值是累积响应曲线（Cumulative Response Curve）和随机响应曲线（Random Response Curve）之间的差异。
它表示模型对于目标用户的预测能力相对于随机预测的提升程度。这个指标其实更常出现在营销响应模型的评估中，但风控领域也是可以作为一个参考指标使用。

在风控领域，Lift其实就是坏用户累积分布和总体用户的累积分布的比值。他刻画的信息和KS是有相似之处的。

性质
Lift值大于1：表示模型在目标用户中的预测能力优于随机预测。例如，Lift值为2表示模型的预测效果是随机预测的2倍，即模型在目标用户中的预测准确率较高。

Lift值等于1：表示模型在目标用户中的预测能力与随机预测相当。例如，Lift值为1表示模型的预测效果与随机预测相同，即模型没有提供额外的预测能力。

Lift值小于1：表示模型在目标用户中的预测能力不如随机预测。例如，Lift值为0.5表示模型的预测效果是随机预测的一半，即模型在目标用户中的预测准确率较低。

计算
依旧是用手动方式和调用sklearn包的方式来计算KS的值。

手动计算Lift值的步骤如下：
将数据按模型预测结果从0到1排序。
分别计坏用户的累积数量和总用户的累积数量。
分别计坏用户的累积分布和总用户的累积分布。
坏用户累积分布除以总用户累积分布得到Lift。
代码如下:

"""
import numpy as np

# 数据和标签
scores = np.array([0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05])
actual = np.array(['坏', '坏', '好', '好', '坏', '好', '好', '好', '坏', '好'])
binary_actual = (actual == '坏').astype(int)

# 手动计算Lift
n = len(binary_actual)
sorted_indices = np.argsort(scores)[::-1]
sorted_actual = binary_actual[sorted_indices]
cum_TP = np.cumsum(sorted_actual == 1) / np.sum(sorted_actual == 1)
cum_Total = np.cumsum([1]*len(sorted_actual)) / len(sorted_actual)

lift = cum_TP/cum_Total
print(lift)
# 使用sklearn的相关包计算，这里我们使用的不是sklearn的包而是scikit-plot。
import numpy as np
# 数据和标签
scores = np.array([0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05])
actual = np.array(['坏', '坏', '好', '好', '坏', '好', '好', '好', '坏', '好'])
binary_actual = (actual == '坏').astype(int)

# 使用scikit-plot中计算累积收益曲线的函数计算
import scikitplot as skplt
cumulative_gains, gains = skplt.metrics.cumulative_gain_curve(binary_actual, scores)
deciles = np.linspace(0, 1, num=len(cumulative_gains))

# 剔除数组最开始的0 然后计算lift
lift1 = tpr[1:]/deciles[1:]
print("lift1")
print(lift1)

"""
小结
在信贷风控领域，评估和优化模型的性能是非常重要的，这涉及到多个指标的使用。
本文介绍了在信贷风控中常用的四个重要指标：AUC、Gini、KS和Lift。
其中AUC和Gini都是反应了模型区分度的平均状况，他们可以认为是同一个指标。
KS和Lift都是在看累积分布的差异，KS更关注累积分布差异的最大值，而Lift反应差异的变化趋势。
"""