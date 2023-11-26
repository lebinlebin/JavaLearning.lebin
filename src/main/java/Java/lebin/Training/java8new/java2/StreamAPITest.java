package Java.lebin.Training.java8new.java2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;


import Java.lebin.Training.java8new.java2.Employee;
import Java.lebin.Training.java8new.java2.EmployeeData;

/**
 * Stream API的使用
 * 1.用处：理解为对数据源（集合、数组）进行的诸如查找、过滤、映射等查询操作
 * 
 * 2.使用步骤：
 * 第一步：实例化Stream API
 * 第二步：一系列的中间操作
 * 第三步：终止操作:一旦执行终止操作，就执行中间操作链，并产生结果
 * 
 * 
 * @author shkstart
 * @version 2017年6月21日 下午4:59:49
 *
 */
public class StreamAPITest {
	//第一步：实例化Stream API
	@Test
	public void test1(){
		//方式一：调用集合
		List<Employee> emps = EmployeeData.getEmployees();
		Stream<Employee> stream = emps.stream();
		
		//方式二：使用数组
		String[] arr = new String[]{"AA","BB","CC","DD"};
		Stream<String> stream1 = Arrays.stream(arr);
		
		//方式三：调用Stream的静态方法of()
		Stream<String> stream2 = Stream.of("MM","GG","JJ","DD");
		
		//方式四：创建无限流
		//迭代
		Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
		stream3.limit(10).forEach(System.out::println);
		//生产
		Stream<Double> stream4 = Stream.generate(Math::random);
		stream4.limit(5).forEach(System.out::println);
		
		
	}
}
