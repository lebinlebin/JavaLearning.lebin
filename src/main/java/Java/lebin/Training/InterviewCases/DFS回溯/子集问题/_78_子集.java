package Java.lebin.Training.InterviewCases.DFS回溯.子集问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 */
//但是要清楚子集问题和组合问题、分割问题的的区别，子集是收集树形结构中树的所有节点的结果。而组合问题、分割问题是收集树形结构中叶子节点的结果。
public class _78_子集 {
    //时间复杂度: O(n * 2^n)
    //空间复杂度: O(n)
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    List<Integer> path = new ArrayList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size()-1);
        }
    }
}
