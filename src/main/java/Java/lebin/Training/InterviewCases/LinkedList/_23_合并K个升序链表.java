package Java.lebin.Training.InterviewCases.LinkedList;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class _23_合并K个升序链表 {
	/**
	 思路
	 维护当前每个链表没有被合并的元素的最前面一个，
	 k 个链表就最多有 k 个满足这样条件的元素，
	 每次在这些元素里面选取 val 属性最小的元素合并到答案中。
	 选取最小元素时，用优先队列
	 复杂度分析
	 时间复杂度：考虑优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk)，这里最多有 kn 个点，
	 对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 O(kn×logk)。
	 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k个，故渐进空间复杂度为 O(k)。
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if(null == lists || lists.length == 0){
			return null;
		}
		ListNode dump = new ListNode(-1);
		ListNode p = dump;
		//构建小根堆，
		PriorityQueue<ListNode> queue =  new PriorityQueue<>((o1,o2)->(o1.val - o2.val));
		//先把头节点加入到小根堆中
		for(ListNode head : lists){
			if(head != null){
				queue.add(head);
			}
		}
		while(!queue.isEmpty()){
			ListNode cur = queue.poll();
			//弹出的第一个 就是最小的头节点。
			p.next = cur;
			if(cur.next != null){
				queue.add(cur.next);
			}
			//指针不断移动。
			p = p.next;
		}
		return dump.next;
	}


/*
时间复杂度：
假设每个链表的最长长度是 n。在第一次合并后，ans 的长度为 n；
第二次合并后，ans 的长度为 2×n，第 i 次合并后，ans 的长度为 i×n。
第 i 次合并的时间代价是 O(i×n)，那么总的时间代价为 O(∑i=1,k (i×n))=O( ((1+k)⋅k)×n/2)=O(k^2*n)，
故渐进时间复杂度为O(k^2*n)。
空间复杂度：没有用到与 k 和 n 规模相关的辅助空间，空间复杂度为 O(1)。
 */
	public static ListNode mergeKLists_by_merge_two(ListNode[] lists) {
		ListNode ans = null;
		for (int i = 0; i < lists.length; ++i) {
			ans = mergeTwoLists(ans, lists[i]);
		}
		return ans;
	}

	public static ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head = new ListNode(0);
		ListNode tail = head;
		ListNode aPtr = a;
		ListNode bPtr = b;
		while (aPtr != null && bPtr != null) {
			if (aPtr.val < bPtr.val) {
				tail.next = aPtr;
				aPtr = aPtr.next;
			} else {
				tail.next = bPtr;
				bPtr = bPtr.next;
			}
			tail = tail.next;
		}
		tail.next = (aPtr != null ? aPtr : bPtr);
		return head.next;
	}

	//=============================================================================
	//尾插法
	public  static  ListNode createList(int[] element){
		if(element==null){
			return null;
		}
		ListNode head = new ListNode(0);
		ListNode p=head;
		for(int i=0;i<element.length;i++){
			ListNode temp=new ListNode(element[i]);
			p.next=temp;
			p=p.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] a ={1,4,5};
		int[] b ={1,4,5};
		int[] c ={1,4,5};
		int[] d ={1,4,5};
		ListNode lists1 = createList(a);
		ListNode lists2 = createList(b);
		ListNode lists3 = createList(c);
		ListNode lists4 = createList(d);
		ListNode[] lists = {lists1,lists2,lists3,lists4};
		ListNode head = mergeKLists(lists);
		System.out.println(head.toString());
	}
}
