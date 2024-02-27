package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
示例 1：
输入：nums = [3,2,3]
输出：[3]
示例 2：
输入：nums = [1]
输出：[1]
示例 3：
输入：nums = [1,2]
输出：[1,2]

 */
public class _229_多数元素2 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (cnt.containsKey(nums[i])) {
                cnt.put(nums[i], cnt.get(nums[i]) + 1);
            } else {
                cnt.put(nums[i], 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : cnt.keySet()) {
            if (cnt.get(x) > nums.length / 3) {
                ans.add(x);
            }
        }

        return ans;
    }
}
