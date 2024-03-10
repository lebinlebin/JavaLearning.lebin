package Java.lebin.Training.InterviewCases.哈希表;

import java.util.ArrayList;
import java.util.List;

/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
示例 1：
输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
示例 2：
输入：nums = [1,1]
输出：[2]
 */
//时间复杂度：O(N)，这里 N 是数组的长度；
//空间复杂度：O(1)，这里没有使用额外的空间。
public class _448_找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
//    private void swap(int[] nums, int index1, int index2) {
//        if (index1 == index2) {
//            return;
//        }
//        nums[index1] = nums[index1] ^ nums[index2];
//        nums[index2] = nums[index1] ^ nums[index2];
//        nums[index1] = nums[index1] ^ nums[index2];
//    }

}
