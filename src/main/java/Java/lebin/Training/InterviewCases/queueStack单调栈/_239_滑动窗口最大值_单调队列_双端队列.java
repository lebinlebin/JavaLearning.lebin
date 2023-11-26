package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
//时间复杂度: O(n)
//空间复杂度: O(k)
//单调队列
public class _239_滑动窗口最大值_单调队列_双端队列 {
	//将数组 nums 的前 k个元素放入优先队列中。每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 1) return new int[0];
		if (k == 1) return nums;
		int[] maxes = new int[nums.length - k + 1];//滑动窗口最大值结果收集
		// 队列中放向右遍历遇到的最大值，当遇到比队列末尾大的元素就把队列中末尾的元素移除掉，那么队列中队头一个位置
		// 一定放的都是当前最大的元素
		Deque<Integer> deque = new LinkedList<>();//队列，先入先出
		for (int ri = 0; ri < nums.length; ri++) {
			// 只要nums[队尾] <= nums[i]，就删除队尾
			// 维持队列从大到小降序排列
			//当前窗口内的操作
			while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
				deque.removeLast();
			}
			// 将i加到队尾
			deque.addLast(ri);
			// 检查窗口的索引是否合法
			int li = ri - k + 1;
			if (li < 0) continue;

			// 检查队头的合法性
			if (deque.peekFirst() < li) {
				// 队头不合法（失效，不在滑动窗口索引范围内）
				deque.removeFirst();//先入先出
			}
			// 设置窗口的最大值
			maxes[li] = nums[deque.peekFirst()];
		}
		return maxes;
	}
}
