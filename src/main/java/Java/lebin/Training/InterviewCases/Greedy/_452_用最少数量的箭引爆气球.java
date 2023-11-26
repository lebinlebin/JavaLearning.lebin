package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
 * 因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
 * 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 */

public class _452_用最少数量的箭引爆气球 {
//	时间复杂度 : O(NlogN)  排序需要 O(NlogN) 的复杂度
// 空间复杂度 : O(logN) java所使用的内置函数用的是快速排序需要 logN 的空间
	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0) return 0;

		//按照w[0] 排序
		Arrays.sort(points, (w1, w2) -> w1[0] < w2[0] ? -1 : 1);
//		for(int i=0;i<points.length;i++){
//			System.out.println(Arrays.toString(points[i]));
//		}
		// 射击次数
		int count = 1;
		// right 维护射击区间的右边界
		int right = points[0][1];
		/*
		right 维护射击区间的右边界 当大于这个边界就要新的箭来射穿气球

		          right
		|-----------|                     right
		                |------------------|
		                         |-------|
		                               right
		                这两个气球是挨着的。更新挨着的气球的右侧边界的最小值。如果以原来的right(上边)是不能同时射穿这两个重叠气球的
		 */
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > right) { // 不挨着，新的气球左端点大于射击区间右边界，更新射击区间右边界
				count++;
				right = points[i][1];
			} else { //挨着
				// 新的气球左端点小于等于射击区间的右边界
				if (points[i][1] < right) { // 如果右端点也比射击区间右边界小
					right = points[i][1];
				}
				//不是上边if中的条件的话就可以一箭射穿两个气球，不需要更新count
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][]  points  = new int[][]{{10,16},{2,8},{1,6},{7,12}};
		findMinArrowShots(points);
	}
}
