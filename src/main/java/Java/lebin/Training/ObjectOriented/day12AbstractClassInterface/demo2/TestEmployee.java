package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo2;
/*
此类用于演示抽象类是否也可以用在多态上！
	对象的转型：
			向上转型
				父类 引用名 = new 子类（）；
			向下转型
				子类 名 =（子类）父类的引用;
				
	多态的应用：
			多态数组
			多态参数
	
 */
public class TestEmployee {
	
	public static void main(String[] args) {
		
		//向上转型
		Employee e = new Manager("", 1, 111, 100);
		e.work();//编译看左边  运行看右边
		
		//向下转型
		Manager m = (Manager) e;
		m.setBonus(100);
		m.work();
		
		
		Employee[] emps = new Employee[2];
		emps[0]= e;
		
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

	
	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}


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