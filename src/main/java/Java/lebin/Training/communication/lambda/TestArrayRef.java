package Java.lebin.Training.communication.lambda;

import java.util.function.Function;

import org.junit.Test;

/**
 * 此类用于演示数组引用
 * @author liyuting
 * 
 * 理解：
 * 	数组引用相当于满足一定条件的Lambda表达式的代替，也是作为函数式接口的实例出现
 * 
 * 要求：
 * 	1、Lambda体中仅仅只有一句话
 * 	2、仅有的一句话为创建数组对象
 *  3：抽象方法的参数类型为数组的长度类型，返回类型为创建的数组类型
 * 语法：
 * 	数组类型[]::new
 */
public class TestArrayRef {
	//案例1：return new String[5];    
	/*
	 * 返回类型：String[]
	 * 参数类型:Integer
	 */
	@Test
	public void test1() {
		//使用匿名内部类
		Function<Integer,String[]> fun1 =  new Function<Integer,String[]>(){

			@Override
			public String[] apply(Integer t) {
				return new String[t];
			}
			
		};
		
		//使用数组引用
		
		Function<Integer,String[]> fun2 = String[]::new;

	}

	//案例2：return new StringBuffer[6];
	
	@Test
	public void test2() {
		Function<Integer,StringBuffer[]> fun = StringBuffer[]::new;
		
	}
	
}
