package Java.lebin.Training.InterviewCases.DP.子序列_一个串_一维DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;
/*
128. 最长连续序列
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
数字连续!!!!
数字连续!!!!
 */
public class _128_最长连续序列_数字连续 {
/*
创建一个dp列表，长度为nums的长度，初始每个值都为1（代表并没有连续的序列），
1. dp定义
    dp[i]表示以nums[i]为最后一个数的连续子序列的长度,
2. 地推公式
    创建一个max_sum变量维护为当前已知得最长连续子序列长度。
    排序列表
    从索引为1开始遍历列表，当遇到num[i]=nums[i-1]+1,也就是连续的情况，那么上一个数为结尾的子序列的长度就可以+1。
    每当有1被更新为其他的数，就维护max_sum使其始终是已知的最长连续子序列长度
3. 值得注意的是，如 0,1,1,2 这样的序列，第二个1需要继承第一个1的长度。
    也就是当当前值与上一个值一样大，则继承上一个值。
    最后返回max_sum
 */
//    时间复杂度:O(n)
//    空间复杂度: O(n)
    public int longestConsecutive(int[] nums) {
        if(nums == null){ return  0; }
        int len = nums.length;
        if(len == 0){ return  0; }
        Arrays.sort(nums);
        int max_sum = 1;
        int[] dp = new int[len];
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i]=1;
        }
        for (int i = 1; i < len; i++) {
            if(nums[i] == nums[i-1] + 1) {
                dp[i] = dp[i-1] +1;
                max_sum = Math.max(max_sum,dp[i]);
            }else if(nums[i]==nums[i-1]){//数组中元素相同的情况
                dp[i] = dp[i-1];
            }
        }
          return max_sum;
    }
}
