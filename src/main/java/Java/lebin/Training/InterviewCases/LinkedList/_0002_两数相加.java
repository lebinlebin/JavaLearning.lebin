package Java.lebin.Training.InterviewCases.LinkedList;

/**
 *
 *新建一个新的链表
 * 1. 虚拟头结点
 * 2. while循环遍历两个链表。
 *    中间判断每个链表是否为空
 * 3. 进位变量考虑
 * 4. 循环结束时候要特别注意进位值
 *
 * ps：循环一定要先取值再进行循环
 * 比如下边的写法是错误的
 * 			if (l1 != null) {
 * 		         l1 = l1.next;
 * 				v1 = l1.val;
 *                        }
 */
//时间复杂度：O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
//空间复杂度：O(1)。注意返回值不计入空间复杂度。
public class _0002_两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int carry = 0;
		while(l1 != null || l2 != null) {
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;
			int sum = x + y + carry;

			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);

			cur = cur.next;
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
		if(carry == 1) {
			cur.next = new ListNode(carry);
		}
		return pre.next;
	}
}
