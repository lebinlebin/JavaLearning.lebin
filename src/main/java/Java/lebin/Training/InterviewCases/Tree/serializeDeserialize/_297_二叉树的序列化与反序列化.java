package Java.lebin.Training.InterviewCases.Tree.serializeDeserialize;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class _297_二叉树的序列化与反序列化 {
    //层序遍历
    String SEP = ",";
    String NULL = "null";
    public String serialize(TreeNode root) {
        if(null == root) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            //层序遍历
            if(cur == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.append("]").toString();
    }


    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        //将字符串转化为列表
        data = data.substring(1,data.length()-1);
//		LinkedList<String> nodes = new LinkedList<>();//层序遍历就不需要双向链表了，一个数组就可以了
        String[] nodes = data.split(SEP);
        //第一个元素就是root的值
        TreeNode  root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=1;i<nodes.length;){
            TreeNode parent = q.poll();
            String left = nodes[i++];
            if(!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else{
                parent.left = null;
            }
            String right = nodes[i++];
            if(!right.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else{
                parent.right = null;
            }
        }
        return  root;
    }
}
