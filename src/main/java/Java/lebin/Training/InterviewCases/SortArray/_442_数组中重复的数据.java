package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
//时间复杂度:时间复杂度：O(n)
//空间复杂度：O(n) set的大小
public class _442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> repeat = new ArrayList<>();
        for (int num : nums) {
            if (!set.add(num)) {
                repeat.add(num);
            }
        }
        return repeat;
    }
}
