package Java.lebin.Training.InterviewCases.Tree.层序遍历;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
//二叉树层序遍历用队列; 前序中序后序遍历用堆栈
//层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了。
public class _199_二叉树的右视图 {
//时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
//空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
    List<Integer> res = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        //用层序遍历解决
        if(root == null){return new LinkedList<>();}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < count; i++) {
                cur = queue.poll();//右边节点
                if(i == count-1) {res.add(cur.val);}
                if(cur.left!=null){queue.add(cur.left);}
                if(cur.right!=null){queue.add(cur.right);}
            }
        }
        return res;
    }
}
