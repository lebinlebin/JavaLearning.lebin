package Java.lebin.Training.InterviewCases.characterString;

import java.util.Collections;
import java.util.HashMap;

/*
给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
示例 1：
输入：s = "eceba"
输出：3
解释：满足题目要求的子串是 "ece" ，长度为 3 。
示例 2：
输入：s = "ccaabbb"
输出：5
解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
 */
public class _159_至多包含两个不同字符的最长子串 {
    /*
为了一次性解决问题， 我们使用滑动窗口方法，设定两个指针 left 和 right作为窗口的边界。
思路是，将两个指针都设定在位置 0， 然后向右移动 right 指针，直到 窗口内不超过两个不同的字符。
如果某一点我们得到了 3 个不同的字符， 那么需要移动 left指针，窗口里最多只能有 2 个不同的字符。
     */
    //时间复杂度：O(N)，其中N 是输入字符串中的字符数量。
    //空间复杂度：O(1)，因为额外 的空间只用于最多含有 3 个元素的哈希表。
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        // 滑动窗口的左右指针
        int left = 0;
        int right = 0;
        // hashmap 中的字符 -> 它在滑动窗口中最靠右的位置
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            // 当滑动窗口包含小于 3 个字符
            hashmap.put(s.charAt(right), right++);

            // 滑动窗口包含 3 个字符
            if (hashmap.size() == 3) {
                // 删除最左边的字符
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // 删除滑动窗口的左指针
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}
