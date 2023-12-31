package Java.lebin.Training.InterviewCases.Greedy;
/*
738.单调递增的数字

给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:
输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class _738_单调递增的数字 {
//    时间复杂度：O(n)，n 为数字长度
//    空间复杂度：O(n)，需要一个字符串，转化为字符串操作更方便
public int monotoneIncreasingDigits(int N) {
    String[] strings = (N + "").split("");
    int start = strings.length;
    for (int i = strings.length - 1; i > 0; i--) {
        if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
            strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
            start = i;
        }
    }
    for (int i = start; i < strings.length; i++) {
        strings[i] = "9";
    }
    return Integer.parseInt(String.join("",strings));
}
}
