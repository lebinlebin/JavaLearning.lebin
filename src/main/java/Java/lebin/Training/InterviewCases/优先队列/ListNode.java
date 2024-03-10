package Java.lebin.Training.InterviewCases.优先队列;

public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 @Override
	public String toString() {
		return val + " -> " + next;
	}
}
