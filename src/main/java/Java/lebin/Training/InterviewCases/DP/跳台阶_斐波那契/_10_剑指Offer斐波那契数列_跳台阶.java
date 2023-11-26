package Java.lebin.Training.InterviewCases.DP.跳台阶_斐波那契;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
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
public class _10_剑指Offer斐波那契数列_跳台阶 {
	//时间复杂度：O(n)。
	//空间复杂度：O(n)。
	public int fibDP(int n) {
	if(n==0){ return 0; }
	if(n==1||n==2) {return 1;}

	int[] dp = new int[n+1];//

	for(int i = 3; i <= n; i++){
		dp[i] = dp[i-1] + dp[i-2];
	}
		return dp[n];
	}
	//压缩
	//时间复杂度：O(n)。
	//空间复杂度：O(1)。
	public int fib(int n) {
		int first = 0;
		int second = 1;
		if(n==0){return first;}
		if(n==1){return second;}

		int result = 0;
		for(int i=2;i<=n;i++){
			result = first + second;
			if(result >= 1000000007){
				result -= 1000000007;
			}
			first = second;
			second = result;
		}
		return result;
	}
}
