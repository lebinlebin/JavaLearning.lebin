package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class _665_非递减数列_改变一个元素非递减数列 {
//	时间复杂度：O(n)，其中 n 是数组 nums 的长度。
//	空间复杂度：O(1)。
public boolean checkPossibility(int[] nums) {
	if(nums==null||nums.length==1)return true;
	int n = nums.length;

	for (int i = 0; i < n-1; i++) {
		if(nums[i+1]<nums[i]){
			int tmp = nums[i];
			nums[i] = nums[i+1];

			if(issort(nums)){
				return true;
			}
			//复原
			nums[i] = tmp;

			nums[i+1] = tmp;
			if(issort(nums)){
				return true;
			}else {return false;}

		}
	}
	return true;
}
	private  boolean issort(int[] nums){
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]>nums[i+1]){
				return false;
			}
		}
		return true;
	}
}
