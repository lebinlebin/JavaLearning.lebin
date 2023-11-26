package Java.lebin.Training.InterviewCases.MathOperator;

/**
 题目描述
 我们可以用2x1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2x1的小矩形无重叠地覆盖一个2xn的大矩形，总共有多少种方法？
 比如n=3时，2x3的矩形块有3种覆盖方法：
 假设我们可以用如下图所示2x1的小矩形横着或者竖着去覆盖更大的矩形，请问用8个2x1的小矩形去无重复的覆盖一个2x8的大矩形。总共有多少种方法。

 把覆盖2x8矩形的覆盖方法总数记为f(8).用第一个矩形去覆盖大矩形时，有两种选择，横放或者竖放。竖放时，右边有2x7的区域尚未被覆盖，那么剩下区域覆盖方法的总数为f(7)。
 第一个矩形横向的情况下，必须占用另外一个小矩形去覆盖左下角。此时就能确定最左边2x2的格子了，因此右边还剩下2x6的区域尚未被覆盖，记为f(6)。
 因此可以得出关系， f(8) = f(7) + f(6)。显然我们也知道f(1)=1,f(2) = 2.
 */
public class base的exponent次方 {
	public double Power(double base, int exponent) {
	  double res = 0;
	  if(equal(base,0)){
	  	return 0;
	  }
	  if(exponent > 0){
	  	res = mutiply(base,exponent);
	  }else {
		  res = mutiply(1/base,-exponent);
	  }
	  return res;
	}
	public double mutiply(double base,int e){
		double sum = 1;
		for (int i = 0; i < e; i++) {
			sum = sum*base;

		}
		return sum;
	}


	public  boolean equal(double a,double b){
		if(a-b < 0.000001 && a-b > -0.000001){
			return true;
		}
		return false;
	}
















	public double Power2(double base, int exponent) {

		// 指数为0就返回1
		if (exponent == 0) {
			return 1;
		}
		// 求指数的绝对值
		long exp = exponent;
		if (exponent < 0) {
			exp = -exp;
		}
		// 求幂次方
		double result = powerWithUnsignedExponent(base, exp);
		// 指数是负数，要进行求倒数
		if (exponent < 0) {
			result = 1 / result;
		}
		// 返回结果
		return result;
	}
	public static double powerWithUnsignedExponent(double base, long exponent) {
		// 如果指数为0，返回1
		if (exponent == 0) {
			return 1;
		}

		// 指数为1，返回底数
		if (exponent == 1) {
			return base;
		}

		// 递归求一半的值
		double result = powerWithUnsignedExponent(base, exponent >>1);

		// 求最终的值，如果是奇数就还要剩以一次底数
		result *= result;
		if (exponent % 2 != 0) {
			result *= base;
		}

		// 返回结果
		return result;
	}
}
