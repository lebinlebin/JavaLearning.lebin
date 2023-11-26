package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 *
 * [2,15],[36,45],[9,29],[16,23],[4,9]
 * [2,15],[4,9],[9,29],[16,23],[36,45]
 *
 *
 * [2,15],[4,9],[9,29],[16,23],[36,45]
 *
 * |-------------|
 *     |-----|
 *           |----------------|
 *                  |-----|
 *                                   |-------------|
 *
 */
public class _253_会议室_II {

    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // 按照会议的开始时间，从小到大排序  nlogn
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 创建一个最小堆（存放每一个会议的结束时间）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 添加0号会议的结束时间
        heap.add(intervals[0][1]);

        // 堆顶的含义：目前占用的会议室中最早结束的时间
        for (int i = 1; i < intervals.length; i++) { // nlogn
            // i号会议的开始时间 >= 堆顶
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            // 将i号会议的结束时间加入堆中
            heap.add(intervals[i][1]);
        }

        return heap.size();
    }



    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 存放所有会议的开始时间
        int[] begins = new int[intervals.length];
        // 存放所有会议的结束时间
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        // 排序
        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIdx = 0;
        for (int begin : begins) {
            if (begin >= ends[endIdx]) { // 能重复利用会议室
                endIdx++;
            } else { // 需要新开一个会议室
                room++;
            }
        }
        return room;
    }



}
