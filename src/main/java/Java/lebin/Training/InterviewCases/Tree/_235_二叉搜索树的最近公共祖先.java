package Java.lebin.Training.InterviewCases.Tree;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
/*
二叉搜索树是有序的，那得好好利用一下这个特点。
在有序树里，如果判断一个节点的左子树里有p，右子树里有q呢？
因为是有序树，如果 中间节点是 q 和 p 的公共祖先，那么 中节点的数组 一定是在 [p, q]区间的。
即 中节点 > p && 中节点 < q 或者 中节点 > q && 中节点 < p。
那么只要从上到下去遍历，遇到 cur节点是数值在[p, q]区间中则一定可以说明该节点cur就是p 和 q的公共祖先。
那问题来了，一定是最近公共祖先吗？
所以当我们从下向上去递归遍历，第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先。
而递归遍历顺序，本题就不涉及到 前中后序了（这里没有中节点的处理逻辑，遍历顺序无所谓了）。

确定单层递归的逻辑
在遍历二叉搜索树的时候就是寻找区间[p->val, q->val]（注意这里是左闭又闭）
那么如果 cur->val 大于 p->val，同时 大于q->val，那么就应该向左遍历（说明目标区间在左子树上）。
 */
public class _235_二叉搜索树的最近公共祖先 {
    //时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为logN （满二叉树），最大为 N （退化为链表）。
    //空间复杂度 O(1) ： 使用常数大小的额外空间。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    TreeNode traversal(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return cur;
        // 中
        if (cur.val > p.val && cur.val > q.val) {   // 左
            TreeNode left = traversal(cur.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (cur.val < p.val && cur.val < q.val) {   // 右
            TreeNode right = traversal(cur.right, p, q);
            if (right != null) {
                return right;
            }
        }
        //那么cur就在p和q中间，就返回cur就好了
        return cur;
    }
}
