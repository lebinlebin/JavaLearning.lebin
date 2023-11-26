package Java.lebin.Training.communication.homework;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Java.lebin.Training.communication.bean.Employee;
import Java.lebin.Training.communication.bean.EmployeeData;

/**
 * 定义好Employee类，包含姓名、年龄、工资、性别属性，并封装 定义一个List类，添加多个员工
 * 
 * 问题：针对定义好的员工的集合数据，有如下的一些需求，我们考虑如何完成？ 需求1：获取当前公司中员工年龄大于30的员工信息 需求2：获取公司中工资大于
 * 5000 的员工信息 需求3：获取性别为男的员工信息
 * 
 * 提示：是否可以使用Lambda表达式
 * 
 * @author liulebin
 *
 */
public class TestLambda3 {
	List<Employee> list;
	@Before
	public void before(){
		list= EmployeeData.getEmployees();
		
	}
	//进阶1：
	@Test
	public void test1() {
		
		
		List<Employee> employeeByAge = getEmployeeByAge(list);
		
		for (Employee employee : employeeByAge) {
			System.out.println(employee);
		}
		
		

	}

	// 需求1：获取当前公司中员工年龄大于30的员工信息
	public List<Employee> getEmployeeByAge(List<Employee> list) {

		List<Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (Employee employee : list) {
			if (employee.getAge() > 30) {
				datas.add(employee);
			}
		}
		return datas;

	}

	// 需求2：获取公司中工资大于 100000 的员工信息
	public List<Employee> getEmployeeBySalary(List<Employee> list) {

		List<Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (Employee employee : list) {
			if (employee.getSalary() > 100000) {
				datas.add(employee);
			}
		}
		return datas;

	}

	// 需求3：获取性别为男的员工信息

	public List<Employee> getEmployeeBySex(List<Employee> list) {

		List<Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (Employee employee : list) {
			if (employee.getSex() == '男') {
				datas.add(employee);
			}
		}
		return datas;

	}
	
	//-----------------------------------------------------------------------------
	
	//进阶2：
	
	@Test
	public void test2() {

//		需求1：获取当前公司中员工年龄大于30的员工信息
		
		List<Employee> emps1 = filterEmployees(list, t->t.getAge()>30);
//		需求2：获取公司中工资大于 100000 的员工信息
		List<Employee> emps2 = filterEmployees(list, t->t.getSalary()>100000);
//		需求3：获取性别为男的员工信息
		List<Employee> emps3 = filterEmployees(list, t->t.getSex()=='男');

	}
	
	public List<Employee> filterEmployees(List<Employee> list,MyPredicate<Employee> p){
		List<Employee> datas = new ArrayList<>();// 用于保存过滤好的员工信息

		for (Employee employee : list) {
			if (p.test(employee)) {
				datas.add(employee);
			}
		}
		return datas;
		
		
	}
}

interface MyPredicate<T>{
	boolean test(T t);
}
