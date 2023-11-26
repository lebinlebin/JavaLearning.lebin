package Java.lebin.Training.ObjectOriented.DEMOTEST.demo9;
/**
 * 此类用于演示接口的扩展特点
 * @author liulebin
 * 1.一个类(包含普通类和抽象类)可以实现多个接口，语法如下：
 * [abstract] class MyClass implements 接口1，接口2{}
 * 
 * 2.接口可以继承其他接口,通过extends关键字，而且是多继承的，语法如下：
 * 
 * interface MyInter extends 接口1，接口2{}
 * 
 * 3.一个类(包含普通类和抽象类)可以既继承其他类，又实现多个接口，语法如下：
 * [abstract] class MyClass extends 类名  implements 接口1，接口2{}
 * 
 * 
 * 4.如果普通类实现接口，则要求实现里面全部的抽象方法（普通类中不允许有抽象方法）
 *   如果抽象类实现接口，则不用实现里面全部的抽象方法
 *   
 *   
 *   类和类之间 通过extends关键字，实现单继承关系，
 *   接口和接口之间 通过extends关键字，实现多继承关系
 *   类和接口之间通过implements关键字，实现 多实现关系
 */
public class TestInterface2 {
	
	public static void main(String[] args) {
	}

}
class MyClass3 implements MyInter{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String swim(int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
	
}
class MyClass2 extends  ASub1 implements Study,Swim{

	@Override
	public String swim(int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}}


interface Study{
	void study();
}
interface Swim{
	
	String swim(int a);
}

interface MyInter extends Study,Swim{
	
	String name="";
	void method();
}
abstract class ASub1 implements Study,Swim{
	
	
}
class Sub1 implements Study,Swim{

	@Override
	public void study() {
		
		System.out.println("学习");
		
	}

	@Override
	public String swim(int a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
