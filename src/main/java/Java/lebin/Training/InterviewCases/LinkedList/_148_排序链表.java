package Java.lebin.Training.InterviewCases.LinkedList;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 时间复杂度 O(nlogn) 时间复杂度
 * 空间复杂度下，对链表进行排序吗？
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class _148_排序链表 {
//	时间复杂度：O(nlogn)，其中 n 是链表的长度。
//	空间复杂度：O(1)。
//  自底向上归并排序
	public static ListNode sortList(ListNode head) {
		if(head == null){
			return head;
		}
		// 1. 首先从头向后遍历,统计链表长度
		int length = 0; // 用于统计链表长度
		ListNode node = head;
		while(node != null){
			length++;
			node = node.next;
		}

		// 2. 初始化 引入  dummynode
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		// 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
		for(int subLen = 1; subLen < length; subLen <<= 1){ // subLen每次左移一位（即sublen = sublen*2） PS:位运算对CPU来说效率更高
			System.out.println("subLen："+subLen);
			ListNode prev = dummyHead;//记录所有排序好的
			ListNode curr = dummyHead.next;     // curr用于记录拆分链表的位置
			while(curr != null){               // 如果链表没有被拆完
				// 3.1 拆分subLen长度的链表1
				ListNode head_1 = curr;        // 第一个链表的头 即 curr初始的位置
				for(int i = 1; i < subLen && curr.next != null; i++){     // 拆分出长度为subLen的链表1
					curr = curr.next;
				}

				// 3.2 拆分subLen长度的链表2
				ListNode head_2 = curr.next;  // 第二个链表的头  即 链表1尾部的下一个位置
				curr.next = null;             // 断开第一个链表和第二个链表的链接
				curr = head_2;                // 第二个链表头 重新赋值给curr
				for(int i = 1;i < subLen && curr != null && curr.next != null;i++){      // 再拆分出长度为subLen的链表2
					curr = curr.next;
				}

				// 3.3 再次断开 第二个链表最后的next的链接
				ListNode next = null;
				if(curr != null){
					next = curr.next;   // next用于记录 拆分完两个链表的结束位置
					curr.next = null;   // 断开连接
				}

				// 3.4 合并两个subLen长度的有序链表
				ListNode merged = mergeTwoLists(head_1,head_2);
				prev.next = merged;        // prev.next 指向排好序链表的头
				while(prev.next != null){  // while循环 将prev移动到 subLen*2 的位置后去
					prev = prev.next;
				}
				curr = next;              // next用于记录 拆分完两个链表的结束位置
			}
		}
		// 返回新排好序的链表
		return dummyHead.next;
	}

	// 合并两个有序链表
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode curr  = dummy;

		while(l1 != null && l2!= null){ // 退出循环的条件是走完了其中一个链表
			// 判断l1 和 l2大小
			if (l1.val < l2.val){
				// l1 小 ， curr指向l1
				curr.next = l1;
				l1 = l1.next;       // l1 向后走一位
			}else{
				// l2 小 ， curr指向l2
				curr.next = l2;
				l2 = l2.next;       // l2向后走一位
			}
			curr = curr.next;       // curr后移一位
		}

		// 退出while循环之后,比较哪个链表剩下长度更长,直接拼接在排序链表末尾
		if(l1 == null) curr.next = l2;
		if(l2 == null) curr.next = l1;

		// 最后返回合并后有序的链表
		return dummy.next;
	}

//=============================================================================================================
/*
1. 对链表自顶向下归并排序
2. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。
3. 对两个子链表分别排序
4. 将两个排序后的子链表合并。
时间复杂度：O(nlogn)，其中 n 是链表的长度。
空间复杂度：O(logn)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
 */
	public ListNode sortListIter(ListNode head) {
		return mergeSortList(head, null);//
	}
	//
	public ListNode mergeSortList(ListNode head, ListNode tail) {
		if (head == null) {
			return head;
		}
		//只有一个元素，直接返回
		if (head.next == tail) {
			head.next = null;
			return head;
		}

		//找到链表中点
		ListNode slow = head, fast = head;
		while (fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if (fast != tail) {
				fast = fast.next;
			}
		}

		ListNode mid = slow;
		ListNode list1 = mergeSortList(head, mid);
		ListNode list2 = mergeSortList(mid, tail);
		ListNode sorted = merge(list1, list2);
		return sorted;
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead;
		ListNode temp1 = head1;
		ListNode temp2 = head2;

		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		} else if (temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}




	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		System.out.println(head);

		sortList(head);

		System.out.println(head);
	}
}
