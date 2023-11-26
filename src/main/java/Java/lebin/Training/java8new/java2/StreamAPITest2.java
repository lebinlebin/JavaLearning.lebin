package Java.lebin.Training.java8new.java2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import Java.lebin.Training.java8new.java2.Employee.Status;

/*
 * Stream API Stream API的使用
 * 第三步：终止操作
 * 
 */
public class StreamAPITest2 {
	
	//3.收集
	@Test
	public void test6(){
//		collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法

		List<Employee> emps = EmployeeData.getEmployees();
		List<Employee> list = emps.stream().filter(e ->e.getSalary() > 5000).collect(Collectors.toList());
		for(Employee e : list){
			System.out.println(e);
		}
		
		System.out.println();
		
		Set<Employee> set = emps.stream().filter(e ->e.getSalary() > 5000).collect(Collectors.toSet());
		for(Employee e : set){
			System.out.println(e);
		}
		
		System.out.println();
		
		HashSet<Employee> hashSet = emps.stream().filter(e ->e.getSalary() > 5000).collect(Collectors.toCollection(HashSet :: new));
		for(Employee e : hashSet){
			System.out.println(e);
		}
		
	}
	//2.归约
	@Test
	public void test5(){
//		reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T  
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//		list.stream().reduce(0, (x,y) -> x + y);
		Integer sum = list.stream().reduce(10,Integer::sum);
		System.out.println(sum);
		
		
		
//		reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
		//计算所有员工的工资的总和
		List<Employee> emps = EmployeeData.getEmployees();
		Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(op.get());
		
		//员工姓名中包含"马"的个数
		Stream<Character> stream = emps.stream().map(Employee::getName).flatMap(StreamAPITest1::fromStringToChar);
		//方式一：
//		long count = stream.filter(c -> c.equals('马')).count();
//		System.out.println(count);
		//
		Optional<Integer> op1 = stream.map((c) -> {
			if(c.equals('马')){
				return 1;
			}else{
				return 0;
			}
		}).reduce(Integer::sum);
		System.out.println(op1.get());
		
		

	}
	
	//1.匹配与查找
	@Test
	public void test3(){
		List<Employee> emps = EmployeeData.getEmployees();
//		max(Comparator c)——返回流中最大值
		//返回最高的工资：
		Optional<Double> maxSalary = emps.stream().map(Employee::getSalary).max(Double::compare);
		System.out.println(maxSalary.get());
		
//		min(Comparator c)——返回流中最小值
		//返回工资最低的员工
		Optional<Employee> emp = emps.stream().min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(emp.get());
		
//		forEach(Consumer c)——内部迭代
		emps.stream().forEach(System.out::println);
		
		
	}
	
	//外部迭代
	@Test
	public void test4(){
		List<Employee> emps = EmployeeData.getEmployees();
		
		Iterator<Employee> iterator = emps.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	@Test
	public void test2(){
		List<Employee> emps = EmployeeData.getEmployees();
		//findFirst——返回第一个元素
		Optional<Employee> op = emps.stream().filter(e -> e.getAge() < 30).findFirst();
		System.out.println(op.get());
		
		
//		findAny——返回当前流中的任意元素
		//调用stream():获取串行流
		//调用parallelStream()：获取并行流
		Optional<Employee> op1 = emps.parallelStream().findAny();
		System.out.println(op1.get());
		
		
//		count——返回流中元素的总个数
		long l = emps.stream().filter(e -> e.getAge() < 30).count();
		System.out.println(l);
		
		
	}

	@Test
	public void test1(){
		List<Employee> emps = EmployeeData.getEmployees();
//		allMatch(Predicate p)——检查是否匹配所有元素
		boolean isFlag = emps.stream().allMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(isFlag);
		
//		anyMatch(Predicate p)——检查是否至少匹配一个元素
		isFlag = emps.stream().anyMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(isFlag);
		
		
//		noneMatch(Predicate p)——检查是否没有匹配的元素
		isFlag = emps.stream().noneMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(isFlag);
		
		
//		

	}
}
