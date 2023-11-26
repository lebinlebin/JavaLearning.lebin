package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo1;
/*
 * 补充：类的加载时机
 * 	1、创建对象
 * 	2、调用类的静态成员
 * 	3、加载子类
 * 
 * 此类用于演示初始化块的特点1：
 * 普通初始化块和静态初始化块的调用语法：
 * 
 * 普通初始化块：创建对象时，隐式调用
 * 静态初始化块：加载类时，隐式调用
 */
public class TestInit1 {
	
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*40+1));
		System.out.println(InitDemo1.a);//加载类
		new InitDemo1();
	}

}
class InitDemo1{
	static int a =100;
	
	
	
	{
		
		System.out.println("我是普通初始化块");
	}
	static{
		System.out.println("我是静态初始化块");
	}
}