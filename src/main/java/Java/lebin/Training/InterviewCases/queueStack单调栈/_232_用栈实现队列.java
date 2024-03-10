package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Stack;

/*
画图帮助思考，关键还是思考清楚细节。
使用两个栈，一个栈（stackPush）用于元素进栈，一个栈（stackPop）用于元素出栈；
pop() 或者 peek() 的时候：
如果 stackPop 里面有元素，直接从 stackPop 里弹出或者 peek 元素；
如果 stackPop 里面没有元素，一次性将 stackPush 里面的所有元素倒入 stackPop。
为此，可以写一个 shift 辅助方法，一次性将 stackPush 里的元素倒入 stackPop。
注意：一定要保证 stackPop 为空的时候，才能把元素从 stackPush 里拿到 stackPop 中。
 */
public class _232_用栈实现队列 {
}

/**
 * 用两个栈实现队列
 */
class MyQueue2 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackPush.push(x);
    }

    private void shift() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        shift();
        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Get the front element.
     */
    public int peek() {
        shift();
        if (!stackPop.isEmpty()) {
            return stackPop.peek();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
