package Java.lebin.Training.InterviewCases.DP.跳台阶_斐波那契;

public class _70_爬楼梯 {
    // 常规方式
    //时间复杂度为 O(n)。
    //空间复杂度 O(n)。
    public int climbStairs(int n) {
        if(n<=1) return n;//因为下边直接怼dp[2]操作了，防止空指针
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {//注意i从3开始的
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //优化版本
    //时间复杂度为 O(n)。
    //空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)
    public int climbStairs2(int n) {
        if(n <= 2) return n;
        int a = 1, b = 2, sum = 0;

        for(int i = 3; i <= n; i++){
            sum = a + b;  // f(i - 1) + f(i - 2)
            a = b;        // 记录f(i - 1)，即下一轮的f(i - 2)
            b = sum;      // 记录f(i)，即下一轮的f(i - 1)
        }
        return b;
    }
}
