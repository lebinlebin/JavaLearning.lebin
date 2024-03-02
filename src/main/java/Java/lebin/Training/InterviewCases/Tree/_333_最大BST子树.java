package Java.lebin.Training.InterviewCases.Tree;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 *  * 输入：root = [10,5,15,1,8,null,7]
 *  * 输出：3
 *  * 解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。
 *  * 示例 2：
 *  *
 *  * 输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 *  * 输出：2
 *
 * 333. 最大 BST 子树
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * 左子树的值小于其父（根）节点的值。
 * 右子树的值大于其父（根）节点的值。
 * 注意:
 * 子树必须包含其所有后代。
 * 进阶:
 * 你能想出 O(n) 时间复杂度的解法吗？
 *

 */
public class _333_最大BST子树 {
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        //深度优先搜索 判定每个子树是否是BST
        if (root == null) return 0;
        //每次判定是否是BST之前要初始化变量
        if (isValidBST(root,null,null)) {
            res = Math.max(res, getCount(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return res;
    }

    //获取当前树的节点个数
    private int getCount(TreeNode root) {
        if (root == null) return 0;
        return getCount(root.right) + getCount(root.left) + 1;
    }

    //判断当前树是否是BST
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }


}
