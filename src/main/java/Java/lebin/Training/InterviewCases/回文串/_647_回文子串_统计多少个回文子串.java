package Java.lebin.Training.InterviewCases.回文串;
/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例 2：
输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
/*
1. dp定义
    布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
2. 确定递推公式
    s[i]与s[j]相等，s[i]与s[j]不相等这两种。
    1) 当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
    2) 当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
        情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
        情况二：下标i 与 j相差为1，例如aa，也是回文子串
        情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
        那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
 */
public class _647_回文子串_统计多少个回文子串 {
//    时间复杂度：O(n^2)
//    空间复杂度：O(n^2)
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //情况三
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
