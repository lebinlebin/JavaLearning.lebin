package Java.lebin.Training.InterviewCases.SortArray;

/**
 给定一个含有 n 个正整数的数组和一个正整数 target 。
 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 示例 1：
 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class _209_长度最小的连续子数组和大于等于target {
	//将O(n^2)暴力解法降为O(n)。
	// 滑动窗口
	//可以发现滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。
	public static int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int sum = 0;
		int result = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= s) {
				result = Math.min(result, right - left + 1);
				sum -= nums[left++];
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}


	//这道题目暴力解法当然是 两个for循环，然后不断的寻找符合条件的子序列，时间复杂度很明显是O(n^2)。
	// 时间复杂度O(n^2)。
	public static int minSubArrayLen2(int s, int[] nums) {
		int result = Integer.MAX_VALUE;; // 最终的结果
		int sum = 0; // 子序列的数值之和
		int subLength = 0; // 子序列的长度
		for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
			sum = 0;
			for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
				sum += nums[j];
				if (sum >= s) { // 一旦发现子序列和超过了s，更新result
					subLength = j - i + 1; // 取子序列的长度
					result = result < subLength ? result : subLength;
					break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
				}
			}
		}
		// 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
		return result == Integer.MAX_VALUE ? 0 : result;
	}




	public static void main(String[] args) {
		int[] nums = new int[] {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7,nums));
	}

}
