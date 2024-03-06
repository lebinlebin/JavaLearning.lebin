//import Java.lebin.Training.InterviewCases.LinkedList.ListNode;
//
//import java.util.HashMap;
///*
//合并两个有序链表
// */
//public class _3_面试题 {
//    /*
//	复杂度分析：
//	时间复杂度 O(M+N)： M,N分别为链表 l1,l2 的长度，合并操作需遍历两链表。
//	空间复杂度 O(1)： 节点引用 newhead , tail 使用常数大小的额外空间。
//	 */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode newhead = new ListNode(-1);//固定不动指向头结点
//        ListNode tail = newhead;//需要一直指向完成排序之后的最后一个节点
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                tail.next = l1;
////				tail = tail.next;
//                l1 = l1.next;
//            } else {
//                tail.next = l2;
////				tail = tail.next;
//                l2 = l2.next;
//            }
//            tail = tail.next;
//        }
//
//        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
//        tail.next = l1 == null ? l2 : l1;
//        return newhead.next;
//    }
//}
