package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;

/**
 * 最长公共子串（Longest Common Substring）
 * 子串是连续的子序列
 * 求两个字符串的最长公共子串长度ABCBA和BABCA的最长公共子串是ABC，长度为3
 */
public class LCSubstring_最长公共连续子串 {
	/**
	 * 假设2个字符串分别是str1、str2 i∈[1,str1.length]; j∈[1,str2.length]
	 * 1. dp[i,j]定义
	 * 	  dp(i,j)是以str1[i–1]、str2[j–1]结尾的最长公共子串长度
	 * 2. 递推公式
	 * 	  如果str1[i–1] = str2[j–1]，那么dp(i,j) = dp(i–1,j–1) + 1
	 * 	  如果str1[i–1] ≠ str2[j–1]，那么dp(i,j) = 0
	 * 	  最长公共子串的长度是所有dp(i,j)中的最大值max { dp(i,j) }
	 * 3. 确定遍历顺序 从左向右 从小到大
	 * 4. 初始化 dp(i, 0)、dp(0,j)初始值均为0
	 */
	static int lcs1(String str1, String str2) {
		if (str1 == null || str2 == null) return 0;
		char[] chars1 = str1.toCharArray();
		if (chars1.length == 0) return 0;
		char[] chars2 = str2.toCharArray();
		if (chars2.length == 0) return 0;

		//定义dp数组，为了方便；dp数据和字符串位置对应。dp数组从1开始，0的位置为base case； 原始数据str1和str2的下标从0开始。
		// 为了能访问到n，位置定义为1->n共n个数
		int[][] dp = new int[chars1.length + 1][chars2.length + 1];
		int max = 0;
		for (int i = 1; i <= chars1.length; i++) {
			for (int j = 1; j <= chars2.length; j++) {

				if (chars1[i - 1] == chars2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					//如果两个字符不相同，那么根据定义
					//dp(i,j)是以str1[i–1]、str2[j–1]结尾的最长公共子串长度为0
					dp[i][j] = 0;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lcs1("ABDCBA", "ABBA"));
	}

}
