package Java.lebin.Training.InterviewCases.binarySearch;

/**
 剑指 Offer 57. 和为s的两个数字
 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 与两数之和不同的是，这里是递增排序的数组，因此用二分查找思想进行求解
 示例 1：
 输入：nums = [2,7,11,15], target = 9
 输出：[2,7] 或者 [7,2]
 */
//时间复杂度 O(N) ： N 为数组的长度；双指针共同线性遍历整个数组。
//空间复杂度 O(1) ： 变量 i, j 使用常数大小的额外空间。

public class 剑指Offer57_递增排序的数组中查找和为s的两个数 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int s = nums[left] + nums[right];
            if(s < target) left++;
            else if(s > target) right--;
            else return new int[] { nums[left], nums[right] };
        }
        return new int[0];
    }
}
