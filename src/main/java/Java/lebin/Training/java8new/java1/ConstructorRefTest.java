package Java.lebin.Training.java8new.java1;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import Java.lebin.Training.java8new.java.Employee;

/**
 * 
 * 构造器引用
 * 格式： 类名 :: new
 * 
 * 具体来讲：1）要求函数式接口中的抽象方法的形参列表与具体的构造器的形参列表一致！
 *        2）要求函数式接口中的抽象方法的返回值类型即为构造器所在类的类型。
 *        
 *        
 *  数组引用：
 *  格式：类型[] :: new      
 *        
 * 
 * @author shkstart 
 * @version 2017年6月21日 下午4:38:12
 *
 */
public class ConstructorRefTest {
	
	//数组引用：
	@Test
	public void test2(){
		Function<Integer, String[]> func = num -> new String[num];
		String[] strs = func.apply(10);
		System.out.println(strs.length);
		
		System.out.println("***********************");
		
		Function<Integer, String[]> func1 = String[] :: new;
		String[] arr = func1.apply(20);
		System.out.println(arr.length);
	}
	
	
	
	//构造器引用:
	@Test
	public void test1(){
		Supplier<Employee> sup = () -> new Employee();
		
		System.out.println(sup.get());
		
		
		Supplier<Employee> sup1 = Employee::new;
		System.out.println(sup1.get());
		
		
		System.out.println("***********************");
		
		Function<String, Employee> func = s -> new Employee(s);
		
		Function<String, Employee> func1 = Employee::new;
		Employee emp = func1.apply("Tom");
		System.out.println(emp);
		
		
		System.out.println("***********************");
		
		BiFunction<Integer, String, Employee> bi = (id,name) -> new Employee(id,name);
		Employee emp1 = bi.apply(1001, "成吉思汗");
		System.out.println(emp1);
		
		BiFunction<Integer, String, Employee> bi1 = Employee :: new;
		Employee emp2 = bi.apply(1002, "忽必烈");
		System.out.println(emp2);
	}
	
	
	/**
	 * ....
	 * @author shkstart
	 * @param s ...
	 * @return ...
	 */
	public int method(String s){
		return 0;
	}
}
