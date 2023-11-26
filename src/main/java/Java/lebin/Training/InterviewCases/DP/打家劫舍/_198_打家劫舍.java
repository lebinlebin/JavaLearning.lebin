package Java.lebin.Training.InterviewCases.DP.打家劫舍;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
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
public class _198_打家劫舍 {
	//时间复杂度: O(n)
	//空间复杂度: O(n)
	//你面前房子的索引就是状态，抢和不抢就是选择。
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) { return 0; }
		//状态: 当前房屋的金额
		//选择: 偷或者不偷
		int length = nums.length;
		if (length == 1) { return nums[0]; }
		//定义dp[i] 表示当前房屋位置index=i下，所能获得最大金额
		//base case
		//dp[0] 最大金额就是nums[0]
		//dp[1] = max(dp[0],nums[1])
		//最终返回的结果就是dp[n-1]
		int[] dp = new int[length];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);
		//dp[2] = Math.max(dp[1], nums[2]+dp[i-2]);
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[length - 1];
	}
}
