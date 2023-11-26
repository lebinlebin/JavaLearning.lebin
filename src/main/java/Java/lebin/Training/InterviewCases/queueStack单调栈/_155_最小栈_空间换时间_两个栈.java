package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Stack;
/*
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
/*
时间复杂度：对于题目中的所有操作，时间复杂度均为 O(1)。因为栈的插入、删除与读取操作都是 O(1)，我们定义的每个操作最多调用栈操作两次。
空间复杂度：O(n)，其中 n 为总操作数。最坏情况下，我们会连续插入 n 个元素，此时两个栈占用的空间为 O(n)。
 */

public class _155_最小栈_空间换时间_两个栈 {
	/** initialize your data structure here. */
	private Stack<Integer> S;
	private Stack<Integer> Smin;

	public _155_最小栈_空间换时间_两个栈() {
		// 正常栈
		S = new Stack<Integer>();
		// 存放最小值的栈
		Smin = new Stack<Integer>();
	}

	public void push(int val) {
		S.push(val);
		if(Smin.isEmpty()){
			Smin.push(val);
		}else {
			Smin.push(Math.min(val,Smin.peek()));
		}
	}

	public void pop() {
		S.pop();
		Smin.pop();
	}

	public int top() {
		return  S.peek();
	}

	public int getMin() {
		return Smin.peek();
	}
}
