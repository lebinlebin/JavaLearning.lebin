package Java.lebin.Training.InterviewCases.Tree;

import java.util.Stack;

/*
404.左叶子之和
计算给定二叉树的所有左叶子之和。
 */
//首先要注意是判断左叶子，不是二叉树左侧节点，所以不要上来想着层序遍历。
//左叶子的明确定义：节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
//判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。
/*
当遇到左叶子节点的时候，记录数值，然后通过递归求取左子树左叶子之和，和 右子树左叶子之和，相加便是整个树的左叶子之和。
 */
//后续遍历逻辑
public class _404_左叶子之和 {
    //递归
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right== null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);    // 左
        int rightValue = sumOfLeftLeaves(root.right);  // 右

        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;// 左子树就是一个左叶子的情况
        }
        int sum = midValue + leftValue + rightValue;  // 中
        return sum;
    }

    //迭代法
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return result;
    }
}
