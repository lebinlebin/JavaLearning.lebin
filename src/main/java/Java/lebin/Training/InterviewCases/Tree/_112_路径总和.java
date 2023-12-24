package Java.lebin.Training.InterviewCases.Tree;

import java.util.Stack;

/*
112. 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class _112_路径总和 {
    //递归
    //时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
    //空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为O(logN)。
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = haspathsum(root.left, targetsum);
            if (left) {      // 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = haspathsum(root.right, targetsum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }
    //方法一：广度优先搜索
    //时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
    //空间复杂度：O(N)，其中 N是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
    public boolean hasPathSum2(TreeNode root, int targetsum) {
        if(root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();//记录树节点
        Stack<Integer> stack2 = new Stack<>();//记录数值
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.isEmpty()) {
            int size = stack1.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(node.left == null && node.right == null && sum == targetsum) {
                    return true;
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.right != null){
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if(node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
