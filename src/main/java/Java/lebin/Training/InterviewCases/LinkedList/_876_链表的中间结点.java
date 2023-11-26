package Java.lebin.Training.InterviewCases.LinkedList;

/**
 876. 链表的中间结点
 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 如果有两个中间结点，则返回第二个中间结点。
 */
//时间复杂度：O(N)，其中 N 是给定链表的结点数目。
//空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。
public class _876_链表的中间结点 {
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
