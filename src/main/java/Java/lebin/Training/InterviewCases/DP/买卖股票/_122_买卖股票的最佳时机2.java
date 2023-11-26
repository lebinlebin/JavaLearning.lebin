package Java.lebin.Training.InterviewCases.DP.买卖股票;
/**
 * 不限制交易次数。k==无穷大
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
//区别是本题股票可以买卖多次了（注意只有一只股票，所以再次购买前要出售掉之前的股票）
public class _122_买卖股票的最佳时机2 {
	/*
	dp[i][0]
	唯一不同的地方，就是推导dp[i][0]的时候，第i天买入股票的情况。
	在121. 买卖股票的最佳时机 (opens new window)中，因为股票全程只能买卖一次，
	所以如果买入股票，那么第i天持有股票即dp[i][0]一定就是 -prices[i]。
	而本题，因为一只股票可以买卖多次，所以当第i天买入股票的时候，所持有的现金可能有之前买卖过的利润。
	那么第i天持有股票即dp[i][0]，如果是第i天买入股票，所得现金就是昨天不持有股票的所得现金 减去 今天的股票价格
	即：dp[i - 1][1] - prices[i]。

	dp[i][1]
	第i天不持有股票即dp[i][1]的情况， 依然可以由两个状态推出来
	第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
	第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
	 */

	// 时间复杂度：O(n)，空间复杂度：O(n)
	public int maxProfit(int[] prices) {
		int length = prices.length;
		// dp[i][0]代表第i天持有股票的最大收益
		// dp[i][1]代表第i天不持有股票的最大收益
		int[][] dp = new int[length][2];
		int result = 0;
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
		}
		return dp[(length - 1) ][1];// 卖出股票收益高于持有股票收益，因此取[0]
	}
}


