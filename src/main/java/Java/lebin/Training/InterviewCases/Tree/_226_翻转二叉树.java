package Java.lebin.Training.InterviewCases.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 */
/*
注意只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果
这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不方便，因为中序遍历会把某些节点的左右孩子翻转了两次
那么层序遍历可以不可以呢？依然可以的！只要把每一个节点的左右孩子翻转一下的遍历方式都是可以的！
 */
public class _226_翻转二叉树 {
    /** DFS递归
     * 前后序遍历都可以
     * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
     */
    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //swapChildren(root);//也是可以的
        invertTree(root.left);//左
        invertTree(root.right);//右
        swapChildren(root);//中
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
    //----------------------------------------------------------
    //BFS 广度优先遍历 也就是层序遍历，层数遍历也是可以翻转这棵树的，因为层序遍历也可以把每个节点的左右孩子都翻转一遍，
    //    //时间复杂度：O(N)
    //    //空间复杂度：O(N)
    public TreeNode invertTree_bfs(TreeNode root) {
        if (root == null) {return null;}
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
