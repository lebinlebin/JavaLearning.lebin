package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 */
public class _19_删除链表的倒数第N个结点 {
	/**
	 * 虚拟头结点技巧
	 * 时间复杂度：O(L)，其中 LLL 是链表的长度。
	 * 空间复杂度：O(1)。
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode first = head;
		ListNode second = dummy;
		//双指针，快指针移动n步，直到移动到链表尾部，此时second指向的就是第n个
		for (int i = 0; i < n; ++i) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		ListNode ans = dummy.next;
		return ans;
	}
}
