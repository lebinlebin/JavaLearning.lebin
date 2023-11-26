package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 111. 二叉树的最小深度
 给定一个二叉树，找出其最小深度。
 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
public class _111_二叉树的最小深度 {
    //递归法，相比求MaxDepth要复杂点
    // 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
    //时间复杂度：O(N)。对每个节点访问一次。
    //空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，
    // 最坏情况下，树呈现链状，空间复杂度为 O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为O(logN)。
    public int minDepth(TreeNode root) {
        //后序遍历
        if(root == null){ return 0;}
        //找左子树和右子树的最小值+1
        int leftDepth = minDepth(root.left);//左边
        int rightDepth = minDepth(root.right);//右边
        //一下为中，，组成后序遍历
        // 当⼀个左⼦树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right!=null) {
            return 1 + rightDepth;
        }
        // 当⼀个右⼦树为空，左不为空，这时并不是最低点
        if (root.right == null && root.left!=null) {
            return 1 + leftDepth;
        }
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;
    }


    /**
     * 迭代法，层序遍历
     * 相对于 104.二叉树的最大深度 ，本题还也可以使用层序遍历的方式来解决，思路是一样的。
     * 需要注意的是，只有当左右孩子都为空的时候，才说明遍历的最低点了。如果其中一个孩子为空则不是最低点
     */
    //时间复杂度：O(N)。对每个节点访问一次。
    //空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
    public int minDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }
}
