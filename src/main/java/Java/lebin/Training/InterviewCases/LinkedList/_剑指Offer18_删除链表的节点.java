package Java.lebin.Training.InterviewCases.LinkedList;

/**
 剑指 Offer 18. 删除链表的节点
 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 */
/*
时间复杂度 O(N) ： N 为链表长度，删除操作平均需循环 N/2 次，最差 N 次。
空间复杂度 O(1) ： cur, pre 占用常数大小额外空间。
 */
public class _剑指Offer18_删除链表的节点 {
	public ListNode deleteNode(ListNode head, int val) {
		if(head.val == val) return head.next;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null && cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		if(cur != null)  pre.next = cur.next;
		return head;
	}
}
