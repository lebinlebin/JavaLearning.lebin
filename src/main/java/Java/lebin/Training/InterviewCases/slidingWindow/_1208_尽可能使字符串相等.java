package Java.lebin.Training.InterviewCases.slidingWindow;
/*
给你两个长度相同的字符串，s 和 t。
将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

示例 1：
输入：s = "abcd", t = "bcdf", maxCost = 3
输出：3
解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
示例 2：
输入：s = "abcd", t = "cdef", maxCost = 3
输出：1
解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
示例 3：
输入：s = "abcd", t = "acde", maxCost = 0
输出：1
解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 */
public class _1208_尽可能使字符串相等 {
    //方法一：前缀和 + 二分查找
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] preSum = new int[len + 1];

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + Math.abs(sCharArray[i] - tCharArray[i]);
        }
        int res = 0;
        // 注意这里的 i 是偏移，是开区间
        // 每一个 i 都有一个最左边的 start
        for (int i = 1; i <= len; i++) {
            int begin = binarySearch(preSum, i, preSum[i] - maxCost);
            res = Math.max(res, i - begin);
        }
        return res;
    }

    /**
     * 区间和要大于等于 target
     *
     * @param preSum
     * @param endIndex 就是 i
     * @param target
     * @return
     */
    public int binarySearch(int[] preSum, int endIndex, int target) {
        int left = 0;
        int right = endIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    //滑动窗口
    //这题与之前的差别就在于，每一次转换的耗费是预处理的。
    public int equalSubstring2(String s, String t, int maxCost) {
        int len = s.length();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] distance = new int[len];
        // 预处理
        for (int i = 0; i < len; i++) {
            distance[i] = Math.abs(sCharArray[i] - tCharArray[i]);
        }

        int left = 0;
        int right = 0;
        int windowSum = 0;
        int res = 0;
        while (right < len) {
            windowSum += Math.abs(distance[right]);
            right++;

            while (windowSum > maxCost) {
                windowSum -= distance[left];
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
