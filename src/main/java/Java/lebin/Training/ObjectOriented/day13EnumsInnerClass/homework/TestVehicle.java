package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.homework;

import java.util.Scanner;

/**
 * 四、：有一个交通工具接口类Vehicles，有work方法，有Horse类和Boat类分别实现Vehicles，
 * 创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat；有Person类，有name和Vehicles属性，
 * 
 * 在构造器中为两个属性赋值，实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具。
 * @author liulebin
 *
 */
public class TestVehicle {
	
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.println("路面情况：1.一般  2.大河 ");
		char key  = input.next().charAt(0);
		Vehicles v;
		if(key=='1')
			v = Factory.getHorse();
		else
			v=Factory.getBoat();
		Person p = new Person("唐曾",v);
		System.out.println(p);
	}

}
class Person{
	private String name;
	private Vehicles v;
	public Person(String name, Vehicles v) {
		super();
		this.name = name;
		this.v = v;
	}
	
	public void drive(){
		 v.work();
	}

	@Override
	public String toString() {
		return v.work();
	}
	
}

class Factory{
	/*与类的成员无关，定位为static*/
	public static Vehicles getHorse(){
		return new Horse();
	}
	public static Vehicles getBoat(){
		return new Boat();
	}
	
}
class Boat implements Vehicles{
	@Override
	public String work(){
		return "使用船过河";
		
	}
	
}
class Horse implements Vehicles{
	@Override
	public String work(){
		return "骑着白龙马上路啦";
		
	}
	
}
interface Vehicles{
	String work();
	
}