package Java.lebin.Training.InterviewCases.LinkedList;

/**
 82. 删除排序链表中的重复元素 II
 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 返回同样按升序排列的结果链表。
 示例 1：
 输入：head = [1,2,3,3,4,4,5]
 输出：[1,2,5]
 */
/*
复杂度分析
时间复杂度：O(n)，其中 n 是链表的长度。
空间复杂度：O(1)。
 */
public class _82_删除排序链表中的重复元素II_重复元素全部删除 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0, head);
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;//这里是为了保存一个x，while循环中cur会变化，就不能拿到这个值
				while (cur.next != null && cur.next.val == x) {//当前重复值连续删除；后边还有其他重复数据。靠外循环while循环进行后续循环
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	//变种如果要把重复的元素保留一个呢？？
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0, head);
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				cur = cur.next;//保留一个
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
