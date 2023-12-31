package Java.lebin.Training.InterviewCases.LinkedList;

/**
 141. 环形链表
 给定一个链表，判断链表中是否有环。
 */
public class _141_环形链表1 {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
