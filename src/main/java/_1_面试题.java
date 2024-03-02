import java.util.HashMap;

/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。可以使用O(n)的辅助空间。
示例 1：
输入：nums = [1,2,3], k = 3
输出：2
满足条件的字数组为[1,2], [3]

示例 2：
输入：nums = [1,2,0,3], k = 3
输出：4
满足条件的字数组为[1,2], [1,2,0], [0,3], [3]
 */
public class _1_面试题 {
    public int subSumk(int[] nums, int k){
        int n = nums.length;
        //map记录 前缀和出现的次数
        HashMap<Integer,Integer> preSum = new HashMap<>();
        int ans = 0;
        preSum.put(0,1);//base case
        int sum0_i = 0;
        for(int i=0;i<=n;i++){
            sum0_i += nums[i];
            int sum0_j = sum0_i -k;
            if(preSum.containsKey(sum0_j)){
                ans += preSum.get(sum0_j);
            }
            preSum.put(sum0_i,preSum.getOrDefault(sum0_i,0)+1);
        }
        return ans;
    }

}
