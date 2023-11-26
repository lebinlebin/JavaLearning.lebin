package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.MathArraysCompareBig;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * 此类用于演示BigInteger和BigDecimal类的特点和常见方法
 * 引入：
 * 	BigInteger :用于保存数值范围更大的整数
 *  BigDecimal: 用于保存精度更高的浮点型
 */
public class TestBigIntegerAndBigDecimal {
	//测试BigInteger
	@Test
	public void test1() {
		BigInteger b1 = new BigInteger("1234567890");
		BigInteger b2 = new BigInteger("1000000000");
		
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2));

	}
	
	//测试BigDecimal
	@Test
	public void test2() {
		BigDecimal b1 = new BigDecimal("1234567890");
		BigDecimal b2 = new BigDecimal("123");
		
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2,BigDecimal.ROUND_UP));

	}

}
