package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.encap;

import org.junit.Test;

/**
 * 此类用于演示基本类型和包装类型之间的转换
 * 
 * @author liulebin
 *
 */
public class TestEncap1 {
	// 基本类型——>包装类型
	@Test
	public void test1() {
		//--------------------jdk5.0之前  手动装箱------------------
		int  i =100;
		//方式一：通过调用有参构造器
		
		Integer j1=new Integer(i);
		
		//方式二：通过调用静态方法
		Integer j2 = Integer.valueOf(i);
		
		//-------------------jdk5.0之后   自动装箱------------------------
		/*
		 * 要求：被装箱的值类型必须是对应的基本类型
		 */
		Integer j3 = i;
		Double d=1d;
		Float f = 1.5f;
	}

	// 包装类型——>基本类型
	@Test
	public void test2() {

		
		//------------------------jdk5.0之前  手动拆箱-----------------
		Integer i = new Integer("100");
		
		int j = i.intValue();
		System.out.println(j);
		
		//------------------------jdk5.0 自动拆箱----------------------
		/*
		 * 特点：
		 * 包装类型的值进行赋值给基本类型、比较、运算时都会进行自动拆箱
		 */
		int j2 = i;//①自动拆箱
		
		Integer x  =new Integer(3);
		Integer y = new Integer(5);
		System.out.println(x/y);//②自动拆箱
		
		
		if(x>100){//③自动拆箱
			System.out.println();
		}
		

	}
	//练习
	@Test
	public void exec1(){
		//自动装箱
		Character c = 'a';
		Character c3 = 100;
		
		//自动拆箱
		
		char c2 = c;
		
	}

}
