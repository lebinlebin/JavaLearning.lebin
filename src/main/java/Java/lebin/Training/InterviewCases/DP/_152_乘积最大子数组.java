package Java.lebin.Training.InterviewCases.DP;

/**
 152. 乘积最大子数组 子数组是需要连续的
 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 示例 1:
 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。

 示例 2:
 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class _152_乘积最大子数组 {
	//渐进时间复杂度和渐进空间复杂度都是 O(n)
	public static int maxProduct(int[] nums) {
		int length = nums.length;
		int[] DPmax = new int[length];
		int[] DPmin = new int[length];
		System.arraycopy(nums, 0, DPmax, 0, length);
		System.arraycopy(nums, 0, DPmin, 0, length);
		for (int i = 1; i < length; ++i) {
			DPmax[i] = Math.max( DPmax[i - 1] * nums[i], Math.max(nums[i], DPmin[i - 1] * nums[i]) );
			DPmin[i] = Math.min( DPmin[i - 1] * nums[i], Math.min(nums[i], DPmax[i - 1] * nums[i]) );
		}
		int ans = DPmax[0];
		for (int i = 1; i < length; ++i) {
			ans = Math.max(ans, DPmax[i]);
		}
		return ans;
	}


	/*
	考虑优化空间。
     由于第 i 个状态只和第 i−1 个状态相关，根据「滚动数组」思想，我们可以只用两个变量来维护i−1 时刻的状态，一个维护fmax，一个维护fmin
	 */
	public static int maxProduct_(int[] nums) {
		int  DPmax = nums[0];
		int  DPmin = nums[0];
		int ans = nums[0];
		int length = nums.length;
		for (int i = 1; i < length; ++i) {
			int max = DPmax, min = DPmin;
			DPmax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
			DPmin = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
			ans = Math.max(DPmax, ans);
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{2,3,-2,4};
		System.out.println(maxProduct_(nums));
	}
}
