package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;
/*
115.不同的子序列
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 */
public class _115_不同的子序列 {
/*
不需要连续!!!  一句话: s有多少种删除元素的方式，使s变成t，输出方式的个数。这里相比编辑距离问题，会简单很多，因为只有删除一种操作
1. dp定义
    dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
    以i-1为结尾的s子序列 有多少删除元素的方式使之变成以j-1为结尾的t。
2. 确定递推公式
    当s[i - 1] 与 t[j - 1]相等时，
        1) 用s[i - 1]来匹配，个数为dp[i - 1][j - 1]。即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
        2) 不用s[i - 1]来匹配，个数为dp[i - 1][j]。
        所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    当s[i - 1] 与 t[j - 1]不相等时，dp[i][j]只有一部分组成，不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：dp[i - 1][j]
        所以递推公式为：dp[i][j] = dp[i - 1][j];
3. 初始化
    从递推公式看出dp[i][j] 是从上方和左上方推导而来，那么 dp[i][0] 和dp[0][j]是一定要初始化的。
    1) dp[i][0]表示什么呢？表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。那么dp[i][0]一定都是1，出现空字符串的只有一种方式就是删除所有元素。
    2) dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。dp[0][j]一定都是0，s如论如何也变成不了t。
    3)：dp[0][0] 应该是多少。dp[0][0]应该是1，空字符串s，可以删除0个元素，变成空字符串t。
    */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
