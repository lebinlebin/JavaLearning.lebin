package Java.lebin.Training.InterviewCases.LinkedList;

import java.util.Stack;

/**
 剑指 Offer 06. 从尾到头打印链表
 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 示例 1：
 输入：head = [1,3,2]
 输出：[2,3,1]
 */
//时间复杂度 O(N)
//空间复杂度 O(N)
public class _06_从尾到头打印链表_反向输出链表 {
	public int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int size = stack.size();
		int[] print = new int[size];
		for (int i = 0; i < size; i++) {
			print[i] = stack.pop().val;
		}
		return print;
	}
}
