package Java.lebin.Training.InterviewCases.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
//相信这道题目很多同学疑惑的点是如何同时遍历两个二叉树呢？
//其实和遍历一个树逻辑是一样的，只不过传入两个树的节点，同时操作。
// 二叉树使用递归，就要想使用前中后哪种遍历方式？本题使用哪种遍历都是可以的！
//本题以前序遍历为例。
    /*
时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，因此被访问到的节点数不会超过较小的二叉树的节点数。
空间复杂度：O(min(m,n)). 空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
     */
public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
        return t2;
    }
    if (t2 == null) {
        return t1;
    }
    //前序遍历
    TreeNode merged = new TreeNode(t1.val + t2.val);
    merged.left = mergeTrees(t1.left, t2.left);
    merged.right = mergeTrees(t1.right, t2.right);
    return merged;
}
}
