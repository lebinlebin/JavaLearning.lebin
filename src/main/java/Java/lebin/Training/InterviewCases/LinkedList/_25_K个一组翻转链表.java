package Java.lebin.Training.InterviewCases.LinkedList;

/**
 25. K 个一组翻转链表
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 示例 1：
 输入：head = [1,2,3,4,5], k = 2
 输出：[2,1,4,3,5]
 */
//时间复杂度：O(n)，其中 n  为链表的长度。
//空间复杂度：O(1)，我们只需要建立常数个变量。
public class _25_K个一组翻转链表 {
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1, head);
		ListNode prev = dummy;

		while (true) {
			// 检查剩余节点是否有k个，不足则返回
			ListNode last = prev;
			for (int i = 0; i < k; i++) {
				last = last.next;
				if (last == null) {
					return dummy.next;
				}
			}

			// 翻转k个节点
			ListNode curr = prev.next;//head
			ListNode next;
			for (int i = 0; i < k - 1; i++) {
				//curr 和 next 进行交换，那么 curr->next = next->next;
				//    curr -> next 原来是指向next的 现在 curr -> next 要指向 next->next；
				//  next->next 指向 curr
				// prev.next = next;前边的节点指向next
				next = curr.next;//记录，避免找不到了
				curr.next = next.next;//head->next->next 的下第二个节点

				next.next = prev.next;//curr
				prev.next = next;
			}

			prev = curr;
		}
	}
}
