package Java.lebin.Training.InterviewCases.DP.买卖股票;

import java.util.Arrays;


/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */

public class _121_买卖股票的最佳时机 {

	/*
	1. dp定义
		dp[i][0] 表示第i天持有股票所得最多现金
		dp[i][1] 表示第i天不持有股票所得最多现金
		这里可能有同学疑惑，本题中只能买卖一次，持有股票之后哪还有现金呢？其实一开始现金是0，那么假如第i天买入股票现金就是 -prices[i]， 这是一个负数。
	2.递推公式
		如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
			1) 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
			2) 第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
			那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], -prices[i]);
		如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
			1) 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
			2) 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
			同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
	3. 初始化
		都是要从dp[0][0]和dp[0][1]推导出来。
		dp[0][0]表示第0天持有股票，此时的持有股票就一定是买入股票了，所以dp[0][0] -= prices[0];
		dp[0][1]表示第0天不持有股票，不持有股票那么现金就是0，所以dp[0][1] = 0;

	4. 遍历顺序
		从递推公式可以看出dp[i]都是由dp[i - 1]推导出来的，那么一定是从前向后遍历。
	 */
	//时间复杂度：O(n)
	//空间复杂度：O(n)
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int length = prices.length;
		// dp[i][0]代表第i天持有股票的最大收益
		// dp[i][1]代表第i天不持有股票的最大收益
		int[][] dp = new int[length][2];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		for (int i = 1; i < length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
		}
		return dp[length - 1][1];
	}

	//时间复杂度：O(n)
	//空间复杂度：O(1)
	//滚动数组
	public int maxProfit2(int[] prices) {
		int len = prices.length;
		int dp[][] = new int[2][2];

		dp[0][0] = - prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < len; i++){
			dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], - prices[i]);
			dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
		}
		return dp[(len - 1) % 2][1];
	}
}


