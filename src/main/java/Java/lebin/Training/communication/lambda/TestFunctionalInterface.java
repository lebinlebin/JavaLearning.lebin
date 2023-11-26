package Java.lebin.Training.communication.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;

/**
 * 此类用于演示函数式接口的使用
 * @author liulebin
 * 
 * 消费型接口Consumer
 * 供给型接口Supplier
 * 函数型接口Function
 * 断定型接口Predicate
 *
 */
public class TestFunctionalInterface {
	//测试：消费型接口Consumer
	@Test
	public void test1() {
		//jdk7：List<Integer> list = new ArrayList<>();√
		//jdk8：List<Integer> list = new ArrayList<>(); √
		//      List<Integer> list = new ArrayList<Integer>(){};
		
		
		//jdk9:List<Integer> list = new ArrayList<>(); √
		//      List<Integer> list = new ArrayList<>(){}; √
		
		
		
		//匿名内部类
//		Consumer<Integer> con =new Consumer<Integer>(){
//
//			@Override
//			public void accept(Integer t) {
//				if (t>1000) {
//					System.out.println("吃大烤鸭");
//				}else{
//					System.out.println("吃肉夹馍");
//				}
//			}
//			
//			
//		};
		
		//Lambda
		Consumer<Integer> con2 = t->{
			
			if (t>1000) {
				System.out.println("吃大烤鸭");
			}else{
				System.out.println("吃肉夹馍");
			}
		};
		
		con2.accept(2000);

	}
	//测试供给型接口Supplier
	@Test
	public void test2() {
		Supplier<String> sup = ()->"john".toUpperCase();
		System.out.println(sup.get());

	}
	//测试函数型接口Function
	@Test
	public void test3() {
		Function<Double,Double> fun = d->Math.pow(d, 2);
		
		System.out.println(fun.apply(100d));
	}
	
	//测试断定型接口Predicate
	@Test
	public void test4() {
		
		Predicate<Employee> pre = e->e.getName().contains("a");
		
		System.out.println(pre.test(new Employee("john", 12, 1000, '女')));

	}

}
