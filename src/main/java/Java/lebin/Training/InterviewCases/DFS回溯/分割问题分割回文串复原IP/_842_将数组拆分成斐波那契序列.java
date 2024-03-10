package Java.lebin.Training.InterviewCases.DFS回溯.分割问题分割回文串复原IP;

import java.util.ArrayList;
import java.util.List;

/*
给定一个数字字符串 num，比如 "123456579"，我们可以将它分成「斐波那契式」的序列 [123, 456, 579]。

形式上，斐波那契式 序列是一个非负整数列表 f，且满足：

0 <= f[i] < 231 ，（也就是说，每个整数都符合 32 位 有符号整数类型）
f.length >= 3
对于所有的0 <= i < f.length - 2，都有 f[i] + f[i + 1] = f[i + 2]
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 num 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。



示例 1：

输入：num = "1101111"
输出：[11,0,11,11]
解释：输出[110,1,111]也可以。
示例 2：

输入: num = "112358130"
输出: []
解释: 无法拆分。
示例 3：

输入："0123"
输出：[]
解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。

 */
/*
知识点：
回溯；
设计递归函数的返回值
很像 IP 地址分割那个问题（第 93 题）。
 */
public class _842_将数组拆分成斐波那契序列 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, len, res);
        return res;
    }

    /**
     * @param charArray
     * @param begin
     * @param len
     * @param res       斐波拉契数列数量保存在这个列表里
     * @return 是否可以拆分为斐波拉契数列
     */
    private boolean dfs(char[] charArray, int begin, int len, List<Integer> res) {
        // 递归终止条件
        if (begin == len) {
            return res.size() > 2;
        }

        int num = 0;
        for (int i = begin; i < len; i++) {
            num = num * 10 + (charArray[i] - '0');
            // 考虑整型溢出的情况
            if (num < 0) {
                return false;
            }
            if (res.size() < 2 || res.get(res.size() - 2) + res.get(res.size() - 1) == num) {
                res.add(num);
                if (dfs(charArray, i + 1, len, res)) {
                    return true;
                }
                // 如果不能得到，撤销选择
                res.remove(res.size() - 1);
            }

            // 1011 -> [1,0,1,1]
            if (i == begin && charArray[i] == '0') {
                return false;
            }
        }
        return false;
    }
}
