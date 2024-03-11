
#合并两个list，去重的同时删掉标记为delete的元素
# 定义两个列表，元素是一个tuple类型，(int32，bool)
list1 = [(1,False), (2,True), (3,False), (4,True), (5,False)]
list2 = [(2,True), (3,False), (6,False), (7,False), (8,True)]
merged_list = list1 + list2
deduplicated_list = list(dict.fromkeys(merged_list))
four_and_false_tuples = [(x, y) for (x, y) in deduplicated_list if  not y]
print(four_and_false_tuples)
