package Java.lebin.Training.InterviewCases.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
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
