package Java.lebin.Training.InterviewCases.各种k个数;
/*
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
示例 1：
输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：
输入：nums = [1,2,3], k = 0
输出：0
 */
/*
关键 1：如果一个连续子数组的所有元素的乘积都严格小于 k，那么这个 **连续子数组的子集（同样也得保证是连续子数组）的乘积也一定严格小于 k**。
原因我们在「关键字」里也向大家强调过，数组里的所有元素都是正整数。
关键 2：如果某个连续子数组的乘积大于等于 k，包含它的更长的子数组一定也不满足。
基于以上两点，我们可以设计「滑动窗口」算法。因此「滑动窗口」方法是「暴力解法」的优化。
因此我们可以使用「滑动窗口」找到 最大可以撑开的 窗口的长度，然后一下子计算出此时符合题意的子数组的个数。
如何计数：计数的时候关键要做到 不重不漏。
 */
//时间复杂度：O(N)，这里 N 是输入数组的长度。right 需要遍历输入数组一次，绝大多数情况下，left 还没有遍历到输入数组的末尾就停了下来。
public class _713_乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 特殊用例判断
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int product = 1;
        // 循环不变量：nums[left..right) 里所有元素的乘积严格小于 k
        while (right < len) {
            product *= nums[right];
            right++;
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left);
        }
        return count;
    }
}
