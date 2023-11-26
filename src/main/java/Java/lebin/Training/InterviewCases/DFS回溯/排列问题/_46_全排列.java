package Java.lebin.Training.InterviewCases.DFS回溯.排列问题;

import java.util.LinkedList;
import java.util.List;

/**
 46. 全排列
 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



 示例 1：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 示例 2：

 输入：nums = [0,1]
 输出：[[0,1],[1,0]]
 示例 3：

 输入：nums = [1]
 输出：[[1]]
 */
public class _46_全排列 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    void backtrack(int[] nums,LinkedList<Integer> track){
        //触发终止条件
        //这里终止条件是通过track的大小进行控制的
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //排除不合法的选择
            if(track.contains(nums[i]))
                continue;
            //做选择
            track.add(nums[i]);
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }

    }
}
