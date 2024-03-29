package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashSet;
import java.util.Set;

/*
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
示例 1：
输入：nums = [1,2,3,1]
输出：true
示例 2：
输入：nums = [1,2,3,4]
输出：false
示例 3：
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true

 */
public class _217_存在重复元素_任一值出现两次true_每个元素都不一样false {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
