package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
//时间复杂度：O(m+n)。 指针移动单调递减，最多移动 m+n 次，因此时间复杂度为 O(m+n)。
//空间复杂度：O(1)。 直接对数组 nums1 原地修改，不需要额外空间。
public class _88_合并两个有序数组_归并排序 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		// nums1 = [1,3,5,0,0,0], m = 3
		// nums2 = [2,4,6],       n = 3
		int i1 = m - 1;
		int i2 = n - 1;
		int cur = nums1.length - 1;

		while (i2 >= 0) {
			//nums2[i2] nums2的最大值   nums1的最大值  那么 把nums1 的最后一个元素放到cur指向的末尾
			if (i1 >= 0 && nums2[i2] < nums1[i1]) {
				nums1[cur] = nums1[i1];
				cur--;
				i1--;
			} else { // i1 < 0 || nums2[i2] >= nums1[i1]
				nums1[cur] = nums2[i2];
				cur--;
				i2--;
			}
		}
	}

	public static void main(String[] args) {
    	int[] nums1 = new int[]{1,2,3,0,0,0};
		int[] nums2 = new int[]{2,5,6};
		merge(nums1,nums1.length-3,nums2,nums2.length);
		System.out.println(Arrays.toString(nums1));
	}
}
