package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.exec1;
/*
 * 编写程序，main方法中接收两个数字字符串参数；
将第一个字符串直接转为Integer对象；
将第二个字符串解析int整数，然后用此整数构建Integer对象；
使用人工拆箱，获得上述两个对象int整数值，求和打印出来；
使用自动拆箱，计算两数之积并打印出来。

 */
public class TestEncap1 {
	
	public static void main(String[] args) {
		
		String a = args[0];
		String b = args[1];
		
		//将第一个字符串直接转为Integer对象；
		
		Integer i1 = Integer.valueOf(a);
		
		//将第二个字符串解析int整数
		int i2 = Integer.parseInt(b);
		
		//用此整数构建Integer对象(手动装箱)
		Integer m = new Integer(i2);
		//使用人工拆箱，获得上述两个对象int整数值(手动拆箱)
		int j1 = i1.intValue();
		int j2 = m.intValue();
		System.out.println(j1+j2);
		//使用自动拆箱，计算两数之积并打印出来。(自动拆箱)
		System.out.println(i1*m);
		
	}

}
