package Java.lebin.Training.InterviewCases.characterString;
/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
示例 3：
输入：s = ""
输出：0
 */
//时间复杂度： O(n)
//空间复杂度： O(n)
/*
1. 定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度.
2. dp 数组全部初始化为 0
3. 有效的子串一定以 ‘)’ 结尾，因此我们可以知道以 ‘(’结尾的子串对应的 dp 值必定为 0 ，
我们只需要求解 ‘)’ 在 dp 数组中对应位置的值。
4. 递推公式:
    s[i]=‘)’ 且 s[i−1]=‘(’，也就是字符串形如 “……()”，我们可以推出：dp[i]=dp[i−2]+2
    s[i]=‘)’且 s[i−1]=‘)’，也就是字符串形如 “……))”，我们可以推出：
        如果 s[i−dp[i−1]−1]=‘(’，那么  dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2

 */
public class _32_最长有效括号 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
