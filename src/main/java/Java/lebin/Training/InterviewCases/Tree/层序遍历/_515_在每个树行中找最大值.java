package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//层序遍历，取每一层的最大值
public class _515_在每个树行中找最大值 {
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new LinkedList<>();
        LinkedList<Integer> res = new  LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            //也可以用for循环
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max,cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
