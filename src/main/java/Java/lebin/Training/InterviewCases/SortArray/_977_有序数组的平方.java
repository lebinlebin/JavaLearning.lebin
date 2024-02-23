package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/*
977.有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
#
 */
public class _977_有序数组的平方 {
    //双指针
    //时间复杂度为O(n)
    //空间复杂度 O(1)
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;//关键
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
    //时间复杂度：O(nlogn)，其中 nnn 是数组 nums 的长度。
    //空间复杂度：O(logn)。除了存储答案的数组以外，我们需要 O(logn) 的栈空间进行排序。
    public int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
