package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.homework;

import java.util.Scanner;

//实验说明：
//（1）定义一个Employee类，该类包含：
//	private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
//	abstract方法earnings()；toString()方法输出对象的name,number和birthday。
//	
//（2）MyDate类包含:
//	private成员变量month,day,year；
//	toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
//	
//（3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：
//	private成员变量monthlySalary；
//实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输出员工类型信息及员工的name，number,birthday。
//	
//（4）参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
//	private成员变量wage和hour；
//	实现父类的抽象方法earnings(),该方法返回wage*hour值；toString()方法输出员工类型信息及员工的name，number,birthday。
//	
//（4）定义PayrollSystem类，
//创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
//利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
//当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。

public class TestEmployee {
	
	public static void main(String[] args) {
		
		Employee[] emps = new Employee[3];
		emps[0] = new HourlyEmployee("翠花", "S001", new MyDate(1990,2,1), 100, 50);
		emps[1] = new SalariedEmployee("慕容复", "T001", new MyDate(1990,2,1), 20000);
		emps[2] = new HourlyEmployee("秋香", "S002", new MyDate(1980,5,13), 98, 100);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入当前月份：");
		int month = input.nextInt();
		
		
		for (int i = 0; i < emps.length; i++) {
			//获取员工的生日的月份
			int empBirth = emps[i].getBirthday().getMonth();
			double salary=emps[i].earnings();
			if(empBirth==month){//本月生日
				salary+=100;
				
			}
			System.out.println(emps[i]+",工资："+salary);
		}
	}

}
class HourlyEmployee extends Employee{
	private double wage;//时薪
	private double hour;//小时数

	/**
	 * 构造函数
	 * @param name
	 * @param number
	 * @param birthday
	 * @param wage
	 * @param hour
	 */
	public HourlyEmployee(String name, String number, MyDate birthday, double wage, double hour) {
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getHour() {
		return hour;
	}
	public void setHour(double hour) {
		this.hour = hour;
	}
	@Override
	public double earnings() {
		return wage*hour;
	}
	@Override
	public String toString() {
		return "【类型：HourlyEmployee】"+super.toString();
	}
	
}
 
class SalariedEmployee extends Employee{
	public SalariedEmployee(String name, String number, MyDate birthday,double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary=monthlySalary;
		
	}

	private double monthlySalary;

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double earnings() {
		return monthlySalary;
	}

	@Override
	public String toString() {
		return "【类型：SalariedEmployee】"+super.toString();
	}
	
	
}
abstract class Employee{
	private String name;
	private String number;
	private MyDate birthday;
	public abstract double earnings();//抽象方法
	@Override
	public String toString(){
		return name+"的工号："+number+",生日："+birthday.toDateString();
	}
	public Employee(String name, String number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	
}
class MyDate{
	private int year,month,day;

	public String toDateString(){
		return year+"年"+month+"月"+day+"日";
	}
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}
