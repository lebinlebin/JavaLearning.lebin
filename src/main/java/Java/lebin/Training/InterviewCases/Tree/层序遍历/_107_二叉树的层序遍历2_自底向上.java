package Java.lebin.Training.InterviewCases.Tree.层序遍历;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
public class _107_二叉树的层序遍历2_自底向上 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(0,list);//相对于102.二叉树的层序遍历，就是最后把result数组反转一下就可以了。
        }
        return res;
    }
}
