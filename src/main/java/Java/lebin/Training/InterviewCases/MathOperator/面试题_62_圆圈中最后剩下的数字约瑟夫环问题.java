package Java.lebin.Training.InterviewCases.MathOperator;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 这其实就是著名的约瑟夫环问题
 * 有n个人，编号分别为0，1，2，3，...,n-1，每当报数到第m个人时，就杀掉他，求最后胜利者编号.，，求的是编号！求的是编号！
 */
public class 面试题_62_圆圈中最后剩下的数字约瑟夫环问题 {
    // f(n, m) = (f(n – 1, m) + m) % n
    public int lastRemaining1(int n, int m) {
        //只有一个人的话，他的编号就是0.
        return (n == 1) ? 0 : (lastRemaining1(n - 1, m) + m) % n;
    }

    //要求 f(10, 3)
    // f(1, 3) = 0
    // f(2, 3) = (f(1, 3) + 3) % 2
    // ...
    // f(7, 3) = (f(6, 3) + 3) % 7
    // f(8, 3) = (f(7, 3) + 3) % 8
    // f(9, 3) = (f(8, 3) + 3) % 9
    // f(10, 3) = (f(9, 3) + 3) % 10
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) { // i是数据规模，代表有多少个数字（有多少个人）
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        面试题_62_圆圈中最后剩下的数字约瑟夫环问题 o = new 面试题_62_圆圈中最后剩下的数字约瑟夫环问题();
        System.out.println(o.lastRemaining(10, 17));
    }
}
