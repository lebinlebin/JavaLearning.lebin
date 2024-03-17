package Java.lebin.Training.InterviewCases.回文串;
/*
算法：判断一个字符串最多只删1个字符，是否能成为一个回文字符串。
扩展  如果要返回最长的部分呢？
 */
public class 删除一个字符使之成为回文串的最长子串 {
    public static int longestPalindromeAfterDeletion(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;

        // dp[i][j] 表示 s[i..j] 是否是回文串（不删除字符）
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1; // 最长回文子串的长度（允许删除一个字符）

        // 初始化对角线上的单个字符为回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 检查所有长度为 2 的子串是否是回文
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // 检查更长的子串，考虑删除一个字符的情况
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 尝试删除区间内的一个字符来看是否能构成回文
                    dp[i][j] = isPalindromeAfterDeletion(s, i, j, dp);
                }
                if (dp[i][j]) {
                    maxLength = len; // 更新最长回文子串的长度
                }
            }
        }

        return maxLength;
    }

    // 辅助函数，检查删除区间 [start, end] 内的一个字符后是否能构成回文
    private static boolean isPalindromeAfterDeletion(String s, int start, int end, boolean[][] dp) {
        if (start >= end) return true; // 区间无效或只有一个字符，认为是回文
        if (s.charAt(start) == s.charAt(end)) return dp[start + 1][end - 1]; // 两端字符相等，检查内部子串
        if (dp[start + 1][end]) return true; // 删除左边字符后子串是回文
        if (dp[start][end - 1]) return true; // 删除右边字符后子串是回文
        return false; // 其他情况不是回文
    }

    public static void main(String[] args) {
        String testString = "abca";
        int result = longestPalindromeAfterDeletion(testString);
        System.out.println("The length of the longest palindrome substring after deletion is: " + result);
    }
}

