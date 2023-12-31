package Java.lebin.Training.InterviewCases.DP;

/**
 343. 整数拆分
 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 示例 1:
 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1。
 示例 2:
 输入: 10
 输出: 36
 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
/*
1. dp定义
    dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
2. 递推公式
    其实可以从1遍历j(j在1~i之间)，然后有两种渠道得到dp[i].
    一个是j * (i - j) 直接相乘。不拆分(i - j)
    一个是j * dp[i - j]，相当于是拆分(i - j)。
    也可以这么理解，j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘。
    递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
    //那么在取最大值的时候，为什么还要比较dp[i]呢？因为在递推公式推导的过程中，每次计算dp[i]，取最大的而已。
3. dp的初始化
    严格从dp[i]的定义来说，dp[0] dp[1] 就不应该初始化，也就是没有意义的数值。
    这里我只初始化dp[2] = 1，从dp[i]的定义来说，拆分数字2，得到的最大乘积是1，这个没有任何异议！
4. 确定遍历顺序
    从前向后遍历
 */
//时间复杂度：O(n)
//空间复杂度：O(1)
public class _343_整数拆分 {
    public int integerBreak(int n) {
        //dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp = new int[n+1];
        dp[2] = 1;//dp[0] dp[1] 就不应该初始化，也就是没有意义的数值。
        //这里我只初始化dp[2] = 1，从dp[i]的定义来说，拆分数字2，得到的最大乘积是1，这个没有任何异议！
        for(int i = 3; i <= n; i++){//先有dp[i]才能有dp[n],因此i递增到n
            for(int j = 1; j < i - 1; j++){//每次都让j从1开始到i-1结束来计算dp[i]
                //j*(i-j)代表把i拆分为j和i-j两个数相乘，
                //j*dp[i-j]代表把i拆分为j和把i-j这个数继续拆分求i-j的乘积最大值dp[i-j]
                dp[i] = Math.max(dp[i],Math.max(j * (i-j),j*(dp[i-j])));
            }
        }
        return dp[n];
    }
}
