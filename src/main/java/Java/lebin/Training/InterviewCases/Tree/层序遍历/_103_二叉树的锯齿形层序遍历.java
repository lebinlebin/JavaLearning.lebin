package Java.lebin.Training.InterviewCases.Tree.层序遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class _103_二叉树的锯齿形层序遍历 {
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        LinkedList<List<Integer>> res = new  LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if(flag){
                    list.addFirst(cur.val);
                }else{
                    list.addLast(cur.val);
                }
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
