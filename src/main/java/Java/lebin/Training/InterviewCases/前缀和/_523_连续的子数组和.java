package Java.lebin.Training.InterviewCases.前缀和;

import java.util.HashSet;
import java.util.Set;

/*
给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。
如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
示例 1：
输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
示例 2：
输入：nums = [23,2,6,4,7], k = 6
输出：true
解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 */
/*
从 k 的倍数作为切入点来做。
预处理前缀和数组 sum，方便快速求得某一段区间的和。然后假定 [i,j]是我们的目标区间，那么有：
sum[j]−sum[i−1]=n∗k ==》 sum[j]/k-sum[i−1]/k=n
要使得两者除 k 相减为整数，需要满足 sum[j]和 sum[i−1] 对 k 取余相同。
也就是说，我们只需要枚举右端点 j，然后在枚举右端点 j 的时候检查之前是否出现过左端点 i(满足取余的结果相同)，
使得sum[j] 和 sum[i−1] 对 k 取余相同。
使用 HashSet 来保存出现过的值。
让循环从 2 开始枚举右端点（根据题目要求，子数组长度至少为 2），每次将符合长度要求的位置的取余结果存入 HashSet。
 */
public class _523_连续的子数组和 {
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}
