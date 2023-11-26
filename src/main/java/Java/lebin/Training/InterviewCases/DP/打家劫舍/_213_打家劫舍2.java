package Java.lebin.Training.InterviewCases.DP.打家劫舍;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 */
//与打家劫舍1的区别:所有的房屋都 围成一圈 ； 规则还是相邻的房间不能偷
public class _213_打家劫舍2 {
	/*
    1. dp定义
        dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
    2. 递推公式
        决定dp[i]的因素就是第i房间偷还是不偷。
        如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i]
        如果不偷第i房间，那么dp[i] = dp[i - 1]
        然后dp[i]取最大值，即dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
    3. 初始化
        从递推公式dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);可以看出，递推公式的基础就是dp[0] 和 dp[1]
        从dp[i]的定义上来讲，dp[0] 一定是 nums[0]，dp[1]就是nums[0]和nums[1]的最大值即：dp[1] = max(nums[0], nums[1]);
    4. 遍历顺序
        从前到后遍历
     */
	//搜索两次，第一次不加尾，第二次不加头，取最大即可。
	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int n = nums.length - 1;
		int[] dp1 = new int[n];
		dp1[0] = nums[0];
		dp1[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
		}

		int[] dp2 = new int[n];
		dp2[0] = nums[n];
		dp2[1] = Math.max(nums[n], nums[n - 1]);
		for (int i = 2; i < n; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[n - i]);
		}
		return Math.max(dp1[n - 1], dp2[n - 1]);
	}
}
