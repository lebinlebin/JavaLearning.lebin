package Java.lebin.Training.InterviewCases.MathOperator;

/**
 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31− 1] ，就返回 0。
 假设环境不允许存储 64 位整数（有符号或无符号）。
 示例 1：
 输入：x = 123
 输出：321
 */
//时间复杂度：O(log∣x∣)。翻转的次数即 x 十进制的位数。
//空间复杂度：O(1)。
public class _7_整数反转 {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			if (res > Integer.MAX_VALUE) return 0;
			if (res < Integer.MIN_VALUE) return 0;
			x /= 10;
		}
		return (int) res;
	}
}
