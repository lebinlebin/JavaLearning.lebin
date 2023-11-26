package Java.lebin.Training.InterviewCases.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // 构造哈希映射，帮助我们快速定位根节点。还是根据中序遍历获取节点的遍历区间范围
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        //要通过递归方式构建二叉树，就要将构造二叉树的数组和边界值作为递归函数的参数才可以，所以这里这个函数的参数会长成这个鬼样子。
        return myBuildTree(postorder, inorder, 0, n-1, 0, n - 1);
    }

    /**
     * 整体逻辑是一个前序遍历构造二叉树
     */
    public static TreeNode myBuildTree(int[] postorder, int[] inorder, int postorder_left, int postorder_right, int inorder_left, int inorder_right) {
        //边界条件
        if (postorder_left > postorder_right||inorder_left > inorder_right) {
            return null;
        }

        // 中序遍历中的最后节点就是根节点
        int postorder_root = postorder_right;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(postorder[postorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[postorder_root]);

        // 通过中序遍历得到左子树中的节点数目。可以用于中序遍历和前序遍历的遍历区间的计算
        int size_left_subtree = inorder_root - inorder_left;
        /**
         *  * 中序遍历 inorder =   [9,3,15,20,7]
         *  * 中序遍历左子树范围: inoder_left,inorder_root-1
         *  * 后序遍历左子树范围: postorder_left,postorder_left+size_left_subtree

         *  *后序遍历 postorder = [9,15,7,20,3]
         *  * 中序遍历右子树范围: inorder_root+1,inorder_right
         *  * 后序遍历右子树范围: postorder_left+size_left_subtree+1,postorder_right - 1
         */
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(postorder, inorder, postorder_left+size_left_subtree, postorder_right-1, inorder_root + 1, inorder_right);
        root.left = myBuildTree(postorder, inorder, postorder_left, postorder_left+size_left_subtree-1, inorder_left, inorder_root - 1);
         return root;
    }

    public static void main(String[] args) {
        int [] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        buildTree(inorder,postorder);
    }
}
