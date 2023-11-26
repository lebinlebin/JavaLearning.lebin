package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//层序遍历的时候把一层求个总和在取一个均值。
public class _637_二叉树的层平均值 {
        List<Double> res = new LinkedList<>();
        public List<Double> averageOfLevels(TreeNode root)  {
            //用层序遍历解决
            if(root == null){ return new LinkedList<>();}
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int count = queue.size();
                TreeNode cur = null;
                double sum = 0;
                for (int i = 0; i < count; i++) {
                    cur = queue.poll();
                    sum += cur.val;
                    if(cur.left!=null){queue.add(cur.left);}
                    if(cur.right!=null){queue.add(cur.right);}
                }
                res.add(sum/count);
            }
            return res;
        }
}
