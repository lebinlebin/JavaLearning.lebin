package Java.lebin.Training.InterviewCases.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 101. 对称二叉树
 给定一个二叉树，检查它是否是镜像对称的。
/**
 * 1. 确定递归函数的参数和返回值
 * 2. 确定终止条件
 * 3. 确定单层递归的逻辑
 * 对于需要收集左右孩子的信息然后做处理的就需要后序遍历方式
 * 我们可以看出使用的遍历方式，左子树左右中，右子树右左中，所以我把这个遍历顺序也称之为“后序遍历”（尽管不是严格的后序遍历）
 */

public class _101_对称二叉树 {
    //时间复杂度：O(N)
    //空间复杂度：O(N)
    //递归法
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        //首先排除空节点的情况
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        //// 排除了空节点，再排除数值不相同的情况
        if (left.val != right.val) {
            return false;
        }
        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);// 左子树：左、 右子树：右
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);// 左子树：右、 右子树：左
        return compareOutside && compareInside;
    }

    /**
     * 迭代法
     * 使用队列
     * 通过队列来判断根节点的左子树和右子树的内侧和外侧是否相等
     */
    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public boolean isSymmetric3(TreeNode root) {
        if(root == null){return true;}
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);// 将左子树头结点加入队列
        deque.offer(root.right);// 将右子树头结点加入队列
        while (!deque.isEmpty()) {// 接下来就要判断这两个树是否相互翻转
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {// 左节点为空、右节点为空，此时说明是对称的
                continue;
            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);// 加入左节点左孩子
            deque.offer(rightNode.right);// 加入右节点右孩子
            deque.offer(leftNode.right);// 加入左节点右孩子
            deque.offer(rightNode.left);// 加入右节点左孩子
        }
        return true;
    }

}
