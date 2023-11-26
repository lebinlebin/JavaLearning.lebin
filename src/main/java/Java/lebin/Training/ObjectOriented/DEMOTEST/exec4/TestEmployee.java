package Java.lebin.Training.ObjectOriented.DEMOTEST.exec4;
/**
 * 定义员工类Employee，包含姓名和月工资，以及计算年工资getAnnual的方法。
 * 
 * 普通员工和经理继承了员工，经理类多了奖金bonus属性和管理manage方法，普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法

定义员工管理类EmployeeSys，功能1：要求可以实现打印每个员工年工资；功能2：要求可以调用员工的工作或管理方法
并在测试类中调用这些功能

 * @author liulebin
 *
 */
public class TestEmployee {
	
	public static void main(String[] args) {
		EmployeeSys s = new EmployeeSys();
		s.testWork(new Manager("张三丰", 1000, 900));
		s.testWork(new CommonEmployee("宋青书", 100));
	}

}
class EmployeeSys{
	//功能1：要求可以实现打印每个员工年工资
	public void printAnnual(Employee e){
		System.out.println(e.getAnnual());
	}
	
	public void testWork(Employee e){
		if(e instanceof Manager){
			Manager m = (Manager)e;
			m.manage();
		}else if(e instanceof CommonEmployee){
			CommonEmployee ce = (CommonEmployee) e;
			ce.work();
		}
	}
	
	
}
class Manager extends Employee{
	private double bonus;

	
	public Manager(String name, double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void manage(){
		System.out.println("经理的管理工作");
	}
	@Override
	public double getAnnual(){
		return super.getAnnual()+bonus;
	}
	
}
class CommonEmployee extends Employee{

	public CommonEmployee(String name, double salary) {
		super(name, salary);
	}
	
	public void work(){
		System.out.println("员工的工作");
	}
	
	
}
class Employee{
	private String name;
	private double salary;
	
	public double getAnnual(){
		return salary*12;
	}
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}