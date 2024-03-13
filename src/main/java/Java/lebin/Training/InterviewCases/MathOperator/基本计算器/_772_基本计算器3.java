package Java.lebin.Training.InterviewCases.MathOperator.基本计算器;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
实现一个基本的计算器来计算简单的表达式字符串。
表达式字符串只包含非负整数，算符 +、-、*、/ ，左括号 ( 和右括号 ) 。整数除法需要 向下截断 。
你可以假定给定的表达式总是有效的。所有的中间结果的范围均满足 [-231, 231 - 1] 。
注意：你不能使用任何将字符串作为表达式求值的内置函数，比如 eval() 。

示例 1：
输入：s = "1+1"
输出：2
示例 2：
输入：s = "6-4/2"
输出：4
示例 3：
输入：s = "2*(5+5*2)/3+(6/2+8)"
输出：21

 */
//时间复杂度：O(n),n为字符串的长度。
//空间复杂度：O(n),使用的栈空间是压入的数字
public class _772_基本计算器3 {
    //递归的开始条件和结束条件是什么？遇到 ( 开始递归，遇到 ) 结束递归：
    public int calculate(String s) {
        return dfs(s, 0)[0];
    }
    private int[] dfs(String s, int index) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int[] root = dfs(s, ++i);
                num = root[0];
                i = root[1];
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(num * st.pop());
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                return new int[]{sum(st), i};
            }
        }
        return new int[]{sum(st), s.length() - 1};
    }

    private int sum(Stack<Integer> st) {
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}
