package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class _203_移除链表元素 {
	/**
	 * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
	 * 空间复杂度：O(1)。
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return null;
		// 新链表的头结点
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = dummyNode;

		while (cur.next != null){
			if(cur.next.val == val){
				cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}

		}
		return dummyNode.next;
	}
}
