package Java.lebin.Training.InterviewCases.Tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class _145_二叉树的后序遍历 {
    List<Integer> result = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
    //二叉树后序遍历的迭代写法
    public List<Integer> postorderTraversal_iter(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            result.add(cur.val);
            stack.pop();
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }
        //对result进行翻转
        Collections.reverse(result);
        return result;
    }
}
