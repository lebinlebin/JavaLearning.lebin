package Java.lebin.Training.ObjectOriented.DEMOTEST.demo8;
/**
 * 此类用于演示抽象类和抽象方法的特点和使用
 * 语法：
 * [访问修饰符] abstract class 类名{}
 * 特点：
 * ①抽象类不能创建本类的对象
 * ②抽象类有构造器，供子类调用
 * ③抽象类中可以有哪些成员？
 * 任意成员（包含普通成员和抽象方法）
 * ④抽象类中也可以没有抽象方法
 * ⑤不能使用final修饰抽象类，因为和继承的意义相悖
 * 
 * ⑥抽象类的扩展
 * 普通子类 继承抽象类要求必须实现里面所有抽象方法
 * 抽象子类继承抽象类不用实现里面的抽象方法
 * 
 * 
 * 抽象方法：
 * 
 * 语法：
 * 
 * 【访问修饰符】 abstract 返回类型 方法名(参数列表);
 * 
 * 特点：
 * 
 * 	①没有方法体，只有方法签名，使用分号结尾
 * 
 * 	②修饰符不能是final、static或private中的任何一个
 * 因为这些修饰符和重写的意义相悖
 * 
 * 	③抽象方法只能出现在抽象类或接口中！
 * 
 * 
 *
 *
 */
public class TestAbstract1 {
	
	public static void main(String[] args) {
		//不足2：可以创建父类对象，没有任何意义
//		Animal ani = new Animal();
//		ani.eat();
		
		
		
	}

}
 abstract class Animal{
	String name;
	int age;
	public String say(){
		return name;
	}
	
	public Animal(){
		
	}
	//不足1.必须写大括号
//	static abstract void eat();
}
abstract class Dog extends Animal{
	
	
}
class Cat extends Animal{

	public void eat() {
		
	}
	
}








