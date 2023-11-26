package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * 面试题 02.07.  160.链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 两个对象是同一个对象那么就是相交的点
 * 内存地址是一样的
 */
public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode curA = headA, curB = headB;

		while (curA != curB) {
			curA = (curA == null) ? headB : curA.next;
			curB = (curB == null) ? headA : curB.next;
			// 这段代码在两个链表不相交的时候会死循环
			// curA = (curA.next == null) ? headB : curA.next;
			// curB = (curB.next == null) ? headA : curB.next;
		}
		return curA;
	}
/*
时间复杂度：O(n + m)
空间复杂度：O(1)
 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		ListNode curA = headA;
		ListNode curB = headB;
		int lenA = 0, lenB = 0;
		while (curA != null) { // 求链表A的长度
			lenA++;
			curA = curA.next;
		}
		while (curB != null) { // 求链表B的长度
			lenB++;
			curB = curB.next;
		}
		curA = headA;
		curB = headB;
		// 让curA为最长链表的头，lenA为其长度
		if (lenB > lenA) {
			//1. swap (lenA, lenB);
			int tmpLen = lenA;
			lenA = lenB;
			lenB = tmpLen;
			//2. swap (curA, curB);
			ListNode tmpNode = curA;
			curA = curB;
			curB = tmpNode;
		}

		// 求长度差
		int gap = lenA - lenB;
		// 让curA和curB在同一起点上（末尾位置对齐）
		while (gap-- > 0) {
			curA = curA.next;
		}

		// 遍历curA 和 curB，遇到相同则直接返回
		while (curA != null) {
			if (curA == curB) {
				return curA;
			}
			curA = curA.next;
			curB = curB.next;
		}
		return null;
	}
}
