package Java.lebin.Training.InterviewCases.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * ------------
 *        ---------------
 *                         ---------------
 *
 *   输入：
 * [[1,3]]
 * 输出：
 * []
 * 预期结果：
 * [[1,3]]
 *
 *
 *
 * 输入：
 * [[1,4],[0,2],[3,5]]
 * 输出：
 * [[0,4],[0,5]]
 * 预期结果：
 * [[0,5]]
 */


public class _56_合并区间 {
//	时间复杂度：O(nlogn)，其中 n 为区间的数量。
//	除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(nlogn)。
//	空间复杂度：O(logn)，其中 n 为区间的数量。
//	这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
	public static int[][] merge(int[][] intervals) {
		// 先按照区间起始位置排序
		Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
		// 遍历区间
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval: intervals) {
			// 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
			// 则不合并，直接将当前区间加入结果数组。
			if (idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, idx + 1);
	}


	public static void main(String[] args) {

		int[][] intervals = new int[][]{{1,4},{0,2},{3,5}};
		int[][] res = merge(intervals);
		for(int i=0;i<res.length;i++){
			System.out.println(Arrays.toString(res[i]));
		}
	}
	
}
