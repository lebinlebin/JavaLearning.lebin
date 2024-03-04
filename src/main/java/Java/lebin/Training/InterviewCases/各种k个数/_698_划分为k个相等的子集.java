package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.Arrays;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
示例 2:
输入: nums = [1,2,3,4], k = 3
输出: false
 */
//参考:https://lfool.github.io/LFool-Notes/algorithm/%E7%BB%8F%E5%85%B8%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%EF%BC%9A%E9%9B%86%E5%90%88%E5%88%92%E5%88%86%E9%97%AE%E9%A2%98.html
//时间复杂度为 O(k^n)
public class _698_划分为k个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] bucket = new int[k + 1];//为啥要k+1
        return backtrack(nums, 0, bucket, k, target);
    }
    // index : 第 index 个球开始做选择
    // bucket : 桶
    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {

        // 结束条件：已经处理完所有球
        if (index == nums.length) {
            // 判断现在桶中的球是否符合要求 -> 路径是否满足要求
            for (int i = 0; i < k; i++) {
                if (bucket[i] != target) return false;
            }
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) {
            // 剪枝：放入球后超过 target 的值，选择一下桶
            if (bucket[i] + nums[index] > target) continue;
            // 做选择：放入 i 号桶
            bucket[i] += nums[index];

            // 处理下一个球，即 nums[index + 1]
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            // 撤销选择：挪出 i 号桶
            bucket[i] -= nums[index];
        }

        // k 个桶都不满足要求
        return false;
    }
    //如果我们让nums[]内的元素递减排序，先让值大的元素选择桶，这样可以增加剪枝的命中率，从而降低回溯的概率
    // 剪枝：放入球后超过 target 的值，选择一下桶
    //if (bucket[i] + nums[index] > target) continue;

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        // 降序排列
        Arrays.sort(nums);
        int left = 0, right= nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] bucket = new int[k + 1];//为啥要k+1
        return backtrack2(nums, 0, bucket, k, target);
    }
    // index : 第 index 个球开始做选择
    // bucket : 桶
    private boolean backtrack2(int[] nums, int index, int[] bucket, int k, int target) {

        // 结束条件：已经处理完所有球
        if (index == nums.length) {
            // 判断现在桶中的球是否符合要求 -> 路径是否满足要求
            for (int i = 0; i < k; i++) {
                if (bucket[i] != target) return false;
            }
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) {
            // 剪枝：放入球后超过 target 的值，选择一下桶
            if (bucket[i] + nums[index] > target) continue;
            // 做选择：放入 i 号桶
            bucket[i] += nums[index];

            // 处理下一个球，即 nums[index + 1]
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            // 撤销选择：挪出 i 号桶
            bucket[i] -= nums[index];
        }

        // k 个桶都不满足要求
        return false;
    }
    //第二次尝试剪枝
    public boolean canPartitionKSubsets3(int[] nums, int k) {
        // 降序排列
        Arrays.sort(nums);
        int left = 0, right= nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] bucket = new int[k + 1];//为啥要k+1
        return backtrack3(nums, 0, bucket, k, target);
    }
    // index : 第 index 个球开始做选择
    // bucket : 桶
    private boolean backtrack3(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件：已经处理完所有球
        if (index == nums.length) {
            // 有人提出，其实这个地方不需要判断，因为当 index == num.length 时，所有球已经按要求装入所有桶，所以肯定是一个满足要求的解
            // 即：每个桶内球的和一定为 target
            /** // 判断现在桶中的球是否符合要求 -> 路径是否满足要求
             for (int i = 0; i < k; i++) {
             if (bucket[i] != target) return false;
             }**/
            return true;
        }

        // nums[index] 开始做选择
        for (int i = 0; i < k; i++) {
            //最后可以优化的第三个点，对于第一个球，任意放到某个桶中的效果都是一样的，所以我们规定放到第一个桶中
//            if (i > 0 && index == 0) break ;
            //可以优化的第二个点和 排列/组合/子集 问题 中「元素可重不可复选」情况下「子集」的处理情况很相似！！！
            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;

            // 剪枝：放入球后超过 target 的值，选择一下桶
            if (bucket[i] + nums[index] > target) continue;
            // 做选择：放入 i 号桶
            bucket[i] += nums[index];

            // 处理下一个球，即 nums[index + 1]
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            // 撤销选择：挪出 i 号桶
            bucket[i] -= nums[index];
        }

        // k 个桶都不满足要求
        return false;
    }
}
