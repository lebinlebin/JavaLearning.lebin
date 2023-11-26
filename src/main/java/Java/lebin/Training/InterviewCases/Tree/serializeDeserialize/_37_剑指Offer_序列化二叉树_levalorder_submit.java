package Java.lebin.Training.InterviewCases.Tree.serializeDeserialize;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 
 * 层序遍历方法
 */
public class _37_剑指Offer_序列化二叉树_levalorder_submit {
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
