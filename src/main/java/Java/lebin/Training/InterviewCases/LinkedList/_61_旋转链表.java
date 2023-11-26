package Java.lebin.Training.InterviewCases.LinkedList;

/**
 61. 旋转链表
 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 示例 ：
 输入：head = [1,2,3,4,5], k = 2
 输出：[4,5,1,2,3]
 */
public class _61_旋转链表 {
	/*
	思路总结: 1 找到尾结点；2.尾结点next指向head，形成环形； 3.将环形链表从n-k-1的位置断开。这里找到断开位置的前一个节点
	 */
//	时间复杂度：O(n)，最坏情况下，我们需要遍历该链表两次。
//	空间复杂度：O(1)，我们只需要常数的空间存储若干变量。
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		if(k == 0) return head;
		ListNode tail = head;
		ListNode newtail = head;
		ListNode newhead;
		int n = 1;
		// 原来的尾结点指向原来的头结点，形成环
		while(tail.next != null){
			tail = tail.next;
			n++;
		}
		tail.next = head;

		// 找到断开环的位置
		for(int i = 0; i < (n - k % n - 1); i++){
			newtail = newtail.next;
		}
		// 新的头结点指向断开环的位置
		newhead = newtail.next;
		newtail.next = null;

		return newhead;
	}
}
