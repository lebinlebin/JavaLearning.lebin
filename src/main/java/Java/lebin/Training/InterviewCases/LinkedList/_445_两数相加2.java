package Java.lebin.Training.InterviewCases.LinkedList;

import java.util.Stack;

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class _445_两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 为了保证从低位开始计算，因此使用两个栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode nextNode = null;
        ListNode curNode;

        int carry = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                carry += stack1.pop();
            }
            if (!stack2.empty()) {
                carry += stack2.pop();
            }

            // 头插法
            curNode = new ListNode(carry % 10);
            curNode.next = nextNode;
            nextNode = curNode;
            carry /= 10;
        }
        if (carry == 1) {
            ListNode head = new ListNode(carry);
            head.next = nextNode;
            return head;
        }
        return nextNode;
    }
}
