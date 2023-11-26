package Java.lebin.Training.communication.exec;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;
import Java.lebin.Training.communication.bean.EmployeeData;

/*
 * 案例1：筛选出工资>5000的并且按工资逆序排序后，第3条————第6条数据
	
案例2：筛选出姓名中长度>2的员工
案例3：筛选出工资>15000的前三个
练习：获取员工姓名长度大于2的员工的姓名。

 */
public class TestStream {
	List<Employee> list;
	@Before
	public void before(){
		 list = EmployeeData.getEmployees();
	}
	//案例4：获取员工姓名长度大于2的员工的姓名。
	@Test
	public void test4() {
		list.stream().map(Employee::getName).filter(s->s.length()>2).forEach(System.out::println);
	}
	
	
	//案例3：筛选出工资>15000的前三个
	@Test
	public void test3() {

		list.stream().filter(e->e.getSalary()>15000).limit(3).forEach(System.out::println);;
	}
	//案例2：筛选出姓名中长度>2的员工
	@Test
	public void test2() {
		
		list.stream().filter(e->e.getName().length()>2).forEach(System.out::println);

	}
	//案例1：筛选出工资>5000的并且按工资逆序排序后，第3条————第6条数据
	@Test
	public void test1() {
		
		list
		.stream()
		.filter(e->e.getSalary()>5000)
		.sorted((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary()))
		.skip(2).limit(4).forEach(System.out::println);

	}

}
