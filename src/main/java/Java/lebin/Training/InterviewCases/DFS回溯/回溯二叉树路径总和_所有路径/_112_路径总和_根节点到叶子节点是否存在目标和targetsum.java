package Java.lebin.Training.InterviewCases.DFS回溯.回溯二叉树路径总和_所有路径;

/**
 *
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中 是否 存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 */
/*
时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
 */
public class _112_路径总和_根节点到叶子节点是否存在目标和targetsum {
    public boolean hasPathSum(TreeNode root, int targetsum){
        if(root == null) return false;
        return traversal(root,targetsum-root.val);
    }

    //递归
    public boolean traversal(TreeNode root, int targetsum) {
        // 叶子结点
        if (root.left == null && root.right == null && targetsum==0) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        if (root.left != null) {
            targetsum -= root.left.val;
            boolean left = traversal(root.left, targetsum);
            if (left) {      // 已经找到
                return true;
            }
            targetsum += root.left.val;
        }

        if (root.right != null) {
            targetsum -= root.right.val;
            boolean right = traversal(root.right, targetsum);
            if (right) {     // 已经找到
                return true;
            }
            targetsum += root.right.val;
        }

        return false;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
