package Java.lebin.Training.InterviewCases.characterString.KMP;
//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
/*
示例 1:
输入: s = "abab"
输出: true
解释: 可由子串 "ab" 重复两次构成。
 */
//时间复杂度：O(n)，其中 n 是字符串 s 的长度。
// 空间复杂度：O(n)。
public class _459_重复的子字符串_是否由字符串的子串重复多次构成 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }

    //最终还是要判断 一个字符串（s + s）是否出现过 s 的过程，大家可能直接用contains，find 之类的库函数。
    // 却忽略了实现这些函数的时间复杂度（暴力解法是m * n，一般库函数实现为 O(m + n)）。
    public boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
