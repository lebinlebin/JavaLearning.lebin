package Java.lebin.Training.InterviewCases.LinkedList;

/**
 237. 删除链表中的节点
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 示例 1：
 输入：head = [4,5,1,9], node = 5
 输出：[4,1,9]
 */
//方法一：和下一个节点交换 传入的参数 node 为要被删除的节点，无法定位到该节点的上一个节点。
// 注意到要被删除的节点不是链表的末尾节点，因此 node.next不为空，可以通过对 node 和 node.next 进行操作实现删除节点。
//时间和空间复杂度都是：O(1)。
public class _237_删除链表中的节点O1 {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
