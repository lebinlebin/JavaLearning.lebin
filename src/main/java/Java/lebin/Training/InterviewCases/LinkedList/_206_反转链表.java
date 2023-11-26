package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * 206 题意：反转一个单链表。
 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public	class _206_反转链表 {
	/*
	迭代法:
	时间复杂度: O(n)
	空间复杂度: O(1)
	 */
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		ListNode temp = null;
		while (cur != null) {
			temp = cur.next;// 保存下一个节点，因为接下来要改变 cur->next的指向了
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

	//递归法
	/*
	时间复杂度: O(n), 要递归处理链表的每个节点
	空间复杂度: O(n), 递归调用了 n 层栈空间
	 */
	public ListNode reverseList2(ListNode head) {
		return reverse(null, head);
	}
	private ListNode reverse(ListNode prev, ListNode cur) {
		if (cur == null) {
			return prev;
		}
		ListNode temp = null;
		temp = cur.next;// 先保存下一个节点
		cur.next = prev;// 反转
		// 更新prev、cur位置
		// prev = cur;
		// cur = temp;
		return reverse(cur, temp);
	}
}