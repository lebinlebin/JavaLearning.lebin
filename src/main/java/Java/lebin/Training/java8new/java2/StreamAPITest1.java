package Java.lebin.Training.java8new.java2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;


import Java.lebin.Training.java8new.java2.Employee.Status;

/*
 * Stream API的使用
 * 第二步：中间操作。
 * 
 * 1.如果只调用了一系列的中间操作，而没有终止操作,是不会执行这些中间操作的！ "惰性求值"
 * 2.一旦Stream对象执行了终止操作，就不可以再继续执行中间操作或其他的终止操作了。
 */
public class StreamAPITest1 {
	
	//3.排序
	@Test
	public void test3(){
//		sorted()——自然排序
		List<String> list = Arrays.asList("Tim","Tom","Jim","HanMeimei","Lilei");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		
		//由于Employee没有实现Comparable接口，所以报错
//		List<Employee> emps = EmployeeData.getEmployees();
//		emps.stream().sorted().forEach(System.out::println);
		
		
//		sorted(Comparator com)——定制排序
		List<Employee> emps = EmployeeData.getEmployees();
		emps.stream().sorted((e1,e2) ->{
			
			if(e1.getAge() != e2.getAge()){
				return e1.getAge() - e2.getAge();
			}else{
				return -Double.compare(e1.getSalary(), e2.getSalary());
			}
			
		}).forEach(System.out::println);
	}
	
	//2.映射
	@Test
	public void test2(){
//     map(Function f)——接收 Lambda，将元素转换成其他形式或提取信息。
		//接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		List<String> list = Arrays.asList("aa","bb","cc","dd");
		Stream<String> stream2 = list.stream().map(String :: toUpperCase);
		stream2.forEach(System.out::println);
		
		System.out.println();
		
		//获取员工姓名长度大于2的员工的姓名。
		List<Employee> emps = EmployeeData.getEmployees();
		Stream<Employee> stream = emps.stream();
		Stream<String> stream1 = stream.map(Employee::getName);
		stream1.filter(n -> n.length() > 2).forEach(System.out::println);
		
		System.out.println();
		
		
		Stream<Stream<Character>> stream3 = list.stream().map(StreamAPITest1::fromStringToChar);
		stream3.forEach(x -> {
			x.forEach(System.out::println);
		});
		
		System.out.println();
		
//	    flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
		Stream<Character> stream4 = list.stream().flatMap(StreamAPITest1::fromStringToChar);
		stream4.forEach(System.out::println);
		
		
	}
	
	//将字符串中的字符取出，放入到一个集合中，返回集合的流。
	public static Stream<Character> fromStringToChar(String str){
		List<Character> list = new ArrayList<Character>();
		
		for(Character c : str.toCharArray()){
			list.add(c);
		}
		return list.stream();
	}
	
	/*
	 * list.add(123);
	 * list.add(35);
	 * 
	 * List list1 = Arrays.asList(1,2,3);
	 * 
	 * list.add(list1);//[123,35,[1,2,3]];
	 * list.addAll(list1);//[123,35,1,2,3];
	 * 
	 * 
	 */

	// 1.筛选与切片
	@Test
	public void test1() {
		List<Employee> emps = EmployeeData.getEmployees();
		// filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
		Stream<Employee> stream = emps.stream();
		stream.filter(x -> {
			System.out.println("filter....");
			return x.getAge() > 30;
		}).forEach(System.out::println);

		System.out.println();
		
		// limit(n)——截断流，使其元素不超过给定数量。
		emps.stream().filter(x -> x.getSalary() > 5000).limit(3).forEach(System.out::println);
		
		System.out.println();
		
		// skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		emps.stream().filter(x -> x.getSalary() > 5000).skip(3).forEach(System.out::println);
		
		System.out.println();
		
		// distinct() ——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
		emps.add(new Employee(1006, "俞敏洪", 22, 2333.32,Status.BUSY));
		emps.add(new Employee(1006, "俞敏洪", 22, 2333.32,Status.BUSY));
		emps.add(new Employee(1006, "俞敏洪", 22, 2333.32,Status.BUSY));
		emps.add(new Employee(1006, "俞敏洪", 22, 2333.32,Status.BUSY));
		System.out.println(emps.size());//10
		
		emps.stream().distinct().forEach(System.out::println);
		
	}

}
