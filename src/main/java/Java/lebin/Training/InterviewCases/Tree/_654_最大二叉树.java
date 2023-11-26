package Java.lebin.Training.InterviewCases.Tree;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class _654_最大二叉树 {
    //时间复杂度：O(n^2)，其中 n 是数组 nums 的长度。在最坏的情况下，数组严格递增或递减，需要递归 n 层，
    // 第 i(0≤i<n) 层需要遍历 n−i个元素以找出最大值，总时间复杂度为 O(n^2)
    //空间复杂度：O(n)，即为最坏情况下需要使用的栈空间。
    //构造树一般采用的是前序遍历，因为先构造中间节点，然后递归构造左子树和右子树。
    TreeNode constructMaximumBinaryTree(int[] nums) {
        //这种需要进行递归调用，并且参数比较多的都要像这样 return一个新的函数，放在里面
        return build(nums, 0, nums.length - 1);
    }

    /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
