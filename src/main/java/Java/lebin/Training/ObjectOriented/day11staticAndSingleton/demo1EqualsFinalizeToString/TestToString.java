package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo1EqualsFinalizeToString;

import Java.lebin.Training.ObjectOriented.day11staticAndSingleton.bean.Person;

/**
 * 此类用于演示Object类的常见方法：toString方法
 * @author liulebin
 * 
 * 
 *
 */
public class TestToString {
	
	public static void main(String[] args) {
		
		Person p = new Person("张无忌",23);
//		System.out.println(p.getInfo());
//		System.out.println(p.toString());
		Person p2 = new Person("张无忌",23);
//		System.out.println(p2.toString());
//		System.out.println(p2.getInfo());
		
		System.out.println(p);
		String details = "hello:"+p;
		System.out.println(details);
		
		String s="john";
		System.out.println(s.toString());
		
		
		
	}

}
