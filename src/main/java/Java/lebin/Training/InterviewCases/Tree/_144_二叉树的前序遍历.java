package Java.lebin.Training.InterviewCases.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 144
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class _144_二叉树的前序遍历 {
    //递归写法
    List<Integer> result = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>();
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    //迭代写法
    public List<Integer> preorderTraversal_iter(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        //声明栈的方式要记忆！！！
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            result.add(cur.val);
            stack.pop();
            /*
            前序遍历是中左右，每次先处理的是中间节点，那么先将根节点放⼊栈中，然后将右孩⼦加⼊栈，再加⼊左孩⼦。
            为什么要先加⼊右孩⼦，再加⼊左孩⼦呢？因为这样出栈的时候才是中左右的顺序。
             */
            //注意代码中空节点不⼊栈
            if(null != cur.right){
                stack.push(cur.right);
            }
            if(null != cur.left){
                stack.push(cur.left);
            }

        }
        return result;
    }



}
