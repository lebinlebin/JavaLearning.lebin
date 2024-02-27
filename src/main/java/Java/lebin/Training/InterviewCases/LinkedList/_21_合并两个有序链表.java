package Java.lebin.Training.InterviewCases.LinkedList;

/**
 *21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class _21_合并两个有序链表 {
	/*
	复杂度分析：
	时间复杂度 O(M+N)： M,N分别为链表 l1,l2 的长度，合并操作需遍历两链表。
	空间复杂度 O(1)： 节点引用 newhead , tail 使用常数大小的额外空间。
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newhead = new ListNode(-1);//固定不动指向头结点
		ListNode tail = newhead;//需要一直指向完成排序之后的最后一个节点
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tail.next = l1;
//				tail = tail.next;
				l1 = l1.next;
			} else {
				tail.next = l2;
//				tail = tail.next;
				l2 = l2.next;
			}
			tail = tail.next;
		}

		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		tail.next = l1 == null ? l2 : l1;
		return newhead.next;
	}



//递归解法，不推荐
//	时间复杂度：O(n+m)
//空间复杂度：O(n+m)，其中 n和 m 分别为两个链表的长度
//递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。
// 结束递归调用时 mergeTwoLists 函数最多调用 n+m 次。
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
}
