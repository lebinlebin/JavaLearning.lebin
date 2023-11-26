package Java.lebin.Training.communication.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;

/**
 * 此类用于演示构造器引用
 * @author liulebin
 * 理解：
 * 	构造器引用 相当于对满足一定条件的Lambda表达式的简化
 * 
 * 条件：
 * 	1、Lambda体中仅仅只有一句话
 * 	2、Lambda体中仅有的一句话为通过调用构造器创建对象
 *  3、构造器的参数列表和抽象方法的参数列表保持一致。抽象方法的返回类型正好为该对象的类型！
 * 
 * 语法：
 * 	类名::new
 *
 */
public class TestConstructorRef {
	//案例1：String s = new String();
	@Test
	public void test1() {
		//使用匿名内部类
		Supplier<String> sup1 = new Supplier<String>(){

			@Override
			public String get() {
				return new String();
			}
			
		};
		
		//使用构造器引用
		Supplier<String> sup2 = String::new;
		
		

	}
	//案例2：String s = new String("hello");
	@Test
	public void test2() {
		//使用匿名内部类
		Function<String,String> fun1 = new Function<String,String>(){

			@Override
			public String apply(String t) {
				return new String(t);
			}
			
		};
		
		//使用构造器引用
		
		Function<String,String> fun2 = String::new;
		
		
	}
	
	//案例3： Employee emp = new Employee(String name, int age, double salary, char sex);
	
	@Test
	public void test3() {
		
		//使用匿名内部类
		A<String,Integer,Double,Character,Employee> a = new A<String,Integer,Double,Character,Employee>(){

			@Override
			public Employee method(String t, Integer r, Double m, Character u) {
				return new Employee(t,r,m,u);
			}
			
		};
		
		//使用构造器引用
		
		A<String,Integer,Double,Character,Employee> b = Employee::new;

	}

}


interface A<T,R,M,U,V>{
	V method(T t, R r, M m, U u);
	
}
