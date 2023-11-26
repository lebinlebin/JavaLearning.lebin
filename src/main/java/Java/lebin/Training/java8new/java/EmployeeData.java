package Java.lebin.Training.java8new.java;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
	
	public static List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(1001, "马化腾", 34, 6000.32));
		list.add(new Employee(1002, "马云", 12, 9876.32));
		list.add(new Employee(1003, "刘强东", 33, 3000.32));
		list.add(new Employee(1004, "雷军", 66, 7657.32));
		list.add(new Employee(1005, "李彦宏", 65, 5555.32));
		list.add(new Employee(1006, "俞敏洪", 22, 2333.32));
		
		return list;
	}
	
}
