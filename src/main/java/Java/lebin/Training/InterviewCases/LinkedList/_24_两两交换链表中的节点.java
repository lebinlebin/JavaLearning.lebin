package Java.lebin.Training.InterviewCases.LinkedList;

/**
 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 输入：head = [1,2,3,4]
 输出：[2,1,4,3]

 */
public class _24_两两交换链表中的节点 {
//时间复杂度：O(n)
//空间复杂度：O(1)
//迭代法
	public ListNode swapPairs_(ListNode head) {
		ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
		dumyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
		ListNode cur = dumyhead;
		ListNode temp; // 临时节点，保存两个节点后面的节点
		ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
		ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
		while (cur.next != null && cur.next.next != null) {
			temp = cur.next.next.next;
			firstnode = cur.next;
			secondnode = cur.next.next;
			cur.next = secondnode;       // 步骤一
			secondnode.next = firstnode; // 步骤二
			firstnode.next = temp;      // 步骤三
			cur = firstnode; // cur移动，准备下一轮交换
		}
		return dumyhead.next;
	}

//	时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
//	空间复杂度：O(n)，其中 n 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。
//递归法
	public ListNode swapPairs(ListNode head) {
		// base case 退出提交
		if(head == null || head.next == null) return head;
		// 获取当前节点的下一个节点
		ListNode next = head.next;
		// 进行递归
		ListNode newNode = swapPairs(next.next);
		// 这里进行交换
		next.next = head;
		head.next = newNode;
		return next;
	}
}
