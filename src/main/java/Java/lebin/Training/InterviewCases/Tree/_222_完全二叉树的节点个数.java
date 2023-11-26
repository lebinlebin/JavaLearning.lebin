package Java.lebin.Training.InterviewCases.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 222. 完全二叉树的节点个数
 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 */


public class _222_完全二叉树的节点个数 {
    //按照普通二叉树的求法
    //递归解法
//    时间复杂度：O(n)
//    空间复杂度：O(log n)，算上了递归系统栈占用的空间
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int treeNum = leftNum + rightNum + 1;
        return treeNum;
    }

    //迭代解法
//    时间复杂度：O(n)
//    空间复杂度：O(n)
    int countNodes_iter(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode  node = queue.poll();
                result ++; // 记录节点数量
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 针对完全二叉树的解法
     * 满二叉树的结点数为：2^depth - 1
     */
    //时间复杂度：O(log n × log n)
    //空间复杂度：O(log n)
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
