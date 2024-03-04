package Java.lebin.Training.InterviewCases.SortArray;
/*
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
示例 1：
输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
示例 2:
输入：nums = [1,0,1,1,0,1]
输出：2
 */
//时间复杂度：O(n)，其中 n 是数组的长度。需要遍历数组一次。
//空间复杂度：O(1)。
public class _485_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
