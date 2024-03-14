package Java.lebin.Training.InterviewCases.SortArray.重复元素_没有出现的元素_只出现一次的元素;

import java.util.ArrayList;
import java.util.List;

/*
给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
//时间复杂度：O(n) 每一次交换操作会使得至少一个元素被交换到对应的正确位置，因此交换的次数为 O(n)，总时间复杂度为 O(n)。
//空间复杂度：O(1)
public class _442_数组中重复的数据 {
    /*
    将数组视为哈希表
    由于给定的 n 个数都在 [1,n]的范围内，如果有数字出现了两次，就意味着 [1,n] 中有数字没有出现过。
    因此，我们可以尝试将每一个数放在对应的位置。由于数组的下标范围是 [0,n−1]，我们需要将数 i 放在数组中下标为 i−1的位置：
    如果 i 恰好出现了一次，那么将 数字nums[i] 放在数组中下标为 nums[i]−1的位置即可；nums[nums[i]-1]=nums[i]
    如果 i 出现了两次，那么我们希望其中的一个 i 放在数组下标中为 i−1的位置，另一个 i 放置在任意「不冲突」的位置 j。
    也就是说，数 j+1没有在数组中出现过。
    这样一来，如果我们按照上述的规则放置每一个数，那么我们只需要对数组进行一次遍历。当遍历到位置 i 时，如果 nums[i]−1≠i，
    说明 nums[i] 出现了两次，我们就可以将 num[i] 放入答案。

    放置的方法也很直观：我们对数组进行一次遍历。当遍历到位置 i 时，我们知道 nums[i] 应该被放在位置 nums[i]−1。
    因此我们交换 num[i]和 nums[nums[i]−1]即可，直到待交换的两个元素相等为止。
     */

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
