package Java.lebin.Training.InterviewCases.queueStack单调栈;

import java.util.Stack;

/**
 题目：
 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class 是否可能为该栈的弹出顺序 {

	public boolean IsPopOrder(int [] pushA,int [] popA) {
		//如果他们之间有一个为空，则是不合法的，直接返回false
		if(pushA==null&&popA==null)
		{
			return false;
		}
		//创建一个辅助栈来模拟入栈出栈的过程
		Stack<Integer> stack=new Stack();
		//定义一个index来记录出栈popA的位置
		int index=0;
		//循环，一直到所有内容入栈完毕
		for(int i=0;i<pushA.length;i++)
		{
			stack.push(pushA[i]);
			//关键
			//如果目前的栈顶与出栈的队列相同则出栈，然index++
			//如果栈不为空的话，则继续出栈
			while((!stack.isEmpty())&&stack.peek()==popA[index])
			{
				stack.pop();
				index++;
			}
		}
		//如果最后栈为空的话，说明是正确的
		return stack.isEmpty();
	}
}
