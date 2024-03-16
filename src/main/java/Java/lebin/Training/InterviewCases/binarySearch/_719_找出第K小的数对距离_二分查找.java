package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.Arrays;

/*
数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
返回 所有数对距离中 第 k 小的数对距离。

示例 1：
输入：nums = [1,3,1], k = 1
输出：0
解释：数对和对应的距离如下：
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
距离第 1 小的数对是 (1,1) ，距离为 0 。
示例 2：
输入：nums = [1,1,1], k = 2
输出：0
示例 3：
输入：nums = [1,6,1], k = 3
输出：5
 */
public class _719_找出第K小的数对距离_二分查找 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            //统计距离（数值之差）小于等于 target 的个数
            int count = countLessEquals(nums, mid);
            if (count < k) {
                // 如果小于等于 mid 的个数严格小于 k 个，说明 mid 太小了
                // 下一轮搜索区间为 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间为 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 统计距离（数值之差）小于等于 target 的个数
     */

    private int countLessEquals(int[] nums, int target) {
        int count = 0;
        int len = nums.length;
        for (int left = 0, right = 0; right < len; right++) {
            while (nums[right] - nums[left] > target) {
                left++;
            }
            // 此时满足 nums[right] - nums[left] <= target
            // right 与 [left..right - 1] 里的每一个元素的「距离」都小于等于 target
            // [left..right - 1] 里元素的个数为 right - left
            count += right - left;
        }
        return count;
    }
}
