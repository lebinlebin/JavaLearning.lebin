package Java.lebin.Training.InterviewCases.SortArray;

import java.util.HashMap;

/*
给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
示例 1：
输入:nums = [1,1,1], k = 2
输出: 2
解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
示例 2：
输入:nums = [1,2,3], k = 3
输出: 2
 */
public class _LCR010_和为K的子数组 {
    //基础版，两重循环，构造前缀和法
    // 时间复杂度 O(N^2)
    // 空间复杂度 O(N)
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //优化版本
    //优化思路，直接记录下有几个sum[j] 和 sum[i] - k 相等，直接更新结果，就避免了内层的for循环，
    // 可以用hash表，在记录前缀和的同时记录该前缀和出现的次数。
//    时间复杂度：O(n)，其中 n 为数组的长度。
//    空间复杂度：O(n)， 哈希表在最坏情况下有 n 个不同的键值

    public static int subarraySum_(int[] nums, int k) {
        int n = nums.length-1;
        //map:前缀和->该前缀和出现的次数
        HashMap<Integer,Integer> preSum = new HashMap<>();
        //base case;
        preSum.put(0,1);
        int ans = 0;
        int sum0_i = 0;
        //穷举所有子数组
        for (int i = 0; i <= n ; i++) {
            sum0_i += nums[i];//这是我们想要找的前缀和 nums[0,...,i]
            int sum0_j = sum0_i -k;
            if(preSum.containsKey(sum0_j))
                ans += preSum.get(sum0_j);
            //把前缀和 nums[0,...,i] 加入并记录出现次数
            preSum.put(sum0_i,preSum.getOrDefault(sum0_i,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] nums =  {1,1,1};
       int k = 2;
        System.out.println(subarraySum(nums,k));

    }
}
