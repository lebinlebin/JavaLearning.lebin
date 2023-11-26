package Java.lebin.Training.InterviewCases.DFS回溯.组合问题;

import java.util.*;

/**
 第77题. 组合
 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
//时间复杂度: O(n * 2^n)
//空间复杂度: O(n)
public class _77_组合 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        //从1开始遍历
        backtrack(n, k,track,1);
        return res;
    }
    void backtrack(int n,int k,LinkedList<Integer> track,int startIndex){
        //到达叶子节点才更新res
        if(k == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        //i从 startIndex 可是递增
        //遍历所有可能的选择
        //i <= n - (k - path.size()) + 1
        for(int i=startIndex; i<=n; i++){
            //做选择
            track.add(i);
            //递归下一个，startIndex+1
            backtrack(n,k,track,i+1);
            track.remove(track.size()-1);
        }
    }

    //剪枝优化
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combineOpt(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //集合n中至多要从该起始位置 : i <= n - (k - path.size()) + 1，开始遍历
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { // 优化的地方
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}