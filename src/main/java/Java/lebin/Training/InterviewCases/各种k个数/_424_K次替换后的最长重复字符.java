package Java.lebin.Training.InterviewCases.各种k个数;
/*
给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
示例 1：
输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：
输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
可能存在其他的方法来得到同样的结果。

 */
//滑动窗口
//时间复杂度：O(N)，这里 N 是输入字符串 S 的长度；
//空间复杂度：O(A)，这里 A 是输入字符串 S 出现的字符 ASCII 值的范围
public class _424_K次替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];
        int maxCount = 0;

        int left = 0;
        int right = 0;
        // [left..right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len) {
            freq[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                freq[charArray[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
