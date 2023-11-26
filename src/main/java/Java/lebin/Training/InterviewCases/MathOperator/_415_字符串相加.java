package Java.lebin.Training.InterviewCases.MathOperator;

/*
415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
提示：
num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
//时间复杂度：O(max(len1,len2))
//空间复杂度：O(1)
public class _415_字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int carry = 0;
        //从后向前
        while(num1Len >= 0 || num2Len >= 0){
            int n1 = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int n2 = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            num1Len--; num2Len--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
