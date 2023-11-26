package Java.lebin.Training.InterviewCases.Tree;

/**
 100. 相同的树
 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 都为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        // 一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (root1.val != root2.val) return false;
        // root1 和 root2 该比的都比完了
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
