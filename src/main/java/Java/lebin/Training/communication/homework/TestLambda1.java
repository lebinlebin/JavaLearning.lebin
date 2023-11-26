package Java.lebin.Training.communication.homework;

import org.junit.Test;

/**
 * 一、①声明一个接口，接口中声明抽象方法：public String getValue(String str);
②声明类LambdaTest，类中编写方法使用接口作为参数，方法体调用getValue方法，返回处理后的字符串值。

		实现1：将一个字符串转换成大写，并作为方法的返回值。
		实现2：将一个字符串的第2个到第4个索引位置进行截取子串。

 * @author liyuting
 *
 */
public class TestLambda1 {
	
	//实现1：将一个字符串转换成大写，并作为方法的返回值。
	@Test
	public void test1() {
		
//		method(new A(){
//
//			@Override
//			public String getValue(String str) {
//				return str.toUpperCase();
//			}
//			
//		},"hello");
//		
		
		System.out.println(method(str->str.toUpperCase(),"hello"));

	}
	
	//实现2：将一个字符串的第2个到第4个索引位置进行截取子串。
	@Test
	public void test2() {
		System.out.println(method(str-> str.substring(1,4),"hello"));

	}
	
	
	
	public String method(A a,String str){
		return a.getValue(str);
	}

}

interface A{
	public String getValue(String str);
}