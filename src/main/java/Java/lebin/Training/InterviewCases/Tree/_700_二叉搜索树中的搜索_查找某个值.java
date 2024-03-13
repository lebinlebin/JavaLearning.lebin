package Java.lebin.Training.InterviewCases.Tree;


/**
 700. 二叉搜索树中的搜索
 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class _700_二叉搜索树中的搜索_查找某个值 {
    // 递归，利用二叉搜索树特点，优化
    //时间复杂度：O(N)，其中 N 是二叉搜索树的节点数。最坏情况下二叉搜索树是一条链，且要找的元素比链末尾的元素值还要小（大），这种情况下我们需要递归 N 次。
    //空间复杂度：O(N)。最坏情况下递归需要 O(N) 的栈空间。
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // 递归，普通二叉树
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST2(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST2(root.right, val);
    }
}
