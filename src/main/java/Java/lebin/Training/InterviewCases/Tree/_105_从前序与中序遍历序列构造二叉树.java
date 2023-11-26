package Java.lebin.Training.InterviewCases.Tree;

import java.util.*;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 前序遍历左子树范围: preorder_left+1,preorder_left+size_left_subtree,
 * 中序遍历左子树范围: inorder_left,inorder_root-1
 * 中序遍历 inorder = [9,3,15,20,7]
 * 前序遍历右子树范围: preorder_left+size_left_subtree+1, preorder_right
 * 中序遍历右子树范围: inorder_root+1,inorder_right
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  整体是一个前序遍历的代码逻辑。
 *  每次利用一个hashMap过得root节点的index，对两个数组进行拆分。然后计算不同的index范围进行递归构建二叉树
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        //要通过递归方式构建二叉树，就要将构造二叉树的数组和边界值作为递归函数的参数才可以，所以这里这个函数的参数会长成这个鬼样子。
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 整体逻辑是一个前序遍历构造二叉树
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        //边界条件
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 通过中序遍历得到左子树中的节点数目。可以用于中序遍历和前序遍历的遍历区间的计算
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder,
                preorder_left + 1, preorder_left + size_left_subtree,
                inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder,
                preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);
        return root;
    }
}
