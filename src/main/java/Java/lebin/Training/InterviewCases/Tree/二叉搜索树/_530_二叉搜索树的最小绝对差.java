package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;
/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

二叉搜索树采用中序遍历，其实就是一个有序数组。
遇到在二叉搜索树上求什么最值啊，差值之类的，就把它想成在一个有序数组上求最值，求差值，这样就简单多了。
 */
public class _530_二叉搜索树的最小绝对差 {
//时间复杂度：O(n)，其中 n 为二叉搜索树节点的个数。每个节点在中序遍历中都会被访问一次且只会被访问一次。
//空间复杂度：O(n)。递归函数的空间复杂度取决于递归的栈深度，而栈深度在二叉搜索树为一条链的情况下会达到 O(n)级别。
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root == null) return;
        //左
        traversal(root.left);
        //中
        if(pre!=null){
            result = Math.min(result, root.val-pre.val);//当前节点一定比前一个节点要大
        }
        pre = root;
        //右
        traversal(root.right);
    }

}
