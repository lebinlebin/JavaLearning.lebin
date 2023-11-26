package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;//如果一直遍历到null了那么就是true了
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    // 递归
    TreeNode max;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    // 迭代
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }
}
