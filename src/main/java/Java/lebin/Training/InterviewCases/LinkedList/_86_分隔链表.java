package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 虚拟头结点
 * 1）分别建立两个链表。
 * 2）head遍历原链表，小于x那么放在左边，左链表；大于x放在右边，右链表
 * 3）最后手动将右边的Rtail指向 null
 */
//时间复杂度: O(n)，其中 n 是原链表的长度。
//空间复杂度: O(1)。
public class _86_分隔链表 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) return null;
		ListNode lHead = new ListNode(0);
		ListNode lTail = lHead;
		ListNode rHead = new ListNode(0);
		ListNode rTail = rHead;

		while (head != null) {
			if (head.val < x) { // 放在lTail后面
				lTail.next = head;
				lTail = head;//左边tail更新为head
			} else { // 放在rTail后面
				rTail.next = head;
				rTail = head;//右边tail更新为head
			}
			head = head.next;
		}
		// 这句代码不能少
        /* 
         * 因为可能出现这样的情况:
         * 原链表倒数第N个节点A的值是>=x的，A后面所有节点的值都是<x的
         * 然后rTail.next最终其实就是A.next
         */
		rTail.next = null;
		// 将rHead.next拼接在lTail后面
		lTail.next = rHead.next;
		return lHead.next;
	}
}
