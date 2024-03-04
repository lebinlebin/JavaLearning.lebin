package Java.lebin.Training.InterviewCases.characterString;

import java.util.LinkedList;
import java.util.List;

/*
763.划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
示例：
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8] 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
/*
可以分为如下两步：
统计每一个字符最后出现的位置
从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
 */
public class _763_划分字母区间 {
//    时间复杂度：O(n)
//    空间复杂度：O(1)，使用的hash数组是固定大小
public List<Integer> partitionLabels(String S) {
    List<Integer> list = new LinkedList<>();
    int[] edge = new int[26];
    char[] chars = S.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        edge[chars[i] - 'a'] = i;//记录26个字符所在最大的下标
    }
    int idx = 0;
    int last = -1;
    for (int i = 0; i < chars.length; i++) {
        idx = Math.max(idx,edge[chars[i] - 'a']);
        if (i == idx) {
            list.add(i - last);
            last = i;
        }
    }
    return list;
}
}
