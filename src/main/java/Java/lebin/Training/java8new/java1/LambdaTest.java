package Java.lebin.Training.java8new.java1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import Java.lebin.Training.java8new.java.Employee;
/*
 * 1.Lambda表达式的基本语法：
 *   在java8中的lambda表达式中可以使用"->" :lambda操作符或箭头操作符
 *   "->"左边：lambda表达式使用的参数列表
 *   "->"右边：lambda表达式的执行体。即：lambda体
 * 
 *  有如下的六种情况。
 *  
 *  总结:
 *  箭头操作符左边：可以省略变量类型。
 *  		   如果只有个参数，可以省略()
 *  箭头操作符右边：如果只有一行执行语句，省略{}
 *  		   如果只有一行执行语句，且为return ... ，省略{} 和 return关键字
 * 
 * 
 * 2.函数式接口：只包含一个抽象方法的接口。
 *   Lambda表达式的使用，依赖于函数式接口！
 */
public class LambdaTest {
	
	@Test
	public void testCustom(){
		Integer i = custom(10, x -> x * x);
		System.out.println(i);
	}
	
	public Integer custom(Integer num,MyFunction func){
		return func.getValue(num);
	}
	
	
	//关于“类型推断”
	@Test
	public void test(){
		List<String> list = new ArrayList<>();
		
		int[] arr = {1,2,4};
		
		int[] arr1 = null;
		arr1 = new int[]{1,2,3};//不能省略new int[]
		
		method(new HashMap<>());
	}
	
	public void method(HashMap<String,Employee> map){
		
	}
	
	//语法格式六：如果箭头操作符右边只有一行执行语句，可以省略{} ; 或者有返回值,也可以省略return
	@Test
	public void test6(){
		Comparator<String> com = (x,y)-> x.compareTo(y);
		
		int value = com.compare("hello", "hi");
		System.out.println(value);
	}
	
	//语法格式五：箭头操作符左边的参数有两个或两个以上，右边有不止一行执行语句，甚至有返回值
	@Test
	public void test5(){
		Comparator<String> com = (x,y)->{
			System.out.println("比较两个String的大小");
			return x.compareTo(y);
		};
		
		int value = com.compare("hello", "hi");
		System.out.println(value);
	}
	
	//语法格式四：箭头操作符左边的参数只有一个，一对()也可以省略
	@Test
	public void test4(){
		Consumer<String> con = s ->{
			System.out.println(s);
			
		};
		
		con.accept("atguigu");
	}
	
	//语法格式三：箭头操作符左边的参数列表的数据类型可以省略.
	//由于编译器可以根据上下文判断此时的变量的数据类型，进而可以省略此类型。“类型推断”
	@Test
	public void test3(){
		Consumer<String> con = (s) ->{
			System.out.println(s);
			
		};
		
		con.accept("atguigu");
	}
	
	
	//语法格式二：有一个参数，无返回值
	@Test
	public void test2(){
		Consumer<String> con = (String s) ->{
			System.out.println(s);
			
		};
		
		con.accept("atguigu");
	}
	
	
	//语法格式一：无参数，无返回值
	@Test
	public void test1(){
		
		int num = 10;//在jdk8以前，必须显式的声明为final;jdk8：可以省略
		
		Runnable r = new Runnable(){

			@Override
			public void run() {
//				num = 20;
				System.out.println("你好！北京！" + num);
			}
			
		};
		
		r.run();
		
		System.out.println("****************");
		
		Runnable r1 = () -> {
			System.out.println("hello,Lambda!");
			System.out.println("hello,Lambda!");
			System.out.println("hello,Lambda!");
			
		};
		
		r1.run();
		
		
	}
}
