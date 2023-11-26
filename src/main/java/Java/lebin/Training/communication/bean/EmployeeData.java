package Java.lebin.Training.communication.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理类，里面提供一个方法，返回存储多个元素的list集合
 * @author liyuting
 *
 */
public class EmployeeData {
	
	public static List<Employee> getEmployees(){
		
		List<Employee> list = new ArrayList<>();	
		
		list.add(new Employee("李易峰",23,100000,'男'));
		list.add(new Employee("孙红雷",43,300000,'男'));
		list.add(new Employee("赵丽颖",26,260000,'女'));
		list.add(new Employee("黄渤",38,980000,'男'));
		list.add(new Employee("易烊千玺",18,80000,'男'));
		list.add(new Employee("林依晨",33,90000,'女'));
		list.add(new Employee("郑爽",27,560000,'女'));
		list.add(new Employee("张家辉",51,1000000,'男'));
		list.add(new Employee("关晓彤",20,70000,'女'));
		list.add(new Employee("杜鹃",37,1000000,'女'));
		list.add(new Employee("赵丽颖",26,260000,'女'));
		list.add(new Employee("黄渤",38,980000,'男'));
		list.add(new Employee("易烊千玺",18,80000,'男'));
		
		
		
		return list;
		
	}
	
	

}
