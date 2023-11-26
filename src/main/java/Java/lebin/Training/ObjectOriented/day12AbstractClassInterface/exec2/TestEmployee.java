package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.exec2;
/*
 * 此类用于练习抽象类和抽象方法
 * 编写一个Employee类，声明为抽象类，包含如下三个属性：name，id，salary。提供必要的构造器和抽象方法：work()。
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。

 */
public class TestEmployee {
	
	public static void main(String[] args) {
//		Employee emp = new Employee();
		
		Manager mgr = new Manager("john", 12, 100000, 900);
		mgr.work();
	}

}

class CommonEmployee extends Employee{

	public CommonEmployee(String name, int id, double salary) {
		super(name, id, salary);
	}

	@Override
	public void work() {
		System.out.println("员工的工作");
		
	}
	
	
	
}

class Manager extends Employee{
	private double bonus;

	
	public Manager(String name, int id, double salary,double bonus) {
		super(name,id,salary);
		this.bonus = bonus;
	}


	@Override
	public void work() {
		
		System.out.println("manager的管理工作");
		
	}


	@Override
	public String toString() {
		return super.toString()+"\t"+bonus;
	}
	
	
	
	
}



abstract class Employee{
	
	private String name;
	private int id;
	private double salary;
	public abstract void work();
	
	public Employee() {
		super();
	}
	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString(){
		return name+"\t"+id+"\t"+salary;
	}
}