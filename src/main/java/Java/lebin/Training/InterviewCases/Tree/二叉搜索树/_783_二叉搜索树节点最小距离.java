package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 遇到在二叉搜索树上求什么最值，求差值之类的，要充分利用BST是有序的这一特点。——mark，mark
 */
public class _783_二叉搜索树节点最小距离 {
    int pre = -1;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        traversal(root);
        return min;
    }
    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        traversal(root.right);
    }
}
