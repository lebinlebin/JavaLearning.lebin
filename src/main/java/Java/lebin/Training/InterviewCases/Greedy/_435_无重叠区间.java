package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */

/*
解题思路: 该题和用枪射击气球的题是一样的。计算一共需要多少枪能把所有气球都打爆。让数组长度-开枪次数，就是需要删除的数组个数，也即重复(气球挨着)的个数。
		① 我们用right来维护枪能射击到的最右边的最小值。即重叠气球中右侧的最小值。即沿着这个位置开一枪一定能将所有重叠气球都打爆
		② 循环数组，
		   新元素到来时候有两种情况，1）挨着  2）不挨着
		   1) 挨着： 挨着的情况说明  新元素的左侧边界< right.  那么需要重新计算当前重叠(挨着)元素的新的最右侧最小元素。
		   right = min(right,新元素的右侧边界)
		   2）不挨着: 当新的元素的左侧边界>right的时候，那么新元素就是和前一个元素不挨着的。需要新开一枪才能打爆气球
		  这里题目说了 "=" 也算不重叠，因此，>=right的时候就表示不挨着。
		     同时此时需要count++；


		right 维护射击区间的右边界 当大于这个边界就要新的箭来射穿气球

		          right
		|-----------|                     right
		                |------------------|
		                         |-------|
		                               right
		                这两个气球是挨着的。更新挨着的气球的右侧边界的最小值。如果以原来的right(上边)是不能同时射穿这两个重叠气球的
*/

public class _435_无重叠区间 {
//	时间复杂度：O(nlog n) ，有一个快排
//	空间复杂度：O(n)，有一个快排，最差情况(倒序)时，需要n次递归调用。因此确实需要O(n)的栈空间
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) return 0;
		//按照w[0] 排序
//		Arrays.sort(intervals, (w1, w2) -> w1[0] < w2[0] ? -1 : 1);
		Arrays.sort(intervals, (a,b)-> { return Integer.compare(a[0],b[0]); });
//		for(int i=0;i<intervals.length;i++){
//			System.out.println(Arrays.toString(intervals[i]));
//		}
		// 射击次数
		int count = 1;
		// right 维护射击区间的右边界
		int right = intervals[0][1];

		/*
		right 维护射击区间的右边界 当大于这个边界就要新的箭来射穿气球

		          right
		|-----------|                     right
		                |------------------|
		                         |-------|
		                               right
		                这两个气球是挨着的。更新挨着的气球的右侧边界的最小值。如果以原来的right(上边)是不能同时射穿这两个重叠气球的
		 */
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= right) { // 不挨着，新的气球左端点大于射击区间右边界，更新射击区间右边界
				count++;//不需要移除的个数
				right = intervals[i][1];
			} else { //挨着
				// 新的气球左端点小于等于射击区间的右边界
				if (intervals[i][1] < right) { // 如果右端点也比射击区间右边界小
					right = intervals[i][1];
				}
			}
		}
		return intervals.length-count;//总个数-不需要移除的个数=需要移除的个数
	}


	public int eraseOverlapIntervals2(int[][] intervals) {
		Arrays.sort(intervals, (a,b)-> {
			return Integer.compare(a[0],b[0]);
		});
		int count = 1;
		for(int i = 1;i < intervals.length;i++){
			if(intervals[i][0] < intervals[i-1][1]){
				intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
				continue;
			}else{
				count++;
			}
		}
		return intervals.length - count;
	}
	
}
