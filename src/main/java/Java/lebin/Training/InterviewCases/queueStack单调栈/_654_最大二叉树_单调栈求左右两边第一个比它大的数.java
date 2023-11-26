package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Arrays;
import java.util.Stack;

import Java.lebin.Training.InterviewCases.BinarySearchTree.TreeNode;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class _654_最大二叉树_单调栈求左右两边第一个比它大的数 {
	/*
	时间复杂度O(n^2)。在最坏的情况下，数组严格递增或递减，需要递归 n 层，第 i (0≤i<n) 层需要遍历 n−i 个元素以找出最大值，总时间复杂度为 O(n^2).
	空间复杂度：O(n)，即为最坏情况下需要使用的栈空间。
	 */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if (nums == null) return null;
    	return findRoot(nums, 0, nums.length);
    }
    
    /**
     * 找出[l, r)范围的根节点
     */
    private TreeNode findRoot(int[] nums, int l, int r) {
    	if (l == r) return null;
    	// 找出[l, r)范围内最大值的索引
    	int maxIdx = l;
    	//找到最大索引
    	for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}
    	TreeNode root = new TreeNode(nums[maxIdx]);

    	root.left = findRoot(nums, l, maxIdx);
    	root.right = findRoot(nums, maxIdx + 1, r);
    	return root;
    }

    //单调栈
	/**
	 * 题目变种:返回一个数组，数组里面存着每个节点的父节点的索引(如果没有父节点，就存-1)
	 * 分析:怎么找到给定数组的当前值的左右第一个比它大的数，第一个比当前值大的数就是根节点
	 * 利用栈
	 */
    public int[] parentIndexes(int[] nums) {
    	if (nums == null || nums.length == 0) return null;
    	/*
    	 * 1.扫描一遍所有的元素
    	 * 2.保持栈从栈底到栈顶是单调递减的,栈底元素最大
    	 */
    	int[] lis = new int[nums.length];
    	int[] ris = new int[nums.length];

    	Stack<Integer> stack = new Stack<>();
    	// 初始化
		//ris 右边第一个比他大的数的索引
		//lis 左边第一个比他大的数的索引
    	for (int i = 0; i < nums.length; i++) {
			ris[i] = -1;
			lis[i] = -1;
		}
		//基准元素 nums[stack.peek()] 栈顶元素
		//right元素  nums[i]
    	for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				ris[stack.pop()] = i;//右边第一个比基准元素大的元素下标
			}
			if (!stack.isEmpty()) {//左边第一个比基准元素大的元素下标
				lis[i] = stack.peek();
			}
			stack.push(i);
		}

    	int[] pis = new int[nums.length];
    	for (int i = 0; i < pis.length; i++) {
    		if (lis[i] == -1 && ris[i] == -1) {
    			// i位置的是根节点
    			pis[i] = -1;
    			continue;
    		}
    		if (lis[i] == -1) {
				pis[i] = ris[i];
    		} else if (ris[i] == -1) {
				pis[i] = lis[i];
    		} else if (nums[lis[i]] < nums[ris[i]]) {
				pis[i] = lis[i];
			} else {
				pis[i] = ris[i];
			}
		}
    	return pis;
    }

    
    public static void main(String[] args) {
    	_654_最大二叉树_单调栈求左右两边第一个比它大的数 o = new _654_最大二叉树_单调栈求左右两边第一个比它大的数();
    	int[] nums = { 3, 2, 1, 6, 0, 5 };
    	System.out.println(Arrays.toString(o.parentIndexes(nums)));
	}
}
