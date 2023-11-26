package Java.lebin.Training.DSA.Recursion;

public class ClimbStairs {
	
	int climbStairs(int n) {
		if (n <= 2) return n;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	static int climbStairs2(int n) {
		if (n == 0) return 0;
		int dp[] = new int[n];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<n;i++){
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs2(5));
	}
	
}
