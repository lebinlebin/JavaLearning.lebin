package Java.lebin.Training.InterviewCases.Tree.二叉搜索树;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.Arrays;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 问：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，
 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
 */
/*
思路 先找到右子树的开始位置，然后分别进行左右子树递归处理
 */
public class _33_二叉搜索树的后序遍历序列 {

	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}
	boolean recur(int[] postorder, int i, int j) {
		if(i >= j) return true;
		int p = i;
		//i记录了右子树开始的位置
		//                p
		// 左子树 <= root | 右子树 >root    root
		// -----         | -----
		while(postorder[p] < postorder[j]) p++;//一直找到右子树的位置
		int m = p;
		//i记录了右子树开始的位置
		//                                p
		// 左子树 <= root | 右子树 >root    root
		// -----         | -----
		while(postorder[p] > postorder[j]) p++;//一直找到root节点位置
		//                递归遍历左子树                       递归遍历右子树
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}


	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null||sequence.length <= 0){
			return false;
		}
		int len = sequence.length;
		int root = sequence[len-1];
		int i=0;
		for(;i<len-1;i++){
			if(root<=sequence[i])
				break;
		}
		//i记录了右子树开始的位置
		//             i
		// 左子树 <= root | 右子树 >root    root
		// -----         | -----            -

		int j=i;
		for(;j<len-1;j++){//右子树的范围
			if(root > sequence[j]){
				return false;
			}
		}

		boolean leftFlag = true;

		if (i>0) {
			leftFlag = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
		}

		boolean rightFlag=true;
		if (i<len-1) {
			rightFlag=VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length-1));
		}

		return leftFlag && rightFlag;
	}
}
