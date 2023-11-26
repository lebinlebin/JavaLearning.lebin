package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo3;

import java.io.Serializable;

/**
 * 此类用于演示接口的定义特点
 * @author liulebin
 * 
 * 语法：
 * 	【修饰符】interface 接口名{}
 * 
 * 特点：
 * 	1、接口中的属性全是静态常量，没有普通属性
 * 		默认修饰符是:public static final,可以省略
 *  2、接口中的方法全是抽象方法，没有普通方法（jdk8之前）
 *  	默认修饰符：public abstract 
 *  
 *  3、接口中没有构造器
 *  4、接口不能创建本身对象
 *  5、接口中可以没有任何属性和方法，空接口，称为标志性接口
 */
public class TestInterface1 {
	
	public static void main(String[] args) {
		
//		Fly fly = new Fly();
	}

}
interface Fly{
	 double PI=3.14;
	 void show();
	 String start(int a);
}