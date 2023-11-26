package Java.lebin.Training.InterviewCases.Tree.层序遍历;
import java.util.LinkedList;
import java.util.Queue;

/**
 104. 二叉树的最大深度
 给定一个二叉树，找出其最大深度。
 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class _104_二叉树的最大深度 {
    //层序遍历方法 多少层就是深度
    //使用迭代法的话，使用层序遍历是最为合适的，因为最大的深度就是二叉树的层数，和层序遍历的方式极其吻合。
    //    时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
    //    空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty())
        {
            int len = que.size();
            while (len > 0)
            {
                TreeNode node = que.poll();
                if (node.left != null)  que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                len--;
            }
            depth++;
        }
        return depth;
    }

    //递归解法,
    // 本质求取递归深度即可
    // 后序遍历方式，因为先孩子节点，后父节点
    // 时间复杂度：O(n) 每个节点在递归中只被遍历一次。
    // 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
    public int maxDepth_(TreeNode root) {
        //递归终止条件
        if(root == null){
            return 0;
        }
        int leftdepth = maxDepth_(root.left); //左
        int rightdepth = maxDepth_(root.right);//右
        int depth = Math.max(leftdepth,rightdepth)+1;//中
        return depth;//每返回一次就多加1
    }
}
