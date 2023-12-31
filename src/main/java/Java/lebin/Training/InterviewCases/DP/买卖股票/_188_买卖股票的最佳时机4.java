package Java.lebin.Training.InterviewCases.DP.买卖股票;

/**
 188.买卖股票的最佳时机IV
 力扣题目链接(opens new window)
 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 */
/*
确定dp数组以及下标的含义
在动态规划：123.买卖股票的最佳时机III (opens new window)中，我是定义了一个二维dp数组，本题其实依然可以用一个二维dp数组。

使用二维数组 dp[i][j] ：第i天的状态为j，所剩下的最大现金是dp[i][j]

j的状态表示为：

0 表示不操作
1 第一次买入
2 第一次卖出
3 第二次买入
4 第二次卖出
.....
大家应该发现规律了吧 ，除了0以外，偶数就是卖出，奇数就是买入。

题目要求是至多有K笔交易，那么j的范围就定义为 2 * k + 1 就可以了。

所以二维dp数组的C++定义为：

vector<vector<int>> dp(prices.size(), vector<int>(2 * k + 1, 0));
确定递推公式
还要强调一下：dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票，这是很多同学容易陷入的误区。

达到dp[i][1]状态，有两个具体操作：

操作一：第i天买入股票了，那么dp[i][1] = dp[i - 1][0] - prices[i]
操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
选最大的，所以 dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1]);

同理dp[i][2]也有两个操作：

操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
所以dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])

同理可以类比剩下的状态，代码如下：

for (int j = 0; j < 2 * k - 1; j += 2) {
    dp[i][j + 1] = max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
    dp[i][j + 2] = max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
}
本题和动态规划：123.买卖股票的最佳时机III (opens new window)最大的区别就是这里要类比j为奇数是买，偶数是卖的状态。

dp数组如何初始化
第0天没有操作，这个最容易想到，就是0，即：dp[0][0] = 0;

第0天做第一次买入的操作，dp[0][1] = -prices[0];

第0天做第一次卖出的操作，这个初始值应该是多少呢？

此时还没有买入，怎么就卖出呢？ 其实大家可以理解当天买入，当天卖出，所以dp[0][2] = 0;

第0天第二次买入操作，初始值应该是多少呢？应该不少同学疑惑，第一次还没买入呢，怎么初始化第二次买入呢？

第二次买入依赖于第一次卖出的状态，其实相当于第0天第一次买入了，第一次卖出了，然后在买入一次（第二次买入），那么现在手头上没有现金，只要买入，现金就做相应的减少。

所以第二次买入操作，初始化为：dp[0][3] = -prices[0];

第二次卖出初始化dp[0][4] = 0;

所以同理可以推出dp[0][j]当j为奇数的时候都初始化为 -prices[0]

代码如下：

for (int j = 1; j < 2 * k; j += 2) {
    dp[0][j] = -prices[0];
}
在初始化的地方同样要类比j为偶数是卖、奇数是买的状态。

确定遍历顺序
从递归公式其实已经可以看出，一定是从前向后遍历，因为dp[i]，依靠dp[i - 1]的数值。
 */
public class _188_买卖股票的最佳时机4 {
	// 版本一: 三维 dp数组
	public int maxProfit1(int k, int[] prices) {
		if (prices.length == 0) return 0;

		// [天数][交易次数][是否持有股票]
		int len = prices.length;
		int[][][] dp = new int[len][k + 1][2];

		// dp数组初始化
		// 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
		for (int i = 0; i <= k; i++) {
			dp[0][i][1] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 1; j <= k; j++) {
				// dp方程, 0表示不持有/卖出, 1表示持有/买入
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
			}
		}
		return dp[len - 1][k][0];
	}

	// 版本二: 二维 dp数组
	public int maxProfit2(int k, int[] prices) {
		if (prices.length == 0) return 0;

		// [天数][股票状态]
		// 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
		int len = prices.length;
		int[][] dp = new int[len][k*2 + 1];

		// dp数组的初始化, 与版本一同理
		for (int i = 1; i < k*2; i += 2) {
			dp[0][i] = -prices[0];
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < k*2 - 1; j += 2) {
				dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
				dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
			}
		}
		return dp[len - 1][k*2];
	}

	//版本三：一维 dp数组 (下面有和卡哥邏輯一致的一維數組JAVA解法)
	public int maxProfit3(int k, int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		if(k == 0){
			return 0;
		}
		// 其实就是123题的扩展，123题只用记录2次交易的状态
		// 这里记录k次交易的状态就行了
		// 每次交易都有买入，卖出两个状态，所以要乘 2
		int[] dp = new int[2 * k];
		// 按123题解题格式那样，做一个初始化
		for(int i = 0; i < dp.length / 2; i++){
			dp[i * 2] = -prices[0];
		}
		for(int i = 1; i <= prices.length; i++){
			dp[0] = Math.max(dp[0], -prices[i - 1]);
			dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
			// 还是与123题一样，与123题对照来看
			// 就很容易啦
			for(int j = 2; j < dp.length; j += 2){
				dp[j] = Math.max(dp[j], dp[j - 1] - prices[i-1]);
				dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i - 1]);
			}
		}
		// 返回最后一次交易卖出状态的结果就行了
		return dp[dp.length - 1];
	}
}


