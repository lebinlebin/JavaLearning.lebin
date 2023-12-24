package Java.lebin.Training.InterviewCases.DP.跳台阶_斐波那契;
/*
斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
也就是： F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n) 。
示例 1：
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 */
/*
1. dp定义
	dp[i]的定义为：第i个数的斐波那契数值是dp[i]
2. 递推公式
	状态转移方程 dp[i] = dp[i - 1] + dp[i - 2];
3. 初始化
	dp[0] = 0;
	dp[1] = 1;
4. 确定遍历顺序
	从递归公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
 */
public class _509_斐波那契数 {
    //非压缩状态的版本
//    时间复杂度：O(n)
//    空间复杂度：O(n)
    public static int fib1(int N) {
        if (N <= 1) return N;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    //    时间复杂度：O(N)
    //    空间复杂度：O(1)
    //我们只需要维护两个数值就可以了，不需要记录整个序列。
    //压缩状态的版本
    public  static int fib3(int N) {
        if (N <= 1) return N;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
    /*
    递归解法
    时间复杂度：O(2^n)
    空间复杂度：O(n)，算上了编程语言中实现递归的系统栈所占空间
     */
    public  static int fib(int N) {
        if (N < 2) return N;
        return fib(N - 1) + fib(N - 2);
    }

    //    时间复杂度：O(N)
    //    空间复杂度：O(1)
    //我们只需要维护两个数值就可以了，不需要记录整个序列。
    //压缩状态的版本
    public static  int fib2(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib3(4));
    }
}
