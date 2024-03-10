package Java.lebin.Training.InterviewCases.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 单调队列
 */
//时间复杂度：O(n)，其中 n 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)。
//空间复杂度：O(k)。我们使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1 个元素，因此队列使用的空间为 O(k)
public class _239_滑动窗口最大值_双端队列 {
	//单调队列实现(双向队列)   掌握  维护队列连单调递增和点掉递减
	//“滑动窗口”存放的是数组的索引值。
	public int[] maxSlidingWindow_deque(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) return new int[0];
		if (k == 1) return nums;
		int[] maxes = new int[nums.length - k + 1];
		// peek:  取值（偷偷瞥一眼）
		// poll:  删除（削）
		// offer: 添加（入队）
		//队列中放向右遍历遇到的最大值，当遇到比队列末尾大的元素就把队列中末尾的元素移除掉，那么队列中队头一个位置
		// 一定放的都是当前最大的元素
		Deque<Integer> deque = new LinkedList<>();

		for (int ri = 0; ri < nums.length; ri++) {
			// 只要nums[队尾] <= nums[i]，就删除队尾
			// 维持队列从大到小降序排列
			//当前窗口内的操作
			//单调队列维护的是单调递减队列，对于比当前nums[i] 小的数都弹出栈，栈首部意志保持的是当前队列的最大值
			while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
				deque.removeLast();
			}
			// 将i加到队尾
			deque.addLast(ri);

			// 检查窗口的索引是否合法
			int li = ri - k + 1;
			if (li < 0) continue;//还没攒够k个元素，继续

			// 检查队头的合法性
			if (deque.peekFirst() < li) {
				// 队头不合法（失效，不在滑动窗口索引范围内）
				deque.removeFirst();
			}

			// 设置窗口的最大值
			maxes[li] = nums[deque.peekFirst()];
		}

		return maxes;
	}
}
