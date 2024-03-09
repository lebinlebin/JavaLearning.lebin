package Java.lebin.Training.InterviewCases.sort;
/*
给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
 */
public class _912_排序数组_快速排序_修改循环不变量的定义 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left + 1;//j标记第二个区间的第一个元素，那么j-1就是第一个排序部分的最后一个位置
        // all in nums[left + 1..j) <= pivot
        // all in nums[j..i) > pivot
        for (int i = left + 1; i <= right; i++){
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, left, j - 1);
        return j - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
}
