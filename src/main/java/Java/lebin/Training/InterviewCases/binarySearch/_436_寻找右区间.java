package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
示例 1：
输入：intervals = [[1,2]]
输出：[-1]
解释：集合中只有一个区间，所以输出-1。
示例 2：
输入：intervals = [[3,4],[2,3],[1,2]]
输出：[-1,0,1]
解释：对于 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间[3,4]具有最小的“右”起点;
对于 [1,2] ，区间[2,3]具有最小的“右”起点。
示例 3：
输入：intervals = [[1,4],[2,3],[3,4]]
输出：[-1,2,-1]
解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 */
public class _436_寻找右区间 {
    //时间复杂度：O(nlogn)，其中 n 为区间数组的长度。排序的时间为 O(nlogn)，每次进行二分查找花费的时间为 O(logn)，一共需要进行 n 次二分查找，因此总的时间复杂度为 O(nlogn)。
    //空间复杂度：O(n)，其中 n 为区间数组的长度。startIntervals 一共存储了 n 个元素，因此空间复杂度为 O(n)。
    /*
    排序预处理 + 二分查找
    题目中的关键字是找「大于等于」，最小的那个区间的下标，很显然需使用二分查找算法；
    要使用二分查找，需要在有序的环境中进行，因此，需要对区间排序（可将这一步称之为预处理）；
    题目要求返回索引，但是排序以后，索引信息丢失。因此在预处理的时候，就得把「起点」和「下标」的关系存起来。
    刚刚好题目中说道：「你可以假定这些区间都不具有相同的起始点」，用「哈希表」正合适；
    排序的时候，只需要对起点进行排序即可；
    在二分查找的时候，传入的是区间的右端点，查找的是大于等于区间的右端点的第 1 个值，因此它的反面就是：小于一定不是解。
    根据这个「逐渐缩小搜索区间」的策略，编写二分查找算法；
    注意：一种特殊的情况，如果有序的最后一个元素都小于传入的区间的右端点，那么直接返回−1。
     */
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }
        // 对原始区间进行预处理，key：起点，value：索引
        // 题目中说：你可以假定这些区间都不具有相同的起始点
        Map<Integer, Integer> hashMap = new HashMap<>(len);

        int[] arr = new int[len];
        int[] res = new int[len];
        //存储原始startindex 和对应的下标
        for (int i = 0; i < len; i++) {
            hashMap.put(intervals[i][0], i);
            arr[i] = intervals[i][0];
        }
        Arrays.sort(arr);//对start_index进行排序
        for (int i = 0; i < len; i++) {
            int index = binarySearch(arr, intervals[i][1]);//查找第 1 个大于等于 target 的元素的索引
            if (index == -1) {
                res[i] = -1;
            } else {
                res[i] = hashMap.get(arr[index]);
            }
        }
        return res;
    }

    /**
     * 查找第 1 个大于等于 target 的元素的索引
     */
    private int binarySearch(int[] arr, int target) {
        int len = arr.length;
        // 特判 边界条件
        if (arr[len - 1] < target) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;//因为循环条件是left < right，因此right取不到，所以可以直接对mid赋值
            }
        }
        return left;
    }


}
