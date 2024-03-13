package Java.lebin.Training.InterviewCases.MathOperator.乘积最大子数组;

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
	/*
	以下标 i 结尾的连续子序列的乘积的最大值。
	最后把整个 dp 数组看一遍求最大值即可。因此状态转移方程可能是：dp[i] = max(dp[i - 1] * nums[i], nums[i])
如果 dp[i - 1] 是负数，乘上 nums[i] 还是负数，倒不如另起炉灶。
如果 nums[i] 是负数该怎么办呢 ？dp[i - 1] 是正数的时候，越乘越小，dp[i - 1] 是负数的时候，越乘越大，
遇到这样的问题，其实就在提示我们状态不够用了。因此，需要在原来的一维 dp 后面新增一个状态。
针对这道题，第 2 维状态只需要两个：
	用 0 表示遍历的过程中得到的以 nums[i] 结尾的连续子序列的乘积的最小值；
	用 1 表示遍历的过程中得到的以 nums[i] 结尾的连续子序列的乘积的最大值。
====>
dp[i][1] 表示：以 nums[i] 结尾的连续子序列的乘积的最大值；
dp[i][0] 表示：以 nums[i] 结尾的连续子序列的乘积的最小值。
	 */
	//时间复杂度：O(N)，这里 N 表示数组的长度；
	//空间复杂度：O(N)，使用了两个状态数组，每一个数组的规模是 N。
	public static int maxProduct(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}

		// 状态定义：以索引 i 结尾
		int[][] dp = new int[len][2];

		dp[0][0] = nums[0];
		dp[0][1] = nums[0];

		for (int i = 1; i < len; i++) {
			if (nums[i] >= 0) {
				dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
				dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
			} else {
				dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
				dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
			}
		}

		int res = dp[0][1];
		for (int i = 1; i < len; i++) {
			res = Math.max(res, dp[i][1]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
}
