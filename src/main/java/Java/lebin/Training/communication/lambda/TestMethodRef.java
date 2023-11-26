package Java.lebin.Training.communication.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;

/**
 * 此类用于演示方法引用
 * 引入：
 * 	Lambda体的实现可以为一句话，也可以为多句话。也可以为一个方法的调用，也可以为运算等等
 *  
 * 理解：
 * 	满足一定条件的Lambda表达式的代替，也是作为函数式接口的实例出现！
 * 	方法引用仅仅是Lambda表达式的语法糖形式，提高语义性和阅读性
 * 
 * 
 * 要求：
 * 	1、Lambda体中只有一句话
 * 	2、仅有的这一句话为方法的调用
 * 	3、调用的方法中的参数列表和返回 ，与实现的抽象方法的参数列表和返回一致！【不太懂这句话】
 * 如果是类名调用普通方法，则要求：抽象方法的第一次参数为调用方法的调用者，其他参数类型一致！
 * 
 * 	语法：
 * 	对象或类::方法名
 * 
 *  形式：
 *  	①对象::普通方法
 *  	②类::静态方法
 *  	③类::普通方法
 *
 */

public class TestMethodRef {
	
	//测试形式1：对象::普通方法
	@Test
	public void test1() {
		//使用Lambda表达式
		Consumer<String> con = s->System.out.println(s);
		
		//使用方法引用
		
		Consumer<String> con2 = System.out::println;
		con2.accept("hello");

	}

	
	//测试形式2:类::静态方法
	
	@Test
	public void test2() {
		
		//使用Lambda表达式
		Comparator<Integer> com1 = (i1,i2)->Integer.compare(i1, i2);
		Comparator<Double> com3 = (i1,i2)->Double.compare(i1, i2);
		
		//使用方法引用
		Comparator<Integer> com2 = Integer::compare;
		Comparator<Double> com4 = Double::compare;
		
			

	}
	//测试形式3：类::普通方法
	//案例1：
	@Test
	public void test3() {
		
		//使用匿名内部类
		Comparator<String> com1 = new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		};
		
		
		//使用Lambda表达式
		Comparator<String> com2 = (o1,o2)->o1.compareTo(o2);
		
		
		//使用方法引用
		Comparator<String> com3 = String::compareTo;
		

	}
	//测试形式3：类::普通方法
	//案例2：
	@Test
	public void test4() {
		//使用匿名内部类
		BiFunction<String, String, Boolean> b1 = new BiFunction<String, String, Boolean>() {
			
			@Override
			public Boolean apply(String t, String u) {
				return t.equals(u);
			}
		};
		
		//使用Lambda表达式
		BiFunction<String, String, Boolean> b2 = (t,u)->t.equals(u);
		
		//使用方法引用
		BiFunction<String, String, Boolean> b3 = String::equals;

	}
	
	//测试形式3：类::普通方法
	//案例3：
	@Test
	public void test5() {
		//使用匿名内部类
		Function<Employee,String>  fun1 = new Function<Employee,String>(){

			@Override
			public String apply(Employee t) {
				return t.getName();
			}
			
		};
		
		//使用方法引用
		Function<Employee,String>  fun2 = Employee::getName;
		

	}
}















