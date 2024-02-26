package Java.lebin.Training.InterviewCases.SortArray;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
 */
//时间复杂度：O(n)，其中 n 为序列长度。每个位置至多被遍历两次。
//空间复杂度：O(1)。只需要常数的空间存放若干变量。
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, zeroIndex = 0, noneZeroIndex = 0;
        while (noneZeroIndex < n) {//找到第一个为0的index
            if (nums[noneZeroIndex] != 0) {//right在不断地找非零元素，left一直标记左边第一个0的元素
                swap(nums, zeroIndex, noneZeroIndex);
                zeroIndex++;//找为0的index
            }
            noneZeroIndex++;//找不为0的index
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
