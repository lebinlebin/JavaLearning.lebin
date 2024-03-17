package Java.lebin.Training.InterviewCases.DP.背包问题_零钱兑换_目标和_单词拆分;

/**
 * 322. 零钱兑换  每种硬币的数量是无限的
 * 求组合数，2，1，2和2，2，1是一样的
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
/*
题目中说每种硬币的数量是无限的，可以看出是典型的完全背包问题。
1. dp 定义
	dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
2. 递推公式
	凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，
	那么只需要加上一个钱币coins[i] 即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
	所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
	递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
3. 初始化
	首先凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0;
	其他下标对应的数值呢？
	考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖。
	所以下标非0的元素都是应该是最大值。
4. 确定遍历顺序
	本题求钱币最小个数，那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数。
 */
public class _322_零钱兑换1_01_背包问题 {
//	时间复杂度: O(n * amount)，其中 n 为 coins 的长度
//	空间复杂度: O(amount)
	public int coinChange(int[] coins, int amount) {
		int max = Integer.MAX_VALUE;
		int[] dp = new int[amount + 1];
		//初始化dp数组为最大值
		for (int j = 0; j < dp.length; j++) {
			dp[j] = max;
		}
		//当金额为0时需要的硬币数目为0
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			//正序遍历：完全背包每个硬币可以选择多次
			for (int j = coins[i]; j <= amount; j++) {
				//只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
				if (dp[j - coins[i]] != max) {
					//选择硬币数目最小的情况
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		return dp[amount] == max ? -1 : dp[amount];
	}
}
