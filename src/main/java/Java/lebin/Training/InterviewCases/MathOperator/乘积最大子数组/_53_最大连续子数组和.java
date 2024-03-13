package Java.lebin.Training.InterviewCases.MathOperator.乘积最大子数组;

/**
 53. 最大子数组和
 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 子数组 是数组中的一个连续部分。
 示例 1：
 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class _53_最大连续子数组和 {
	/**
	 * 1.dp[i]代表以前下标i结尾的连续子数组最大和
	 * 2.递推公式 dp[i] = max (dp[i-1]+nums[i],nums[i]) res = max(res,dp[i])
	 * 3.初始化 都为 0
	 * 4.遍历方向，从前往后
	 * 5.举例推导结果。
	 */
	//时间复杂度：O(n)
	//空间复杂度：O(n)
	public static int maxSubArray(int[] nums) {
		if(null == nums||nums.length==0) return 0;
		//dp数组定义：dp[i] 为以i结尾的连续子数组最大的和
		int n = nums.length;
		int[] dp = new int[n];//以当前遍历下标数字结尾的最大子数组和
		//base case dp[0] = 它本身
		dp[0] = nums[0];
		int max = dp[0];

		for(int i=1;i<n;i++){
			dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
			max = Math.max(dp[i],max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
