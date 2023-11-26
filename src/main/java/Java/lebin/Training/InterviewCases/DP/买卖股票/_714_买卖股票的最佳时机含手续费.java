package Java.lebin.Training.InterviewCases.DP.买卖股票;

/**
 714.买卖股票的最佳时机含手续费
 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 返回获得利润的最大值。
 */
//时间复杂度：O(n)
//空间复杂度：O(n)
//和动态规划：122.买卖股票的最佳时机II (opens new window)的区别就是这里需要多一个减去手续费的操作。
public class _714_买卖股票的最佳时机含手续费 {
	// 时间复杂度：O(n)，空间复杂度：O(n)
	public int maxProfit(int[] prices,int fee) {
		int length = prices.length;
		// dp[i][0]代表第i天持有股票的最大收益
		// dp[i][1]代表第i天不持有股票的最大收益
		int[][] dp = new int[length][2];
		int result = 0;
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
		}
		return dp[(length - 1) ][1];// 卖出股票收益高于持有股票收益，因此取[0]
	}
}


