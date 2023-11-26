package Java.lebin.Training.communication.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;
import Java.lebin.Training.communication.bean.EmployeeData;

/**
 * 
 * Stream的使用步骤：
 * 1、开始操作（创建Stream对象指向一个具体的数据源）
 * 2、中间操作（对数据源进行处理，返回一个Stream类型新结果）
 * 3、终止操作
 * 
 * 此类用于演示Stream的开始操作
 * 方式一：根据集合获取Stream对象  （数据源：集合）
 * 
 * 方式二：根据数组获取Stream对象  (数据源：数组)
 * 
 * 方式三：根据一组序列值获取Stream对象（数据源：一组值）
 * 
 * 
 * 方式四：创建无限流，根据一个规则获取Stream对象（数据源：自定义规则）
 *
 */
public class TestStreamStart {
	//方式一：根据集合获取Stream对象  （数据源：集合） ★
	@Test
	public void test1() {
		
		List<Employee> list = EmployeeData.getEmployees();
		//获取串行流对象
		Stream<Employee> stream = list.stream();
		
		//获取并行流对象
		Stream<Employee> parallelStream = list.parallelStream();
		
		
		
		//终止操作
		//使用匿名内部类：
//		stream.forEach(new Consumer<Employee>(){
//
//			@Override
//			public void accept(Employee t) {
//				System.out.println(t);
//			}
//			
//			
//		});
		
		//使用Lambda表达式:
		
//		stream.forEach(t->System.out.println(t));
		
		
		//使用方法引用：
		
		stream.forEach(System.out::println);
		

	}
	
	//方式二：根据数组获取Stream对象  (数据源：数组)
	@Test
	public void test2() {
		
		String[] arr = {"john","lucy","lily"};
//		Stream<String> stream = Arrays.stream(arr);
//		
//		stream.forEach(System.out::println);
		
		Arrays.stream(arr).forEach(System.out::println);

	}
	// 方式三：根据一组序列值获取Stream对象（数据源：一组值）
	@Test
	public void test3() {
		
		Stream<Character> of = Stream.of('a','b','c','d');
		
		of.forEach(System.out::println);

	}
	//方式四：生成无限流
	@Test
	public void test4() {
		//匿名内部类
//		Stream<Double> generate = Stream.generate(new Supplier<Double>(){
//
//			@Override
//			public Double get() {
//				return Math.random();
//			}
//			
//			
//		});
//		
		//Lambda
//		Stream<Double> generate2 = Stream.generate(()->Math.random());
		
		//方法引用
		
		Stream<Double> generate3 =  Stream.generate(Math::random);
		
		generate3.forEach(System.out::println);
		
		

	}

}





