package Java.lebin.Training.ObjectOriented.day9Inheritance.demo1;

import Java.lebin.Training.ObjectOriented.day9Inheritance.bean.Computer ;
import Java.lebin.Training.ObjectOriented.day9Inheritance.bean.Teacher ;

/**
 * 此类用于演示对象的关联
 * @author liulebin
 *
 */
public class TestObjectRelation {
	
	public static void main(String[] args) {
		
		Teacher t = new Teacher();
		
		t.setName("大葱老师");
		
		Computer c=new Computer();
		c.setBrand("外星人");
		c.setPrice(20000);
		t.setComputer(c);
		
		System.out.println(t.getInfo());
	}

}
