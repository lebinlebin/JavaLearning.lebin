package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.MathArraysCompareBig;
/**
 * 此类用于演示Math类的特点和常见方法
 * @author liulebin
 *
 */
public class TestMath {

	
	public static void main(String[] args) {
		
		//方法1：sqrt
		System.out.println(Math.sqrt(6.25));
		
		//方法2：求幂
		System.out.println(Math.pow(5, 3));
		
		//方法3：向上取整 (用于返回>=参数的最小整数)
		
		System.out.println(Math.ceil(-1.002));
		//方法4：向下取整(用于返回<=参数的最大整数)
		System.out.println(Math.floor(-1.99));
		
		//方法5：四舍五入(Math.floor(-1.567+0.5))
		System.out.println(Math.round(-1.500));
		
		
		//方法6：求绝对值
		System.out.println(Math.abs(0));
		
		//方法7：随机数
		System.out.println(Math.random());
		
		//方法8：求两个数的最大值
		System.out.println(Math.max(1.5, 9.0));
		
		//方法8：求两个数的最小值
		System.out.println(Math.min(1.5, 9.0));

	}
}
