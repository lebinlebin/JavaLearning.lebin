package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
一、题目描述
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
示例 1：
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：
输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 */
public class _59_队列的最大值 {
    /*
 时间复杂度  O(1)
 空间复杂度 O(n)

使用一个双端队列 dequedeque，在每次入队时，如果 dequedeque 队尾元素小于即将入队的元素 valuevalue，则将小于 valuevalue 的元素全部出队后，再将 valuevalue 入队；否则直接入队。
     */
}
class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            deque.removeFirst();
        }
        return queue.poll();
    }
}

