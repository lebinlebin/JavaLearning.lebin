package Java.lebin.Training.InterviewCases.Tree.serializeDeserialize;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 
 * 前序遍历方法
 */
public class _37_剑指Offer_序列化二叉树_preorder_submit {
	String SEP = ",";
	String NULL = "null";
	public String serialize(TreeNode root) {
		if(null == root) return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		serialize(root,sb);
		sb.append("]");
		return sb.toString();
	}
	private  void serialize(TreeNode root,StringBuilder sb){
		//递归终止条件
		if(root==null) {
			sb.append(NULL).append(SEP);
			return;//终止条件
		}
		//前序遍历
		sb.append(root.val).append(SEP);
		serialize(root.left,sb);
		serialize(root.right,sb);
	}

	public TreeNode deserialize(String data) {
		if(data.equals("[]")) return null;
		//将字符串转化为列表
		LinkedList<String> nodes = new LinkedList<>();
		data = data.substring(1,data.length()-1);
		for(String s: data.split(SEP)){
			nodes.addLast(s);
		}
		return deserialize(nodes);
	}
	private TreeNode deserialize(LinkedList<String> nodes){
		//递归终止条件
		if(null == nodes||nodes.isEmpty()){
			return null;
		}
		String first = nodes.removeFirst();//根节点
		if(first.equals(NULL)) return null;
		TreeNode root = new TreeNode(Integer.parseInt(first));

		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}
}
