package Java.lebin.Training.java8new.java1;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import Java.lebin.Training.java8new.java.Employee;

/*
 * 方法引用的使用
 * 1.方法引用是Lambda表达式的深一层次的表达。在某些情况下可以使用。
 * 2.哪些情况呢？
 *   如果Lambda体的实现已经有具体的类的方法给予实现了，那么就可以考虑使用方法引用。
 * 
 *   具体来讲：要求函数式接口中的抽象方法的形参列表和返回值类型与具体的某个方法的形参列表和返回值类型一致！
 * 
 * 3. 使用"::"操作符连接 类(或对象) 与 方法名。
 * 
 * 4. 方法引用的分类：
 *   4.1 对象 :: 实例方法名
 *   4.2 类 :: 静态方法名
 *   4.3 类 :: 实例方法名
 *   
 * 
 */
public class MethodRefTest {
	
	
	
	//3.类 :: 实例方法名
	//当需要引用方法的第一个参数是调用者，并且第二个参数是需要引用方法的第二个参数(或无参数)时：ClassName::methodName
	@Test
	public void test7(){
		Function<Employee,String> func = e -> e.getName();
		
		System.out.println("************");
		
		Function<Employee,String> func1 = Employee::getName;
	}
	
	@Test
	public void test6(){
		BiPredicate<String, String> pre = (s1,s2)->s1.equals(s2);
		
		System.out.println("************");
		
		BiPredicate<String, String> pre1 = String::equals;
		
		
	}
	@Test
	public void test5(){
		//x.compareTo(y)
		Comparator<String> com = (s1,s2) -> s1.compareTo(s2);

		System.out.println("************");
		
		Comparator<String> com1 = String::compareTo;
		
	}
	
	
	
	//2.类 :: 静态方法名
	@Test
	public void test4(){
		//Integer.compare(x,y)
		Comparator<Integer> com = (x,y) ->Integer.compare(x, y);
		System.out.println(com.compare(12, 34));
		
		System.out.println("************");
		
		Comparator<Integer> com1 = Integer::compare;
		System.out.println(com1.compare(12, 34));
		
	}
	@Test
	public void test3(){
		Function<Double,Long> func = d -> Math.round(d);
		System.out.println(func.apply(12.3));
		
		System.out.println("************");
		
		Function<Double,Long> func1 = Math::round;
		System.out.println(func1.apply(234.3));
		
		Function<Integer,Integer> func2 = Math::abs;
		System.out.println(func2.apply(-123));
	}
	
	
	//1.对象 :: 实例方法名
	@Test
	public void test2(){
		Employee emp = new Employee(1001,"Tom");
		Supplier<String> sup = () -> emp.getName();
		System.out.println(sup.get());
		
		System.out.println("************");
		
		Supplier<Integer> sup1 = emp::getId;
		System.out.println(sup1.get());
		
	}
	@Test
	public void test1(){
		PrintStream ps = System.out;
		Consumer<String> con = str -> ps.println(str);
		
		System.out.println("************");
		
		Consumer<String> con1 = ps::println;
		con1.accept("你好！北京！");
	}
	
}
