package Java.lebin.Training.InterviewCases.LinkedList;
/*
给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 */
public class _147_对链表进行插入排序 {
    //时间复杂度：O(N^2) ，这里N 表示链表结点的个数，对于每个结点找合适位置时，最多需要遍历O(N) 次；
    //空间复杂度：O(1)
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);

        ListNode curNode = head;
        while (curNode != null) {
            // 第 1 步：先把下一个结点存一下，下一次遍历就从 nextNode 开始
            ListNode nextNode = curNode.next;

            // 第 2 步：需要找到要插入的位置的前一个结点的位置，这需要从前向后找，这一点非常不一样
            // 每一次 preNode 都得从头开始
            ListNode preNode = dummyNode;

            // 因为有 preNode.next ，所以应该先判断非空
            while (preNode.next != null && preNode.next.val < curNode.val) {
                // 严格小于就可以了，没有必要移到小于等于的最后一个，不用保证稳定性
                preNode = preNode.next;
            }
            // 退出循环的时候，preNode.next.val >= curNode.val
            // 第 3 步：穿针引线
            curNode.next = preNode.next;
            preNode.next = curNode;

            // 第 4 步：循环变量更新
            curNode = nextNode;
        }
        return dummyNode.next;
    }
}
