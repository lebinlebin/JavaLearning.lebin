package Java.lebin.Training.InterviewCases.SortArray.最大连续1的个数;
/*
给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。

示例 1：
输入：nums = [1,0,1,1,0]
输出：4
解释：翻转第一个 0 可以得到最长的连续 1。
     当翻转以后，最大连续 1 的个数为 4。
示例 2:
输入：nums = [1,0,1,1,0,1]
输出：4
 */
/*
最开始想着使用前缀和来做，后来发现使用滑动窗口是更简单的，思路如下：
只要窗口里面的 0 个数小于等于 1 个，那么就一直向右扩充 right 边界。
只要窗口里面的 0 个数大于 1，那么就一直向右缩小 left 左边界。
每次扩充 right 边界时候，就需要检查更新窗口宽度，这样能够保证及时更新 ans 返回值。
 */
public class _487_最大连续1的个数II_最多可以翻转一个0 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        // 窗口的两个边界，以及 cnt 用来记录出现 0 的个数
        int left = 0, right = 0, cnt = 0;
        // 返回值
        int ans = 0;
        while (right < n) {
            // 只要右边界不越界，而且0的个数小于等于 1 个，那么就扩充右边界
            while (right < n && cnt <= 1) {
                if (nums[right] == 0) cnt++;
                right++;
                // 及时更新返回值
                if (cnt <= 1) ans = Math.max(right - left, ans);
            }
            // 向右缩小左边界，直到 0 的个数小于等于 1
            while (left <= right && cnt > 1) {
                if (nums[left] == 0) cnt--;
                left++;
            }
        }
        return ans;
    }
}
