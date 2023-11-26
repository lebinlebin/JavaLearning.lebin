package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.LinkedList;
import java.util.Stack;

/*
剑指 Offer 09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2] */
/*
思路
栈1用于存储新元素，栈2用于弹出旧元素
appendTail：直接将新元素压入栈1中
deleteHead：直接弹出栈2中的元素；如果栈2为空，将栈1的元素压入栈2中；如果栈1也为空，返回 -1
*/
class MyQueue {
	private Stack<Integer> a;// 输入栈
	private Stack<Integer> b;// 输出栈

	public MyQueue() {
		a = new Stack<>();
		b = new Stack<>();
	}

	public void push(int x) {
		a.push(x);
	}

	public int pop() {
		// 如果b栈为空，则将a栈全部弹出并压入b栈中，然后b.pop()
		if(b.isEmpty()){
			while(!a.isEmpty()){
				b.push(a.pop());
			}
		}
		return b.pop();
	}

	public int peek() {
		if(b.isEmpty()){
			while(!a.isEmpty()){
				b.push(a.pop());
			}
		}
		return b.peek();
	}

	public boolean empty() {
		return a.isEmpty() && b.isEmpty();
	}
}