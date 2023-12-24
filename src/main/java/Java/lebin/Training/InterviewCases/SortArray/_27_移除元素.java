package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
  */
public class _27_移除元素 {
    //双指针法
    // 时间复杂度 O(n)
    // 空间复杂度0(1)
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                System.out.println("----------");
                System.out.println(fastIndex);
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }



    //暴力解法
    //时间复杂度 O(n^2)
    // 空间复杂度0(1)
    public static int removeElement2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下表i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        System.out.println(removeElement(nums,2));
        System.out.println(removeElement2(nums,2));

    }
}
