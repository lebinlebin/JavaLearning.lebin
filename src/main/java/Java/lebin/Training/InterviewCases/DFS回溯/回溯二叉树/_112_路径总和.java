package Java.lebin.Training.InterviewCases.DFS回溯.回溯二叉树;

/**
 *
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中 是否 存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 */
public class _112_路径总和 {
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
    public boolean hasPathSum(TreeNode root, int targetsum){
        if(root == null) return false;
        return traversal(root,targetsum-root.val);
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
