package Java.lebin.Training.java8new.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import Java.lebin.Training.java8new.java.Employee;
import Java.lebin.Training.java8new.java.EmployeeData;

/*
 * Lambda表达式的四大函数式接口：
 * 
 * 1. Consumer<T> :消费型接口
 * 		void accept(T t);
 * 
 * 2.Supplier<T> : 供给型接口
 *    T get();
 *    
 * 3. Function<T,R>:函数型接口
 *     R apply(T t);
 * 
 * 4. Predicate<T> :断言型接口
 * 	  boolean test(T t);
 * 
 *  什么时候可以使用Lambda表达式？
 *  >当我们调用一个方法时，如果方法的形参中包含一个函数式接口，那么此参数赋值时就可以使用Lambda表达式。
 *  
 *  >我们自定义一个方法时，如果方法的形参恰好需要一个函数式接口，那么此接口我们就没必要自己去定义了。往往
 *  系统提供了现成的函数式接口。举例：com.atguigu.java.MyPredicate接口就可以使用Predicate接口替换。
 */
public class LambdaTest1 {
	
	//4. 断言型接口
	@Test
	public void testFilterEmployees(){
		List<Employee> emps = EmployeeData.getEmployees();
		
		List<Employee> list = filterEmployees(emps, emp -> emp.getAge() > 30);
		for(Employee e : list){
			System.out.println(e);
		}
		
		System.out.println("****************");
		List<Employee> list1 = filterEmployees(emps, emp -> emp.getSalary() > 5000);
		for(Employee e : list1){
			System.out.println(e);
		}
		
	}
	
	//重新完成上午举例2
	public List<Employee> filterEmployees(List<Employee> list,Predicate<Employee> pre){
		List<Employee> data = new ArrayList<Employee>();
		
		for(Employee e : list){
			if(pre.test(e)){
				data.add(e);
			}
		}
		return data;
		
	}
	
	@Test
	public void testGetString(){
		List<String> list = Arrays.asList("hello","lambda","hi","beijing");
		
		List<String> list1 = getString(list,str -> str.length() > 4);
		
		for(String s : list1){
			System.out.println(s);
		}
	}
	
	public List<String> getString(List<String> list,Predicate<String> pre){
		List<String> data = new ArrayList<String>();
		
		for(String s : list){
			if(pre.test(s)){
				data.add(s);
			}
		}
		
		return data;
		
	}
	
	//3.函数型接口
	@Test
	public void testHandleString(){
		String str1 = handleString("世界那么大，我想去看看",str -> str.substring(2, 5));
		System.out.println(str1);
		
		
		str1 = handleString("  hello  world   ",str -> str.trim());
		System.out.println(str1);
	}
	public String handleString(String str,Function<String,String> func){
		return func.apply(str);
	}
	
	
	//2.供给型接口的使用
	@Test
	public void testGetRandomNumber(){
		List<Double> list = getRandomNumer(10,() -> Math.random() * 100);
		for(Double d : list){
			System.out.println(d);
		}
	}
	public List<Double> getRandomNumer(int num,Supplier<Double> s){
		List<Double> list = new ArrayList<>();
		
		for(int i = 0;i < num;i++){
			list.add(s.get());
		}
		
		return list;
	}
	
	//1.消费型接口的使用
	@Test
	public void testGetHappy(){
		//原来的写法
		getHappy(1000,new Consumer<Integer>() {

			@Override
			public void accept(Integer money) {
				System.out.println("每次学习累了，可以去做做正规的足浴，花费了" + money);
			}
			
		});
		
		
		//使用Lambda表达式
		getHappy(1000,money -> {
			System.out.println("每次学习累了，可以去做做正规的足浴，花费了" + money);
		});
		
	}
	public void getHappy(Integer money,Consumer<Integer> con){
		con.accept(money);
	}
	
}
