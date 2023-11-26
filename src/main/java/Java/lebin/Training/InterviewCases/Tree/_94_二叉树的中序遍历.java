package Java.lebin.Training.InterviewCases.Tree;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class _94_二叉树的中序遍历 {
    //时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
    //空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
    static  List<Integer> res = new ArrayList<Integer>();
    //递归方式
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }


    //迭代和递归两种方式实现中序遍历二叉树
    //左 根 右
    public List<Integer> inorderTraversal_iter(TreeNode root) {
        if(null == root) return new LinkedList<>();
        List<Integer> result = new  ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur  = root;

        //注意！！！注意！！！ 这里while条件是"||"
        while(null != cur || !stack.isEmpty()){
            if(null != cur){
                stack.push(cur);
                cur = cur.left;
            }else{//上边的代码执行到cur==null，说明左子树到了叶子节点了，进入else分支
                cur = stack.peek();
                stack.pop();
                result.add(cur.val);//中序遍历
                cur = cur.right;
            }
        }
    return result;
    }
//===========================>>>>测试代码<<<<<==============================================

    public static TreeNode generate_tree(Integer [] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]); // 建立根节点

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先左后右
        boolean isleft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode peek = queue.getFirst();
            if (isleft) {
                if (arr[i] != null) {
                    peek.left = new TreeNode(arr[i]);
                    queue.add(peek.left);
                }
                isleft = false;
            } else {
                if (arr[i] != null) {
                    peek.right = new TreeNode(arr[i]);
                    queue.add(peek.right);
                }
                queue.removeFirst();
                isleft = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        TreeNode root = generate_tree(arr);
        List<Integer> res = inorderTraversal(root);
        for(Integer node : res){
            System.out.println(node);
        }
    }

}
