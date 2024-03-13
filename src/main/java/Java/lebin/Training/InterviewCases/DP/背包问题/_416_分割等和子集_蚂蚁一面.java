package Java.lebin.Training.InterviewCases.DP.背包问题;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * ===> 抽象成背包问题: 我们有这么多数组的元素，有个容量=全部元素和的一半的背包。看能不能把这个背包装满.
 * 本题每个元素是不可以重复使用的。是个01背包问题
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
/*
1. dp定义
	01背包中，dp[j] 表示： 容量为j的背包，所背的物品价值最大可以为dp[j]。
	本题中每一个元素的数值既是重量，也是价值。 这里重量和价值我们等价处理。重量是多少，价值就是多少。
	套到本题，dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]。
	那么如果背包容量为target， dp[target]就是装满 背包之后的重量，所以 当 dp[target] == target 的时候，背包就装满了。
有录友可能想，那还有装不满的时候？
拿输入数组 [1, 5, 11, 5]，举例， dp[7] 只能等于 6，因为 只能放进 1 和 5。
而dp[6] 就可以等于6了，放进1 和 5，那么dp[6] == 6，说明背包装满了。

2. 递推公式
	01背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
	本题，相当于背包里放入数值，那么物品i的重量是nums[i]，其价值也是nums[i]。
	所以递推公式：dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);

3. dp数组如何初始化
	从dp[j]的定义来看，首先dp[0]一定是0。
	如果题目给的价值都是正整数那么非0下标都初始化为0就可以了，如果题目给的价值有负数，那么非0下标就要初始化为负无穷。
	这样才能让dp数组在递推的过程中取得最大的价值，而不是被初始值覆盖了。
	本题题目中 只包含正整数的非空数组，所以非0下标的元素初始化为0就可以了。
4. 确定遍历顺序
	在动态规划：关于01背包问题，如果使用一维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒序遍历！
 */
public class _416_分割等和子集_蚂蚁一面 {
	//时间复杂度：O(n^2)
	//空间复杂度：O(n)，虽然dp数组⼤⼩为⼀个常数，但是⼤常数
	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int n = nums.length;
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		//总和为奇数，不能平分
		if(sum % 2 != 0) return false;
		int target = sum / 2;//容量最大值
		int[] dp = new int[target + 1];
		for(int i = 0; i < n; i++) {
			for(int j = target; j >= nums[i]; j--) {
				//物品 i 的重量是 nums[i]，其价值也是 nums[i]
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}
			//剪枝一下，每次完成for-loop，立即检查首付dp[target] == target，优化时间复杂度(26ms -> 20ms)
			if(dp[target] == target)
				return true;
		}
		return dp[target] == target;
	}
	public static void main(String[] args) {
		int num[] = {1,5,11,5};
		System.out.println(canPartition(num));
	}
}
