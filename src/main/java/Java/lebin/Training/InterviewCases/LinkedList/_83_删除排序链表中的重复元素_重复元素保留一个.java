package Java.lebin.Training.InterviewCases.LinkedList;

/**
 83. 删除排序链表中的重复元素
 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 返回同样按升序排列的结果链表。
 复杂度分析
 时间复杂度：O(n)，其中 n 是链表的长度。
 空间复杂度：O(1)。

 */
public class _83_删除排序链表中的重复元素_重复元素保留一个 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
}
