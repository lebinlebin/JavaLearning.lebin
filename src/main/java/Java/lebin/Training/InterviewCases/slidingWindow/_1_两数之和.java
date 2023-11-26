package Java.lebin.Training.InterviewCases.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，
 * 并返回它们的数组下标。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
//时间复杂度：O(N)
//空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        // 用来存放之前扫描过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return new int[]{idx, i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,3,6};
        System.out.println(Arrays.toString(twoSum(nums,7)));
    }
}
