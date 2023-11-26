package Java.lebin.Training.java8new.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class LambdaTest {
	List<Employee> emps = EmployeeData.getEmployees();
	
	//举例2:由一个问题的迭代看Lambda表达式
//	问题：针对员工的集合数据，有如下的一些需求，我们考虑如何完成？
//
//	需求1：获取当前公司中员工年龄大于30的员工信息
//	需求2：获取公司中工资大于 5000 的员工信息
	
	//层次二的基础上优化三：Stream API
	@Test
	public void testFilterEmployees4(){
		//需求1：获取当前公司中员工年龄大于30的员工信息
		emps.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
		
		System.out.println("****************");
		
		//需求2：获取公司中工资大于 5000 的员工信息
		emps.stream().filter(e ->e.getSalary() > 5000).forEach(System.out::println);
	}
	
	//层次二的基础上优化三：Lambda表达式
	@Test
	public void testFilterEmployees3(){
		//需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> list = filterEmployees(emps,e ->e.getAge() > 30);
		list.forEach(System.out::println);//方法引用
		
		System.out.println("****************");
		
		//需求2：获取公司中工资大于 5000 的员工信息
		List<Employee> list1 = filterEmployees(emps,e->e.getSalary() > 5000);
		list.forEach(System.out::println);//方法引用
	}
	
	//层次二的基础上优化二：Lambda表达式
	@Test
	public void testFilterEmployees2(){
		//需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> list = filterEmployees(emps,e ->e.getAge() > 30);
		for(Employee e : list){
			System.out.println(e);
		}
		
		System.out.println("****************");
		
		//需求2：获取公司中工资大于 5000 的员工信息
		List<Employee> list1 = filterEmployees(emps,e->e.getSalary() > 5000);
		for(Employee e : list1){
			System.out.println(e);
		}
	}
	
	//层次二的基础上优化一：
	@Test
	public void testFilterEmployees1(){
		//需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> list = filterEmployees(emps,new MyPredicate<Employee>(){

			@Override
			public boolean test(Employee t) {
				return t.getAge() > 30;
			}
			
		});
		for(Employee e : list){
			System.out.println(e);
		}
		
		System.out.println("****************");
		
		//需求2：获取公司中工资大于 5000 的员工信息
		List<Employee> list1 = filterEmployees(emps,new MyPredicate<Employee>(){

			@Override
			public boolean test(Employee t) {
				return t.getSalary() > 5000;
			}
			
		});
		for(Employee e : list1){
			System.out.println(e);
		}
	}
	
	//层次二：
	@Test
	public void testFilterEmployees(){
		//需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> list = filterEmployees(emps,new FilterEmployeesByAge());
		for(Employee e : list){
			System.out.println(e);
		}
		
		System.out.println("****************");
		
		//需求2：获取公司中工资大于 5000 的员工信息
		List<Employee> list1 = filterEmployees(emps,new FilterEmployeesBySalary());
		for(Employee e : list1){
			System.out.println(e);
		}
	}
	
	
	
	public List<Employee> filterEmployees(List<Employee> list,MyPredicate<Employee> pre){
		
		List<Employee> data = new ArrayList<Employee>();
		
		for(Employee e : list){
			if(pre.test(e)){
				data.add(e);
			}
		}
		return data;
		
	}
	
	
//	....
	//层次一：
	@Test
	public void test4(){
		
		List<Employee> data = filterEmployeesBySalary(emps);
		for(Employee l : data){
			System.out.println(l);
		}
	}
	
	//需求2：获取公司中工资大于 5000 的员工信息
	public List<Employee> filterEmployeesBySalary(List<Employee> list){
		List<Employee> data = new ArrayList<>();
		for(Employee e : list){
			if(e.getSalary() > 5000){
				data.add(e);
			}
		}
		
		return data;
	}
	
	
	@Test
	public void test3(){
		List<Employee> emps = EmployeeData.getEmployees();
		List<Employee> data = filterEmployeesByAge(emps);
		for(Employee l : data){
			System.out.println(l);
		}
	}
	
	//需求1：获取当前公司中员工年龄大于30的员工信息
	public List<Employee> filterEmployeesByAge(List<Employee> list){
		List<Employee> data = new ArrayList<>();
		for(Employee e : list){
			if(e.getAge() > 30){
				data.add(e);
			}
		}
		
		return data;
	}

	
	
	//举例1：
	//使用Lambda表达式
	@Test
	public void test2(){
		Comparator<String> com = (o1,o2) -> o1.compareTo(o2);
				
		TreeSet<String> set = new TreeSet(com);
		set.add("AA");
		set.add("MM");
		set.add("JJ");
		set.add("DD");
		
		for(String s : set){
			System.out.println(s);
		}
	}
	
	//不使用Lambda表达式
	@Test
	public void test1(){
		
		Comparator<String> com = new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		};
		
		TreeSet<String> set = new TreeSet(com);
		set.add("AA");
		set.add("MM");
		set.add("JJ");
		set.add("DD");
		
		for(String s : set){
			System.out.println(s);
		}
		
	}
}
