package Java.lebin.Training.InterviewCases.sort;
import java.util.Random;

/*
给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
 */
//时间复杂度：O(NlogN)，
// 空间复杂度：O(logN)，这里占用的空间主要来自递归函数的栈空间。
public class _912_排序数组_快速排序_三路快排 {
    private final static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // [left..right]
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];

        int lt = left + 1; // lt: less than
        int gt = right; // ge: greater than
        // all in nums[left + 1..lt) < pivot
        // all in nums[lt..i) = pivot
        // all in nums(gt..right] > pivot
        int i = left + 1;

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                // nums[i] > pivot
                swap(nums, i, gt);
                gt--;
            }
        }

        swap(nums, left, lt - 1);

        quickSort(nums, left, lt - 2);
        quickSort(nums, gt + 1, right);
    }



    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
}
