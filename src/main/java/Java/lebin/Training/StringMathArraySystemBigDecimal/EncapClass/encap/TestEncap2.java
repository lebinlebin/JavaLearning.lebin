package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.encap;

import org.junit.Test;

/**
 * 此类用于演示包装类型和String类型之间的转换
 * @author liulebin
 *
 */
public class TestEncap2 {

	//包装类型————>String类型(针对于八大包装类型)
	@Test
	public void test1() {
		
		Integer  i = 100;
		
		//方式一：
		String s1 = i+"";
		
		//方式二：
		String s2 = String.valueOf(i);
		
		//方式三：
		String s3 = i.toString();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}
	//String————>包装类型(只能针对于 除了Character类型)
	@Test
	public void test2(){
		
		String s = "123";
		
		//方式一：
		Integer j1= new Integer(s);
		
		//方式二：
		
		Integer j2 = Integer.valueOf(s);
		
		
	}
	//测试String——>Boolean
	@Test
	public void exec1() {
		
		String s = "abc";
		
		Boolean flag = Boolean.valueOf(s);
		
		System.out.println(flag);

	}
	//测试String————>Character
	@Test
	public void exec2() {
		
		String s = "a";
		Character c= s.charAt(0);
		

	}
}
