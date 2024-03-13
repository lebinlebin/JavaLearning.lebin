package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;

/*
583. 两个字符串的删除操作
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
示例：
输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */
/*
1. dp定义
    dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。这里是次数!!!
2. 递推公式
    1) 当word1[i - 1] 与 word2[j - 1]相同的时候，dp[i][j] = dp[i - 1][j - 1];不需要删除
    2) 当word1[i - 1] 与 word2[j - 1]不相同的时候，有三种情况：
        情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
        情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
        情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
    取最小值，dp[i][j] = min({dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1, dp[i][j - 1] + 1});
    因为 dp[i][j - 1] + 1 = dp[i - 1][j - 1] + 2，可简化为：dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
3. 初始化
    从递推公式中，可以看出来，dp[i][0] 和 dp[0][j]是一定要初始化的。
    dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i。
    dp[0][j]同理
4.遍历顺序
    从上到下，从左到右
 */
//时间复杂度: O(n * m)
// 空间复杂度: O(n * m)
public class _583_两个字符串的删除操作_把word1变成word2 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
