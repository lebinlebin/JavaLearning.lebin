package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.PriorityQueue;

/*
给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 */
public class _973_最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        if (len == 0) {
            return new int[0][0];
        }

        int[][] res = new int[K][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K + 1, (point1, point2) -> (point2[0] * point2[0] + point2[1] * point2[1])
                - (point1[0] * point1[0] + point1[1] * point1[1]));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
