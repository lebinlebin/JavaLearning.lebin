package Java.lebin.Training.InterviewCases.图;

import java.util.ArrayList;
import java.util.List;

/*
给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
public class _797_所有可能的路径 {
    //// 深度优先遍历
    List<List<Integer>> ans;		// 用来存放满足条件的路径
    List<Integer> cnt;		// 用来保存 dfs 过程中的节点值
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0);			// 注意，0 号节点要加入 cnt 数组中
        dfs(graph, 0);
        return ans;
    }
    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {		// 如果当前节点是 n - 1，那么就保存这条路径
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for (int index = 0; index < graph[node].length; index++) {
            int nextNode = graph[node][index];
            cnt.add(nextNode);
            dfs(graph, nextNode);
            cnt.remove(cnt.size() - 1);		// 回溯
        }
    }
}
