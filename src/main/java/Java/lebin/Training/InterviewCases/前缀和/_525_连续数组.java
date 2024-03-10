package Java.lebin.Training.InterviewCases.前缀和;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
示例 1:
输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
示例 2:
输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 */
//时间复杂度：O(N)，这里N 是数组的长度，算法遍历了一次数组，每一个元素的操作都是常数次的，因此整体时间复杂度是O(N)；
//空间复杂度：O(N)。
public class _525_连续数组 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        // 下标 0 之前的位置是 -1，注意：可以理解为哨兵
        map.put(0, -1);

        int res = 0;
        int preSum = 0;

        // 把数组中的 0 都看成 -1
        for (int i = 0; i < len; i++) {
            // pre 是先加了，所以后面计算的时候是 i - map.get(preSum)
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum += -1;
            }

            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                // 注意：只记录这个数字第 1 次出现的下标
                map.put(preSum, i);
            }
        }
        return res;
    }
}
