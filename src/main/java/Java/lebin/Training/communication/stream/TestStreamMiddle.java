package Java.lebin.Training.communication.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;
import Java.lebin.Training.communication.bean.EmployeeData;

/**
 * 此类用于演示Stream的中间操作
 * @author liulebin
 * ①惰性求值。  除非进行终止操作，否则前面的中间操作不会执行任何处理
 * ②中间操作执行终止操作后，属于“一次性消费”，不能再继续执行终止操作
 * 
 * ③多个中间操作可以形成流水线操作
 * 常见方法：
 *      filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
		limit(n)——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
		map(Function<元素类型,R>)——映射，根据元素本身一一映射成新的元素
		flatMap(Function<元素类型,Stream>)——映射
		sorted()——自然排序
		sorted(Comparator)——定制排序
		
		
 *
 */
public class TestStreamMiddle {
	List<Employee> list;
	@Before
	public void before(){
		 list = EmployeeData.getEmployees();
	}
	//筛选与切片
	@Test
	public void test1() {
		
		//1.获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作
		//filter：根据条件过滤
//		Stream<Employee> filter = stream.filter(t->t.getAge()>30);
		//limit:用于限制最大元素个数
//		Stream<Employee> limit = stream.limit(50);
		//skip:跳过指定的个数
//		Stream<Employee> skip = stream.skip(3);
		//distinct:去重
		Stream<Employee> distinct = stream.distinct();
		
		
		
		
		//3.终止操作
		distinct.forEach(System.out::println);

	}
	
	//测试：映射
	@Test
	public void test2() {
		
		//1.获取Stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作
		//map:映射
//		Stream<String> map = stream.map(new Function<Employee,String>(){
//
//			@Override
//			public String apply(Employee t) {
//				return t.getName();
//			}});
		
		
//		Stream<String> map = stream.map(Employee::getName);
		
		
		//flatMap:映射
		//使用匿名内部类：
//		stream.flatMap(new Function<Employee,Stream<Object>>(){
//
//			@Override
//			public Stream<Object> apply(Employee t) {
//				return TestStreamMiddle.employeeToStream(t);
//			}
//			
//		});
		
		//使用方法引用
		
		Stream<Object> flatMap = stream.map(TestStreamMiddle::employeeToStream);
		
		//3.终止操作
		
		flatMap.forEach(System.out::println);

	}
	
	//测试排序
	@Test
	public void test3() {

		//1.获取stream对象
		Stream<Employee> stream = list.stream();
		
		//2.中间操作
		
		//sorted（）:根据元素本身的比较性实现自然排序
		
//		Stream<Employee> sorted = stream.sorted();
		//sorted(comparator):根据比较器实现定制排序
		
		//进阶1：使用匿名内部类
//		stream.sorted(new Comparator<Employee>(){
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return Double.compare(o2.getSalary(), o1.getSalary());
//			}
//			
//		});
		//进阶2：使用Lambda
		
		Stream<Employee> sorted2 = stream.sorted((o1,o2)->Double.compare(o2.getSalary(), o1.getSalary()));
		
		
		
		//3.终止操作
		
		sorted2.forEach(System.out::println);
	}
	//自定义规则实现：将员工转换成Stream类型
	public static Stream<Object> employeeToStream(Employee e){
		Stream<Object> of = Stream.of(e.getName(),e.getAge(),e.getSalary(),e.getSex());
		return of;
	}
	//案例3：映射
	//过滤：员工中包含字符“赵”的姓名
	@Test
	public void exec3() {
		list.stream().map(Employee::getName).filter(s->s.contains("赵")).distinct().forEach(System.out::println);;
		
		
	}
	//案例2：筛选与切片
	//过滤：年龄>30的员工中的 第2条——第4条数据
	@Test
	public void exec2() {
		list.stream().filter(t->t.getAge()>30).skip(1).limit(3).forEach(System.out::println);
		
		
	}
	//案例1：筛选与切片
	//过滤年龄>30&&性别=男&工资>100000
	@Test
	public void exec1() {
		
		list.stream().
		filter(t->t.getAge()>30).
		filter(t->t.getSalary()>100000).
		filter(t->t.getSex()=='男').
		forEach(System.out::println);

	}

}
