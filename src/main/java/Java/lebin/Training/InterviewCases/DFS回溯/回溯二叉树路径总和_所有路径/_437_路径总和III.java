package Java.lebin.Training.InterviewCases.DFS回溯.回溯二叉树路径总和_所有路径;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
437. 路径总和 III
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class _437_路径总和III {
    /*
    时间复杂度：O(N^2)，其中 N 为该二叉树节点的个数。对于每一个节点，求以该节点为起点的路径数目时，则需要遍历以该节点为根节点的子树的所有节点，
    因此求该路径所花费的最大时间为 O(N)，我们会对每个节点都求一次以该节点为起点的路径数目，因此时间复杂度为 O(N^2)
    空间复杂度：O(N)，考虑到递归需要在栈上开辟空间。
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }




    //方法二: 前缀和
    /*
    解法一中应该存在许多重复计算。我们定义节点的前缀和为：由根结点到当前结点的路径上所有节点的和。
    我们利用先序遍历二叉树，记录下根节点 root 到当前节点 p 的路径上除当前节点以外所有节点的前缀和，
    在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 curr 减去 targetSum。
    todo:优化版本
    时间复杂度：O(N)，其中 N 为二叉树中节点的个数。利用前缀和只需遍历一次二叉树即可。
    空间复杂度：O(N)。
     */
    public int pathSum_prefix(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
