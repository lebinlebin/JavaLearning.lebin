package Java.lebin.Training.ObjectOriented.DEMOTEST.demo4.other;

import Java.lebin.Training.ObjectOriented.DEMOTEST.demo4.Person;

public class Son extends Person {

	
	public void show(){
		Person p = new Person();
//		System.out.println(p.weight);//其他包不能访问protected方法
		System.out.println(weight);
//		System.out.println(age);
		System.out.println(p.hobby);
		System.out.println(hobby);
		
	}
}
