package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        LinkedList<List<Integer>> res = new  LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> result = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if(cur.left!=null){queue.add(cur.left);}
                if(cur.right!=null){queue.add(cur.right);}
            }
            res.add(result);
        }
        return res;
    }
}
