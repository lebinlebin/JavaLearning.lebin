package Java.lebin.Training.InterviewCases.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 110. 平衡二叉树
 给定一个二叉树，判断它是否是高度平衡的二叉树。
 本题中，一棵高度平衡二叉树定义为：
 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 */
public class _110_平衡二叉树 {
    //递归法
    //既然要求比较高度，必然是要后序遍历。
    //求深度用前序遍历；求高度用后序遍历
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;//终止条件1
        }
        int leftHeight = getHeight(root.left);//左右中  后序遍历
        if (leftHeight == -1) {
            return -1;//终止条件2
        }
        int rightHeight = getHeight(root.right);//左右中  后序遍历
        if (rightHeight == -1) {
            return -1;//终止条件3
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {//中  后序遍历
            return -1;//终止条件4
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }



    /**
     * 迭代法，效率较低，计算高度时会重复遍历
     * 时间复杂度：O(n^2)
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 比较左右子树的高度差，输出
                if (Math.abs(getHeight2(inNode.left) - getHeight2(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                root = null;// 当前结点下，没有要遍历的结点了
            } else {
                root = inNode.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
    }

    /**
     * 层序遍历，求结点的高度
     */
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
    //---------------------------------------------------------------------------
    /**
     * 优化迭代法，针对暴力迭代法的getHeight方法做优化，利用TreeNode.val来保存当前结点的高度，这样就不会有重复遍历
     * 获取高度算法时间复杂度可以降到O(1)，总的时间复杂度降为O(n)。
     * 时间复杂度：O(n)
     */
    public boolean isBalanced3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 输出
                if (Math.abs(getHeight3(inNode.left) - getHeight3(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                root = null;// 当前结点下，没有要遍历的结点了
            } else {
                root = inNode.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
    }

    /**
     * 求结点的高度
     */
    public int getHeight3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = root.left != null ? root.left.val : 0;
        int rightHeight = root.right != null ? root.right.val : 0;
        int height = Math.max(leftHeight, rightHeight) + 1;
        root.val = height;// 用TreeNode.val来保存当前结点的高度
        return height;
    }

}
