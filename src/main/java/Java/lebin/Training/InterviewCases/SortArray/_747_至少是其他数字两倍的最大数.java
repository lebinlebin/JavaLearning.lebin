package Java.lebin.Training.InterviewCases.SortArray;
/*
给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。

示例 1：
输入：nums = [3,6,1,0]
输出：1
解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
示例 2：

输入：nums = [1,2,3,4]
输出：-1
解释：4 没有超过 3 的两倍大，所以返回 -1 。
 */
/*
思路与算法
遍历数组分别找到数组的最大值 m1 和次大值 m2。如果 m1≥m2 ×2 成立，则最大值至少是数组其余数字的两倍，此时返回最大值的下标，否则返回 −1。
 */
//时间复杂度：O(N)，其中 N 是数组的长度。遍历整个数组需要 O(N)
//空间复杂度：O(1)。
public class _747_至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int m1 = -1, m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if (nums[i] > m2) {
                m2 = nums[i];
            }
        }
        return m1 >= m2 * 2 ? index : -1;
    }
}
