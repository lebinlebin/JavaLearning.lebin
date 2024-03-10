package Java.lebin.Training.InterviewCases.LinkedList;

/**
 *234. 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */
//时间复杂度：O(n)，其中 n 指的是链表的大小。
//空间复杂度：O(1)。
public class _234_回文链表_中间节点_链表反转 {
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) return true;
    	if (head.next.next == null) return head.val == head.next.val;

    	// 找到中间节点
    	ListNode mid = middleNode(head);

    	// 翻转右半部分（中间节点的右边部分）
    	ListNode rHead = reverseList(mid.next);
    	ListNode lHead = head;
    	ListNode rOldHead = rHead;//记录下来

    	// 从lHead、rHead出发，判断是否为回文链表
    	boolean result = true;
    	while (rHead != null) {
    		if (lHead.val != rHead.val) {
    			result = false;
    			break;
    		}
    		rHead = rHead.next;
    		lHead = lHead.next;
    	}

    	// 恢复右半部分（对右半部分再次翻转）
    	reverseList(rOldHead);
    	return result;
    }

    /**
	 * 快慢指针找到中间节点
     * 找到中间节点（右半部分链表头结点的前一个节点）
     */
	private ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * 翻转链表
	 * 比如原链表：1>2>3>4>null，翻转之后是：4>3>2>1>null
	 * @return 翻转之后链表的头结点
	 */
	private ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}


	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);
		System.out.println(head);
		
		_234_回文链表_中间节点_链表反转 obj = new _234_回文链表_中间节点_链表反转();
		obj.isPalindrome(head);
		
		System.out.println(head);
	}
}
