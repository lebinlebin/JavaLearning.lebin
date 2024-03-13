package Java.lebin.Training.InterviewCases.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

 示例 1：
 输入：fruits = [1,2,1]
 输出：3
 解释：可以采摘全部 3 棵树。
 示例 2：
 输入：fruits = [0,1,2,2]
 输出：3
 解释：可以采摘 [1,2,2] 这三棵树。
 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 示例 3：

 输入：fruits = [1,2,3,2,2]
 输出：4
 解释：可以采摘 [2,3,2,2] 这四棵树。
 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 示例 4：

 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 输出：5
 解释：可以采摘 [1,2,1,1,2] 这五棵树。

 */
//时间复杂度：O(n)，其中 n 是数组 fruits 的长度。
//空间复杂度: O(1)。哈希表中最多会有三个键值对，可以看成使用了常数级别的空间。
public class _904_水果成篮 {

	// 滑动窗口
	//	可以发现滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。
	public static int totalFruit(int[] fruits) {
		int n = fruits.length;
		Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

		int left = 0, ans = 0;
		for (int right = 0; right < n; ++right) {
			cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
			//大于2就要收窄窗口
			while (cnt.size() > 2) {
				cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
				if (cnt.get(fruits[left]) == 0) {
					cnt.remove(fruits[left]);
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = new int[] {3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(totalFruit(nums));
	}

}
