package Java.lebin.Training.InterviewCases.DP.跳台阶_斐波那契;

/**
 题目描述
 我们可以用2x1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2x1的小矩形无重叠地覆盖一个2xn的大矩形，总共有多少种方法？
 比如n=3时，2x3的矩形块有3种覆盖方法：
 假设我们可以用如下图所示2x1的小矩形横着或者竖着去覆盖更大的矩形，请问用8个2x1的小矩形去无重复的覆盖一个2x8的大矩形。总共有多少种方法。

 把覆盖2x8矩形的覆盖方法总数记为f(8).用第一个矩形去覆盖大矩形时，有两种选择，横放或者竖放。竖放时，右边有2x7的区域尚未被覆盖，那么剩下区域覆盖方法的总数为f(7)。
 第一个矩形横向的情况下，必须占用另外一个小矩形去覆盖左下角。此时就能确定最左边2x2的格子了，因此右边还剩下2x6的区域尚未被覆盖，记为f(6)。
 因此可以得出关系， f(8) = f(7) + f(6)。显然我们也知道f(1)=1, f(2) = 2.
 */
public class _10_矩形覆盖_斐波那契数列 {
	public int rectCover(int target) {
		if(target <= 2) return target;
		return rectCover(target - 1) + rectCover(target - 2);
	}
}
