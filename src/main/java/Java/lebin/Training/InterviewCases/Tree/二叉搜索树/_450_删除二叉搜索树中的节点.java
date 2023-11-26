package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 450. 删除二叉搜索树中的节点
 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 */
public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
}
