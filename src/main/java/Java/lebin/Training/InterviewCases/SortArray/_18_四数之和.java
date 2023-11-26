package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 18. 四数之和
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class _18_四数之和 {
    /*思路
    四数之和，和 15题. 三数之和 是一个思路，都是使用双指针法, 基本解法就是在15题. 三数之和的基础上再套一层for循环。
    但是有一些细节需要注意，例如： 不要判断nums[k] > target 就返回了，三数之和 可以通过 nums[i] > 0 就返回了，
    因为 0 已经是确定的数了，四数之和这道题目 target是任意值。（大家亲自写代码就能感受出来）
    15题. 三数之和 的双指针解法是一层for循环num[i]为确定值，然后循环内有left和right下表作为双指针，找到nums[i] + nums[left] + nums[right] == 0。
    */
//    时间复杂度: O(n^3)
//    空间复杂度: O(1)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            // 这种剪枝是错误的，这道题目target 是任意值
            // if (nums[k] > target) {
            //     return result;
            // }

            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < nums.length; i++) {
                // 正确去重方法
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    if (nums[k] + nums[i] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[k] + nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));

                        // 去重逻辑应该放在找到一个四元组之后
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        // 找到答案时，双指针同时收缩
                        right--;
                        left++;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }
}
