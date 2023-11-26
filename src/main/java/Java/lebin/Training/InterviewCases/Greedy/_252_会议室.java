package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 * 示例 1:：
 * 输入: intervals = [[0,30],[5,10],[15,20]]
 * 输出: false
 * 解释: 存在重叠区间，一个人在同一时刻只能参加一个会议。
 */
public class _252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 遍历每一个会议
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }

        return true;
    }
}
