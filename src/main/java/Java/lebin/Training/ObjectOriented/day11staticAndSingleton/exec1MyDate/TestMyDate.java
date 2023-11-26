package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.exec1MyDate;
/**
 * 编写MyDate类表示日期，
 * 类中包含属性day、month和year，提供必要的方法，并覆盖equals方法以比较年、月、日是否相同,重写toString返回年月日的信息。Xx年xx月xx日
在TestDate类的main方法中，创建两个日期均为2014年10月1日的MyDate对象，比较它们是否相同。通过toString方法打印两个对象日期

 * @author liulebin
 *
 */
public class TestMyDate {
	public static void main(String[] args) {
		MyDate d1 = new MyDate(2018, 8, 8);
		MyDate d2 = new MyDate(2018, 8, 8);
		System.out.println(d1.equals(d2));//true
		System.out.println(d1);
		
		d1=null;//变成无用对象
		
		System.gc();
		
	}

}
class MyDate{
	
	
	private int year;
	private int month;
	private int day;

	/**
	 * ctrl +o 快速重写父类方法
	 * @throws Throwable
	 */
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("MyDate对象被回收了");
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!(obj instanceof MyDate))
			return false;
		MyDate date = (MyDate) obj;
		
		return date.year==this.year&&date.month==this.month&&date.day==this.day;
	}
	/**
	 * 功能：重写toString方法，用于返回对象的属性信息
	 */
	@Override
	public String toString(){
		return year+"年"+month+"月"+day+"日";
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
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
}