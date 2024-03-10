package Java.lebin.Training.InterviewCases.LinkedList;
/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 */
public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNodeOdd = new ListNode(-1);
        ListNode dummyNodeEven = new ListNode(-1);
        ListNode curOdd = dummyNodeOdd;
        ListNode curEven = dummyNodeEven;
        int count = 0;
        while (head != null) {
            if ((count % 2) == 0) {
                curOdd.next = head;
                curOdd = curOdd.next;
            } else {
                curEven.next = head;
                curEven = curEven.next;
            }
            head = head.next;
            count++;
        }
        curOdd.next = dummyNodeEven.next;
        // 特别注意：最后这一步不能忘记，否则会产生一个循环链表
        curEven.next = null;
        return dummyNodeOdd.next;
    }
}
