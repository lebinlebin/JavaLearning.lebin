package Java.lebin.Training.InterviewCases.DFS回溯.子集问题;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class _78_子集subset {
    List<List<Integer>> res =  new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, nums, res, track);
        return res;
    }
    void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> track){
        //前序遍历位置
        res.add(new LinkedList<>(track));
        //通过start进行控制选择
        for(int i=start; i<nums.length; i++){
            track.add(nums[i]);
            backtrack(i+1,nums,res,track);
            track.remove(track.size()-1);
        }
    }
}
