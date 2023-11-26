package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
/*
来分析一下，要求删除元素使其达到最大摆动序列，应该删除什么元素呢？
局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。xx
 */
public class _376_摆动序列 {
	//时间复杂度：O(n)
	//空间复杂度：O(1)
	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;//一个数字，默认一个摆动
		}
		//当前差值
		int curDiff = 0;
		//上一个差值 默认最左边有一个平坡，preDiff默认为0
		int preDiff = 0;
		//默认最右边有一个摆动
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			//得到当前差值
			curDiff = nums[i] - nums[i - 1];
			//如果当前差值和上一个差值为一正一负,说明出现了峰值
			//等于0的情况表示初始时的preDiff
			if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
				count++;
				preDiff = curDiff;//单调坡度有平坡; 只需要在 这个坡度 摆动变化的时候，更新 prediff 就行，这样 prediff 在 单调区间有平坡的时候 就不会发生变化，造成我们的误判。
			}
		}
		return count;
	}
}
