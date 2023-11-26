package Java.lebin.Training.InterviewCases.DP.打家劫舍;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
//简化一下这个问题：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），
// 问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
public class _337_打家劫舍3 {
	//	时间复杂度：O(n)，每个节点只遍历了一次
	//	空间复杂度：O(log n)，算上递推系统栈的空间
/*
动态规划法
1. dp定义
	要求一个节点 偷与不偷的两个状态所得到的金钱，那么返回值就是一个长度为2的数组。
	dp数组（dp table）以及下标的含义：下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
	所以本题dp数组就是一个长度为2的数组！
//	那么有同学可能疑惑，长度为2的数组怎么标记树中每个节点的状态呢？
//	别忘了在递归的过程中，系统栈会保存每一层递归的参数。

2. 确定终止条件
	在遍历的过程中，如果遇到空节点的话，很明显，无论偷还是不偷都是0，所以就返回
	if (cur == NULL) return vector<int>{0, 0};
	这也相当于dp数组的初始化
3. 遍历顺序
首先明确的是使用后序遍历。 因为要通过递归函数的返回值来做下一步计算。

4. 单层递归逻辑
	如果是偷当前节点，那么左右孩子就不能偷，val1 = cur->val + left[0] + right[0];
	如果不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的，所以：val2 = max(left[0], left[1]) + max(right[0], right[1]);
	最后当前节点的状态就是{val2, val1}; 即：{不偷当前节点得到的最大金钱，偷当前节点得到的最大金钱}
 */
	// 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
	// root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
	// Math.max(rob(root.right)[0], rob(root.right)[1])
	// 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
	// root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
	public int rob3(TreeNode root) {
		int[] res = robTree(root);
		return Math.max(res[0], res[1]);
	}

	int[] robTree(TreeNode root) {
		//长度为2的数组，0：不偷，1：偷
		int res[] = new int[2];
		if (root == null)  return res;
		//采用后续遍历，因为我们需要根据递归结果进行计算
		int[] left = robTree(root.left);
		int[] right = robTree(root.right);
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];
		return res;
	}




	// 1.递归去偷，超时
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		int money = root.val;
		if (root.left != null) {
			money += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			money += rob(root.right.left) + rob(root.right.right);
		}
		return Math.max(money, rob(root.left) + rob(root.right));
	}

	// 2.递归去偷，记录状态
	// 执行用时：3 ms , 在所有 Java 提交中击败了 56.24% 的用户
	public int rob1(TreeNode root) {
		Map<TreeNode, Integer> memo = new HashMap<>();
		return robAction(root, memo);
	}

	int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
		if (root == null)
			return 0;
		if (memo.containsKey(root))
			return memo.get(root);
		int money = root.val;
		if (root.left != null) {
			money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
		}
		if (root.right != null) {
			money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
		}
		int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
		memo.put(root, res);
		return res;
	}
}
