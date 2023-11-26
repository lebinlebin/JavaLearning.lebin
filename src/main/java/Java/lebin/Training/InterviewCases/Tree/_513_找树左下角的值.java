package Java.lebin.Training.InterviewCases.Tree;

import java.util.LinkedList;
import java.util.Queue;

//513.找树左下角的值
// 给定一个二叉树，在树的最后一行找到最左边的值。
/*
在树的最后一行找到最左边的值。
首先要是最后一行，然后是最左边的值。
如果使用递归法，如何判断是最后一行呢，其实就是深度最大的叶子节点一定是最后一行。
所以要找深度最大的叶子节点。
那么如何找最左边的呢？可以使用前序遍历（当然中序，后序都可以，因为本题没有 中间节点的处理逻辑，只要左优先就行），
保证优先左边搜索，然后记录深度最大的叶子节点，此时就是树的最后一行最左边的值。
 */
public class _513_找树左下角的值 {
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    private int maxDepth = -1;
    private int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root,0);
        return result;
    }

    private void traversal (TreeNode root,int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
            return;
        }
        if (root.left != null){
            depth++;
            traversal(root.left,depth);
            depth--;//回溯
        }
        if (root.right != null) {
            depth++;
            traversal(root.right,depth);
            depth--;//回溯
        }
        return;
    }

    //迭代法
    //本题使用层序遍历再合适不过了，比递归要好理解得多！
    //只需要记录最后一行第一个节点的数值就可以了
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

}
