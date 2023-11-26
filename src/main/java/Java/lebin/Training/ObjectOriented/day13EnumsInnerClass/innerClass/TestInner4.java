package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.innerClass;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 此类用于演示内部类：匿名内部类的特点和使用
 * @author liulebin
 * 
 * 语法：
 * 	new 类名或接口名(参数){
 * 
 * 		类体
 * 	}
 *  功能：创建了一个匿名内部类&创建了一个该类对象
 *  
 *  示例：
 *  
 *  new  A(){
 *  	//类体
 *  }
 *  
 *  创建A的子类&创建A的子类对象
 *  
 *  对比：
 *  new A(); 创建A本类的对象
 *  
 *  特点：
 *  
 *  ①类中可以有除了构造器之外的其他成员（属性、方法、初始化块、内部类），不可以有静态成员！
 *  ②不能添加访问修饰符和static，作用域：仅仅在定义它的方法或代码块中使用，并且遵循前向引用的特点！
 *  
 *  ③互访原则：
 *  内部类——————>外部类的成员
 *  	直接访问，包含私有的成员
 *  
 *  外部类——————>内部类的成员
 *  	只能在作用域内，通过匿名内部类的对象去访问，包含私有的成员
 *  	语法：父类或接口名  引用名 = 匿名内部类对象;
 *  		引用名.方法();
 *  
 *  
 *  细节：匿名内部类可以访问外部类的局部变量，但只能读取，不能更新！（只能访问外部类的final修饰的局部变量！）
 * 			原因：局部内部类的生命周期>局部变量生命周期，所以不能直接访问一个可能已经消亡的变量。于是将局部变量复制了一个拷贝让局部内部类使用，
 * 				但不能更新，因为如果更新，会导致两个变量的值不一致！
 * 				jdk7:要求局部内部类中访问的局部变量必须显式的声明final修饰符
 * 				jdk8:局部内部类中访问的局部变量不用显式的声明final修饰符
 * 
 * 
 * 应用场景：当做接口的实例作为实参传递给方法！
 * 	
 * 	
 *  
 */
public class TestInner4 {
	public static void main(String[] args) {
//		method(new Fly());//不能执行
		method(new MyClass());//方式一：传统的方式
		//方式二：匿名内部类
		method(new Fly(){
			@Override
			public void fly() {
				System.out.println("我要飞啊飞");
			}
		});
		
		//代表示例1：  传递参数为一个接口； Comparator为一个接口
		TreeSet set = new TreeSet(new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		//代表示例2：
		Thread t= new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		});
		
		
	}
	
	public static void method(Fly a){
		a.fly();
	}
}
class MyClass implements Fly{
	@Override
	public void fly() {

	}

}
class Outer4{
	private String name;
	public void method(){
		int i=999;
		//定义匿名内部类
		Fly a =new Fly(){
			class Inner{}
			 String color;
			public void show(){
				System.out.println(name);
				System.out.println(i);
//				i++;
			}
			{
			}
			@Override
			public void fly() {
				// TODO Auto-generated method stub
			}
		};
		a.fly();
	}
}

interface Fly{
	void fly();
}