package Java.lebin.Training.InterviewCases.DP.回文串;

/**
 516.最长回文子序列
 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。
 示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
 */
public class _516_最长回文子序列 {

/*
1. dp定义
	dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
2. 递推公式
	在判断回文子串的题目中，关键逻辑就是看s[i]与s[j]是否相同。
	1）如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
	2) 如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
		加入s[j]的回文子序列长度为dp[i + 1][j]。
		加入s[i]的回文子序列长度为dp[i][j - 1]。
	那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
3. 初始化
	考虑当i 和j 相同的情况，从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2; 可以看出 递推公式是计算不到 i 和j相同时候的情况。
	所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。
	其他情况dp[i][j]初始为0就行，这样递推公式：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]); 中dp[i][j]才不会被初始值覆盖。
4. 确定遍历顺序
	从递归公式中，可以看出，dp[i][j] 依赖于 dp[i + 1][j - 1] ，dp[i + 1][j] 和 dp[i][j - 1]，j从左向右；i从下向上
时间复杂度: O(n^2)
空间复杂度: O(n^2)
 */
public static  int longestPalindromeSubseq(String s) {
	int len = s.length();
	int[][] dp = new int[len + 1][len + 1];
	//两层for循环不可颠倒
	for (int i = len - 1; i >= 0; i--) { // i从下向上
		dp[i][i] = 1; // 初始化
		for (int j = i + 1; j < len; j++) {//j从左向右
			System.out.println(i+"--"+j);//i=j的时候已经初始化过了
			if (s.charAt(i) == s.charAt(j)) {
				dp[i][j] = dp[i + 1][j - 1] + 2;
			} else {
				dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
			}
		}
	}
	return dp[0][len - 1];
}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("abcabcabc"));
	}
}
