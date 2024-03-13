package Java.lebin.Training.InterviewCases.MathOperator;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
示例 1：
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
示例 2：
输入：c = 3
输出：false
 */
/*
时间复杂度：O(sqrt(c))。枚举 a 的时间复杂度为O(sqrt(c))，对于每个 a 的值，可在 O(1) 的时间内寻找 b。
 空间复杂度：O(1)。
 */
public class _633_平方数之和_整数是否可以拆分为平方数之和 {
    //方法一：使用 sqrt函数
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
    //方法二：双指针
    //时间复杂度：O(sqrt{c})。最坏情况下 a 和 b 一共枚举了 0 到 sqrt(c)里的所有整数。
    //空间复杂度：O(1)
    public boolean judgeSquareSum2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
