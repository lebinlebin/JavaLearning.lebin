package Java.lebin.Training.InterviewCases.N数之和;

import java.util.Arrays;

/*
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。
示例 1：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
示例 2：
输入：nums = [0,0,0], target = 1
输出：0
 */
//时间复杂度：O(N^2)
//空间复杂度：O(logN)
public class _16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public int threeSumClosest_Opt(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 优化三
            }

            // 优化一
            int s = nums[i] + nums[i + 1] + nums[i + 2];
            if (s > target) { // 后面无论怎么选，选出的三个数的和不会比 s 还小
                if (s - target < minDiff) {
                    ans = s; // 由于下面直接 break，这里无需更新 minDiff
                }
                break;
            }

            // 优化二
            s = nums[i] + nums[n - 2] + nums[n - 1];
            if (s < target) { // nums[i] 加上后面任意两个数都不超过 s，所以下面的双指针就不需要跑了
                if (target - s < minDiff) {
                    minDiff = target - s;
                    ans = s;
                }
                continue;
            }
            // 双指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                s = nums[i] + nums[j] + nums[k];
                if (s == target) {
                    return target;
                }
                if (s > target) {
                    if (s - target < minDiff) { // s 与 target 更近
                        minDiff = s - target;
                        ans = s;
                    }
                    k--;
                } else { // s < target
                    if (target - s < minDiff) { // s 与 target 更近
                        minDiff = target - s;
                        ans = s;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
