package Java.lebin.Training.InterviewCases.LinkedList;

/**
 剑指 Offer 35. 复杂链表的复制
 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 解题思路
 遍历链表，在各原节点后边复制一个新的节点形成新的链表。
 遍历链表，将原节点的random域复制给新节点。
 将新链表拆分为旧链表和新的克隆链表。
 复杂度分析
 时间复杂度：O(n)。其中n为链表的长度。
 空间复杂度：O(1)。原地复制链表，不需要额外的辅助空间。
 */
public class 剑指Offer35_复杂链表的复制 {
	public Node copyRandomList(Node head) {
		if(head == null) return head;
		Node node = head;
		//在原有节点后复制一个值相同的节点
		while(node != null){
			Node clonedNode = new Node(node.val);
			clonedNode.next = node.next;
			node.next = clonedNode;
			node = clonedNode.next;
		}
		//完成随机指针的复制
		node = head;
		Node clonedNode = head.next;
		while(node != null){
			if(node.random != null) node.next.random = node.random.next;
			node = node.next.next;
		}
		//将链表拆分
		node = head;
		Node clonedHead = head.next;
		clonedNode = clonedHead;
		while(node != null){
			node.next = clonedNode.next;
			node = node.next;
			if(clonedNode.next != null){
				clonedNode.next = clonedNode.next.next;
				clonedNode = clonedNode.next;
			}
		}
		return clonedHead;

	}


	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
