package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/**
 * 面试题 16.16. 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 从左向右寻找逆序对，从右向左寻找逆序对
 */
//时间复杂度 O(n)
// 空间复杂度O(1)
public class 部分排序_找出逆序区间使得整个数组有序 {
	/*
	双指针。 先找到两边第一个逆序的数字，最少要排序两指针中间的数才能有序。
	之后找出中间数的最大(max)最小(min)两值，和两边数字比对。 左边数字每大于min，减小左指针。
	右边数字每小于max，增大右指针。 最后返回两指针。
	 */
	public static int[] subSort(int[] array) {
		int n = array.length, left = 0, right = n - 1;
		while (left < right) {
			if (array[left] <= array[left + 1]) {
				++left;//先找到两边第一个逆序的数字
			}
			if (array[right] >= array[right - 1]) {
				--right;//先找到两边第一个逆序的数字
			}
			if (array[left] > array[left + 1] && array[right] < array[right - 1]) {
				break;
			}
		}
		// base case
		if (left >= right) {
			return new int[]{-1, -1};
		}
		//找出中间数的最大(max)最小(min)两值，和两边数字比对。
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = left; i <= right; ++i) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}

		while (left > 0 && array[left - 1] > min) {
			--left;
		}
		while (right < n - 1 && array[right + 1] < max) {
			++right;
		}
		return new int[]{left, right};
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
		System.out.println(Arrays.toString(subSort(nums)));
	}
}
