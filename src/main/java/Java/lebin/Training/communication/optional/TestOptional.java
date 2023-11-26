package Java.lebin.Training.communication.optional;

import java.util.Optional;

import Java.lebin.Training.communication.bean.Employee ;

/**
 * 此类用于演示Optional类的使用
 * @author liulebin
 *
 */
public class TestOptional {
	
	public static void main(String[] args) {
		
		//1.创建Optional对象
		
		Optional<Employee> of = Optional.ofNullable(new Employee("john",12,10000,'男'));
//		
//		System.out.println(of);
		
		Optional<Employee> of2 = Optional.ofNullable(null);
		
//		System.out.println(of2);
		
//		if (condition) {
//			
//		} else {
//
//		}
		Employee orElse = of2.orElse(new Employee("匿名",10,1000,'女'));
		
		System.out.println(orElse);
		
		
	}

}
