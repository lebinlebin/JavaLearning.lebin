package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;

/**
 1. dp定义
 	dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
	 用i-1就是为了方便后面dp数组初始化的。

2. 递推公式
 在确定递推公式的时候，首先要考虑清楚编辑的几种操作，整理如下：
 if (word1[i - 1] == word2[j - 1])
 不操作 ===> dp[i][j] = dp[i - 1][j - 1];
 if (word1[i - 1] != word2[j - 1])
 增
 删
 换
 也就是如上4种情况。
 if (word1[i - 1] != word2[j - 1])，此时就需要编辑了，如何编辑呢？
	 1）操作一：word1删除一个元素，那么就是以下标i - 2 为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
	 	即 dp[i][j] = dp[i - 1][j] + 1;
	 2）操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
	 	即 dp[i][j] = dp[i][j - 1] + 1;
 	//这里有同学发现了，怎么都是删除元素，添加元素去哪了。word2添加一个元素，相当于word1删除一个元素，例如 word1 = "ad" ，word2 = "a"，word1删除元素'd' 和 word2添加一个元素'd'，变成word1="a", word2="ad"， 最终的操作数是一样！
 	3) 操作三：替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增删加元素。
 		所以 dp[i][j] = dp[i - 1][j - 1] + 1;
 综上，当 if (word1[i - 1] != word2[j - 1]) 时取最小的，即：dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1;
 3. 递推公式
 	dp[i][0] ：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。
 	那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，即：dp[i][0] = i;
 	同理dp[0][j] = j;
 4. 遍历顺序
 	从左到右从上到下
 */
public class _72_编辑距离 {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		// 初始化
		for (int i = 1; i <= m; i++) {
			dp[i][0] =  i;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 因为dp数组有效位从1开始
				// 所以当前遍历到的字符串的位置为i-1 | j-1
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
				}
			}
		}
		return dp[m][n];
	}
}
