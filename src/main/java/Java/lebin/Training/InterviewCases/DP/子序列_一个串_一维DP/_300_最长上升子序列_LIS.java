package Java.lebin.Training.InterviewCases.DP.子序列_一个串_一维DP;
/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
public class _300_最长上升子序列_LIS {
	/**
	 * 1. dp数组定义
	 * 		dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
	 * 2.递推公式
	 * 		if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);  j要在 0~i之间所有元素进行遍历
	 * 3. 初始化
	 * 		dp[i]的初始 每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1.
	 * 4. 遍历顺序
	 * 		从小到大
	 */
	//时间复杂度：O(n^2)
	//空间复杂度：O(n)
	static int lengthOfLIS1(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		//dp定义是以当前位置i数字结尾的最长递增序列长度为dp[i].
		//dp数组与输入的数组的长度是相同的
		int[] dp = new int[nums.length];
		//base case lcs最小为1；max一定要赋值初始值为1
		int max = dp[0] = 1;
		//确定了basecase之后就要从下一个index开始遍历。dp数组为一维数组，那么遍历是一重遍历
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;//最小为1，dp数组按照1进行初始化
			//每个i都要遍历i之前的所有数组，进行比较大小
			for (int j = 0; j < i; j++) {
				if (nums[i] <= nums[j]) continue;//没法接在后边
				//nums[i] > nums[j] 那么包含当前遍历元素nums[i]在内，可以组成一个新的递增序列，长度是dp[j] + 1
				dp[i] = Math.max(dp[i], dp[j] + 1);//可以接在后边组成新的lcs
			}
			//把最大值记录下来
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLIS1(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
	}
}
