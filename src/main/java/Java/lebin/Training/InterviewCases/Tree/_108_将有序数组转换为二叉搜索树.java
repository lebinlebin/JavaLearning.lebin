package Java.lebin.Training.InterviewCases.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constuct(nums, 0, nums.length - 1);
    }

    public TreeNode constuct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = left + (right-left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constuct(nums, left, mid - 1);
        root.right = constuct(nums, mid + 1, right);
        return root;
    }
}
