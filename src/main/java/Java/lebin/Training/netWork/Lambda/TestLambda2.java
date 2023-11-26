package Java.lebin.Training.netWork.Lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * 此类用于演示Lambda表达式的语法和特点
 * @author liulebin
 * 
 * 理解：
 * 	Lambda表达式相当于代替匿名内部类的，但要求：匿名内部类实现的接口中只有一个抽象方法
 * 	
 * 应用场景：
 * 	①Lambda表达式同匿名内部类的应用场景，一般作为接口的实例传递给方法（或者接口的引用）
 * 
 * 
 * 	method(Lambda表达式);
 * 	public void method(接口A a){
 * 		a.方法();
 * 	}
 * 	
 *  ②直接做为接口的实例赋值给接口   （接口的引用）
 *  
 *  接口A  a = Lambda表达式;
 *  
 *  
 * 
 * 语法：
 * (参数类型 参数名,参数类型 参数名) ->  {语句1；语句2;}
 * 
 * 注意事项：
 * 
 * ①参数类型可以省略
 * ②如果Lambda体中只有一句话，则大括号也可以省略
 * ③如果Lambda体中只有一句话而且是return语句，则return也可以省略
 * ④如果只有一个参数，则小括号也可以省略
 *
 */
public class TestLambda2 {
	
	//测试1：
	@Test
	public void test1() {
		//匿名内部类
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("哈哈哈1");
				System.out.println("哈哈哈2");
			};
		};
		
		r.run();
		//Lambda
		
		Runnable r2 = () -> {
			System.out.println("哈哈哈1");
			System.out.println("哈哈哈2");
		};
		
		r2.run();
		
	}

	//测试2：
	@Test
	public void test2() {
		//匿名内部类
		Comparator<String> c1 = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				System.out.println("");
				return o1.compareTo(o2);
			}
		};
		
		
		//Lambda
		Comparator<String> c2 = ( o1, o2)-> o1.compareTo(o2);
		
	}
	//测试3
	@Test
	public void test3() {
		
		Fly fly = new Fly(){

			@Override
			public void method(String s) {
				System.out.println(s);
			}
		};
		

		Fly fly2 = s -> System.out.println(s);

	}

}


interface Fly{
	void method(String s);
}









