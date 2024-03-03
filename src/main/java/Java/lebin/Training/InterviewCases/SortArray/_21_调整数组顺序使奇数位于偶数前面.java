package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/**
 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 示例：
 输入：nums = [1,2,3,4]
 输出：[1,3,2,4] 注：[3,1,2,4] 也是正确的答案之一。
 */
public class _21_调整数组顺序使奇数位于偶数前面 {
//    时间复杂度：O(N)
//    空间复杂度：O(1)
    public static  int[] exchange(int[] nums) {
        /*
        从左向右找偶数;从右向左找奇数;然后进行交换
         */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {//从左向右找偶数，左边的偶数
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {//从右向左找奇数，右边的奇数
                right--;
            }

            if (left < right) {//交换右边的奇数到左边的偶数
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }
}
