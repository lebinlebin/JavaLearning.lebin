package Java.lebin.Training.InterviewCases.characterString;

import Java.lebin.Training.InterviewCases.printer.printer.BinaryTreeInfo;
import Java.lebin.Training.InterviewCases.printer.printer.BinaryTrees;
import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */
//时间复杂度：对于每一个 s 上的点，都需要做一次深度优先搜索来和 t 匹配，匹配一次的时间代价是 O(∣t∣)，那么总的时间代价就是 O(∣s∣×∣t∣)。故渐进时间复杂度为 O(∣s∣×∣t∣)。
//空间复杂度：假设 s 深度为 ds，t的深度为 dt，任意时刻栈空间的最大使用代价是 O(max{ds,dt})。故渐进空间复杂度为 O(max{ds,dt})
public class _572_另一个树的子树 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (t == null) return true;   // t 为 null 一定都是 true
		if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
		return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
	}

	/**
	 * 判断两棵树是否相同
	 */
	public boolean isSameTree(TreeNode s, TreeNode t){
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
