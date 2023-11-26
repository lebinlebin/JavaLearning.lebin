package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo2;
/**
 * 
 * @author liyuting
 * 此类用于演示类的成员：属性
 * 
 * 特点：
 * 1、属性的类型可以为任意类型，包含基本类型和引用类型
 * 2、每个对象的属性是独立的。其中一个对象对其属性进行更改，不影响另外一个
 * 3、属性的定义语法和使用，同变量，也就是本质上就是变量
 * 
 * 变量根据作用域不同，可以分为两类：全局变量和局部变量
 * 变量的作用域：也就是变量的作用范围，根据变量定义的位置决定的，一般是指包含变量定义的最近的大括号
 * 
 * 全局变量：作用域为整个类体，也就是属性或成员变量
 * 局部变量：作用域为包含它的方法或代码块中，也就是除了属性，其他的变量都是局部变量
 * 
 * 			作用域					变量重名					存储位置		生命周期	默认值           访问可见性         修饰符
 * 全局变量	较大，整个类体				两个全局不能重名			堆			较长		有		本类以及其他类       √
 * 																					
 * 局部变量	较小，方法或代码块			两个局部有交集也不能重名，		栈			较短		                本类的方法或代码块   ×
 * 									但一个全局一个局部可以重名
 * 									遵循就近原则
 * 
 *
 */
public class TestField {
	public static void main(String[] args) {
		int i;
		Car c1 = new Car();
		c1.name="BMW118i";
		c1.tm=new TempratureMachine();
		c1.a=9;
		
	
		
		Car c2 = new Car();
		c2.name="沃尔沃";
		
		c2.name="夏利";

		System.out.println(c1.name);
		System.out.println(c2.name);
		
		
		
	}

}

class Car{
	public String name;
	TempratureMachine tm;
	
	int a=999;
	
	public void start(){
		int  a = 10;
		
		System.out.println(a);
		
		
		for(int i=0;i<10;i++){
			if(i==9){
				int b=10;
				System.out.println(b);
			}
			
		}
		
		
	}
	
	public void stop(){
		System.out.print(a);
		
		
	}
	
}













class TempratureMachine{
	
}