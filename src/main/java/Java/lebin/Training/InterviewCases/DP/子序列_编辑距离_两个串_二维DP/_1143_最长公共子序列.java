package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 */
public class _1143_最长公共子序列 {
	/*
	1.dp定义
		dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j];
	2.递推公式
		如果text1[i - 1] 与 text2[j - 1]相同，dp[i][j] = dp[i - 1][j - 1] + 1;
		如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
		即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
	3. 确定遍历顺序
		i 从上向下；j 从左往右
	4. 初始化
		先看看dp[i][0]应该是多少呢？
		test1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;同理dp[0][j]也是0。
		其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0。
	 */
	//时间复杂度：O(mn)
	//空间复杂度：O(mn)
	public static  int longestCommonSubsequence(String text1, String text2) {
		if(null == text1||null == text2||text1.length()==0||text2.length()==0) return 0;
		char[] text1arr = text1.toCharArray();
		char[] text2arr = text2.toCharArray();
		int m = text1arr.length;//行
		int n = text2arr.length;//列
		//定义dp数组，dp[i][j] 表示当前s[0,...,i]与s[0,...,j]的LCS。
		int[][] dp = new int[m+1][n+1];
		//base case
		for(int j=0;j<n+1;j++){
			dp[0][j] = 0;//行为空串，lcs=0
		}
		for(int i=0;i<m+1;i++){
			dp[i][0] = 0;//列为空串，lcs=0
		}
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
				if(text1arr[i-1] == text2arr[j-1]){//相同的话直接加一
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}

			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
//		int len = longestCommonSubsequence(new int[] {1, 3, 5, 9, 10}, new int[] {1, 4, 9, 10});
//		System.out.println(len);
	}
}
