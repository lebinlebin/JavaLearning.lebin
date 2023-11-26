package Java.lebin.Training.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * 通过反射获取对应类 的对象
 * @author liulebin
 * 方式一：调用对应类的无参构造器
 * 要求：必须有无参构造
 * Class c =Class.forName(全类名);
 * Object o = c.newInstance();
 *
 *
 	方式二：调用对应类的指定构造器
 * Class c =Class.forName(全类名);
 * 步骤1：
 * Constructor con = c.getDeclaredConstructor(Class...c);
 * 步骤2：
 * con.setAccessible(true);
 * 步骤3：
 * con.newInstance(Object..para);
 * 
 *
 */

public class TestReflect2 {
	
	//方式1：通过调用Class类的newInstance方法【推荐使用】
	/*
	 * 前提：对应类中必须有无参构造器！
	 */
	@Test
	public void test1() throws Exception {
		
		Class c = Class.forName("Java.lebin.Training.reflect.Student");
		
		Object o = c.newInstance();
		
		System.out.println(o);
		

	}
	
	//方式2：通过调用Constructor的newInstance方法【不推荐使用】
	@Test
	public void test2() throws Exception {
		Class c = Class.forName("Java.lebin.Training.reflect.Student");
		//protected Student(String name, int age, double score, int id) {
		Constructor constructor = c.getDeclaredConstructor(String.class,int.class,double.class,int.class);
		//暴力破解
		constructor.setAccessible(true);
		Object o = constructor.newInstance("john",23,98.5,100);
		System.out.println(o);
	}

}
