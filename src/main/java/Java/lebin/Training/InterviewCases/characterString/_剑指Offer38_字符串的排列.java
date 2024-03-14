package Java.lebin.Training.InterviewCases.characterString;

import java.util.LinkedList;
import java.util.List;

/**
 剑指 Offer 38. 字符串的排列
 输入一个字符串，打印出该字符串中字符的所有排列。
 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 示例:
 输入：s = "abc"
 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class _剑指Offer38_字符串的排列 {
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
