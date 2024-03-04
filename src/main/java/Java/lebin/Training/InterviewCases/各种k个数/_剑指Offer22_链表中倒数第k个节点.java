package Java.lebin.Training.InterviewCases.各种k个数;

import Java.lebin.Training.InterviewCases.LinkedList.ListNode;

/**
 剑指 Offer 22. 链表中倒数第k个节点
 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 示例：
 给定一个链表: 1->2->3->4->5, 和 k = 2.
 返回链表 4->5.
 */
//时间复杂度 O(N)
//空间复杂度 O(1)
public class _剑指Offer22_链表中倒数第k个节点 {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode former = head;
		ListNode latter = head;
		//快慢指针  快指针先走k步，之后慢指针latter从头走，直到快指针到达链表尾部，此时慢指针到达倒数第k个位置
		for(int i = 0; i < k; i++)
			former = former.next;

		while(former != null) {
			former = former.next;
			latter = latter.next;
		}
		return latter;
	}
}
