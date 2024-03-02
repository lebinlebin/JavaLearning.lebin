package Java.lebin.Training.InterviewCases.MathOperator;

import Java.lebin.Training.DSA._03_Stack.Stack;

import java.util.Deque;
import java.util.LinkedList;

/*
如何实现一个基本计算器
给你一个字符串表达式s，s由数字、"+"，"-"、"（"、"）"和" "组成，请你实现一个基本计算器来计算并返回他的值。
示例 1：
输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 */
/*
由于字符串除了数字与括号外，只有加号和减号两种运算符。因此，如果展开表达式中所有的括号，则得到的新表达式中，
数字本身不会发生变化，只是每个数字前面的符号会发生变化。
时间复杂度：O(n)，其中 n 为字符串 s 的长度。需要遍历字符串 s 一次，计算表达式的值。
空间复杂度：O(n)，其中 n 为字符串 s 的长度。空间复杂度主要取决于栈的空间，栈中的元素数量不超过 n。
 */
public class _224_基本计算器 {
    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();  // 存放每一层的符号，一个括号表示一层
        int sign = 1;   // 值为1或-1，表示当前数的符号
        st.push(sign);  // 最顶层的符号为+1
        int res = 0;    // 结果
        int number;
        int n = s.length();
        int i = 0;
        char ch;
        while(i < n){
            if(Character.isDigit(ch = s.charAt(i))){
                // 如果为数字，生成数值
                number = 0;
                while(i < n && Character.isDigit(ch = s.charAt(i))){
                    number = number * 10 + (ch - '0');
                    i++;
                }
                // 累加和，真实数字等于符号乘以数值
                res += sign * number;
            }else{
                if(ch == '+'){
//                    sign = st.peek();   // 加号，获取当前层的符号
                    sign = st.top();
                }else if(ch == '-'){
//                    sign = -st.peek();  // 减号，获取当前层的相反符号
                    sign = -st.top();
                }else if(ch == '('){
                    st.push(sign);      // 左括号，进入新一层，将当前层符号入栈
                }else if(ch == ')'){
                    st.pop();   // 右括号，完成一层的运算，弹出这一层符号
                }
                i++;    // 索引右移
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        String ss = " 2-1 + 2 ";
        System.out.println(calculate(ss));
    }
}
