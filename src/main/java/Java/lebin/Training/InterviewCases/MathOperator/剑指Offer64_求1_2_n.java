package Java.lebin.Training.InterviewCases.MathOperator;

/**
 题目描述：
 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。base^exponent
 */
public class 剑指Offer64_求1_2_n {
    //递归
    public int sumNums(int n) {
        if(n == 1) return 1;
        n += sumNums(n - 1);
        return n;
    }


    //公式
    public int sumNums2(int n) {
        return (1 + n) * n / 2;
    }

    //迭代
    public int sumNums3(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++)
            res += i;
        return res;
    }
}
