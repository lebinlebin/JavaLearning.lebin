package Java.lebin.Training.InterviewCases.Tree;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class _236_二叉树的最近公共祖先 {
    /*
    要是能自底向上查找就好了，这样就可以找到公共祖先了。那么二叉树如何可以自底向上查找呢？
    回溯啊，二叉树回溯的过程就是从低到上。
    后序遍历（左右中）就是天然的回溯过程，可以根据左右子树的返回值，来处理中节点的逻辑。

    1. 首先最容易想到的一个情况：如果找到一个节点，发现左子树出现结点p，右子树出现节点q，或者 左子树出现结点q，右子树出现节点p，
        那么该节点就是节点p和q的最近公共祖先。
    2. 判断逻辑是 如果递归遍历遇到q，就将q返回，遇到p 就将p返回，那么如果 左右子树的返回值都不为空，说明此时的中节点，一定是q 和p 的最近祖先。
       因为是自底向上的回溯逻辑，遇到的第一个两边返回值都不为空的节点就是最近的公共祖先
     */
    /*
归纳如下三点：
求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从底向上的遍历方式。
在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }
        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);//左
        TreeNode right = lowestCommonAncestor(root.right, p, q);//右
        //中
        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
}
