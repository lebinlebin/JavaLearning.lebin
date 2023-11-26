package Java.lebin.Training.communication.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import Java.lebin.Training.communication.bean.Employee;
import Java.lebin.Training.communication.bean.EmployeeData;

/**
 * 此类用于演示Stream的终止操作
 * 常见方法：
 * 	count:统计个数
 *  max(Comparator):求最大值
 *  min(Comparator):求最小值
 *  forEach（Consumer）:内部迭代
 *  reduce(BinaryOperator<T>):归约、合并
 *
 */
public class TestStreamEnd {
	
	List<Employee> list;
	@Before
	public void before(){
		 list = EmployeeData.getEmployees();
	}
	//测试：count  统计Stream中的元素个数
	@Test
	public void test1() {
		//1.获取stream对象
		Stream<Employee> stream = list.stream();
		
		//2.终止操作
		
		long count = stream.count();
		System.out.println(count);

	}
	
	//测试：max/min  获取Stream中的最大值或最小值
	@Test
	public void test2() {
		//1.获取stream对象
		Stream<Employee> stream = list.stream();
		
		//2.终止操作
		
//		Optional<Employee> max = stream.max((e1,e2)->Integer.compare(e1.getAge(), e2.getAge()));
		Optional<Employee> min = stream.min((e1,e2)->Integer.compare(e1.getAge(), e2.getAge()));
		
		System.out.println(min);

	}
	//测试：forEach 获取Stream中的内部迭代
	@Test
	public void test3() {
		//1.获取stream对象
		Stream<Employee> stream = list.stream();
		
		//2.终止操作
		stream.forEach(System.out::println);
		
	}
	
	//测试：reduce 归约，合并
	@Test
	public void test4() {
		//1.获取stream对象
		Stream<Employee> stream = list.stream();
		
		//2.终止操作
		/*
		 * BinaryOperator:
		 * T apply(T t1,T t2);
		 */
		
		//进阶1：匿名内部类：
//		stream.reduce(new BinaryOperator<Employee>(){
//
//			@Override
//			public Employee apply(Employee t, Employee u) {
//				return null;
//			}
//			
//		});
		Stream<Double> map = stream.map(e->e.getSalary());
				
		
		Optional<Double> reduce = map.reduce((t,u)->t+u);
		System.out.println(reduce);
		
	}
	//测试reduce：归约合并
	@Test
	public void test4_2() {

		Optional<String> reduce = list.stream().map(Employee::getName).reduce((t,u)->t.concat(",").concat(u));
		
		System.out.println(reduce);
	}
	
	//案例1：统计工资>100000的个数
	@Test
	public void exec1() {
		long count = list.stream().filter(e->e.getSalary()>100000).count();
		System.out.println(count);
		

	}
	
	//练习：员工姓名中包含“黄”的员工个数
	
	@Test
	public void exec2() {
		//方式一：筛选
		long count = list.stream().filter(e->e.getName().contains("黄")).count();
		System.out.println(count);
		
		//方式二：map-reduce
		
		Optional<Integer> reduce = list.stream().filter(e->e.getName().contains("黄")).map(e->1).reduce((t,u)->t+u);
		System.out.println(reduce);

	}

}
