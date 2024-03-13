package Java.lebin.Training.InterviewCases.MathOperator;
/*
给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
示例 1:
输入: num = 100
输出: "202"
示例 2:
输入: num = -7
输出: "-10"
 */
public class _504_七进制数_整数转为7进制数以字符输出 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuffer digits = new StringBuffer();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
