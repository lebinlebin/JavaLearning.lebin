package Java.lebin.Training.InterviewCases.binarySearch;
/*
367. 有效的完全平方数
给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
不能使用任何内置的库函数，如  sqrt 。

示例 1：
输入：num = 16
输出：true
解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
示例 2：
输入：num = 14
输出：false
解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 */
public class _367_有效的完全平方数_二分凑平方 {
//二分查找
//    时间复杂度：O(logn)，其中 n 为正整数 num 的最大值。
//    空间复杂度：O(1)
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //暴力
    //时间复杂度：O(sqrt{n})，其中 n 为正整数 num 的最大值。我们最多需要遍历 sqrt{n} + 1 个正整数。
    //空间复杂度：O(1)
    public boolean isPerfectSquare2(int num) {
        long x = 1, square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            ++x;
            square = x * x;
        }
        return false;
    }
}
