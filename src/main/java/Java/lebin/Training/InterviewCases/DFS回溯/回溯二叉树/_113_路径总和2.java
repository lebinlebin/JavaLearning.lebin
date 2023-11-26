package Java.lebin.Training.InterviewCases.DFS回溯.回溯二叉树;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class _113_路径总和2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res; // 非空判断
        path.add(root.val);
        traversal(root, targetSum - root.val);
        return res;
    }

    public void traversal(TreeNode cur, int targetSum) {
        // 遇到了叶子节点
        if (cur.left == null && cur.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetsum，返回
        }

        if (cur.left != null) {
            path.add(cur.left.val);
            targetSum = targetSum - cur.left.val;
            traversal(cur.left, targetSum);
            path.remove(path.size() - 1); // 回溯
            targetSum =  targetSum +  cur.left.val;
        }
        if (cur.right != null) {
            path.add(cur.right.val);
            targetSum = targetSum - cur.right.val;
            traversal(cur.right, targetSum);
            path.remove(path.size() - 1); // 回溯
            targetSum =  targetSum +  cur.right.val;
        }
    }

}
