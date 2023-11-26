package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 思路:按照中序遍历这课树，那么这个序列就是从小到大排列的。如果节点被交换那么一定会出现逆序对
 * 分为两种情况
 * 1）交换的两个节点是相邻的
 *   1 2 4 3 5 6
 *          第一个错误节点->逆序对的第一个   第二个错误节点->逆序对的第二个
 * 2) 交换的两个节点是不相邻的
 *    1 5 3 4 2 6
 *          第一个错误节点->第一个逆序对(5 3)的第一个即5   第二个错误节点->第二个逆序对(4,2)的第二个即2
 * 采用中序遍历，左 根 右
 */
public class _99_恢复二叉搜索树 {
    // 中序遍历：时间复杂度O(n)、空间复杂度O(1)
    private TreeNode prev;//上一次中序遍历过的节点
    private TreeNode first;//第一个错误节点
    private TreeNode second;//第二个错误节点
    private void find(TreeNode node) {
        // 出现了逆序对
        if (prev != null && prev.val > node.val) {
            //不管是第一次的逆序对还是第二次的逆序对，都把较小的节点赋值给second
            // 第2个错误节点：最后一个逆序对中较小的那个节点
            second = node;
            // 第1个错误节点：第一个逆序对中较大的那个节点
            if (first != null) return;
            first = prev;
        }
        prev = node;
    }

    public void recoverTree(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                // 找到前驱节点(predecessor)、后继节点(successor)
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else { // pred.right == node
                    find(node);
                    pred.right = null;
                    node = node.right;
                }
            } else {
                find(node);
                node = node.right;
            }
        }
        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * @param root 是一棵错误的二叉搜索树（有2个节点被错误交换）
     */
    public void recoverTree1(TreeNode root) {
        findWrongNodes(root);
        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        find(root);
        findWrongNodes(root.right);
    }
}
