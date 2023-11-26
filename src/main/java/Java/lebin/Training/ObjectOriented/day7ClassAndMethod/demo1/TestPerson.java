package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo1;
/**
 * 
 * 
 * 此类用于演示对象的创建和使用（属性和方法）
 * @author liyuting
 * 
 * 语法：
 * 一、创建对象：
 * 		类名  对象名 = new 类名();
 * 
 * 二、使用：
 * ①使用属性
 * 		对象名.属性名=值;(要求值和属性的类型必须一致或兼容)
 * 
 * ②使用方法
 * 		对象名.方法名();(相当于执行方法体中的每一句话)
 * 
 * 
 *
 */
public class TestPerson {
	
	public static void main(String[] args) {
		int a=10;
		//创建对象
		//语法：类名 对象名=new  类名();
		Person p1 = new Person();
		
		//为对象的属性赋值
		p1.name="赵敏";
		p1.age=2;
		p1.height=156.5;
		p1.weight=100;
		p1.gender='女';
		
		//打印对象的属性值
		System.out.println(p1.name+"\t"+p1.age);
		
		//调用对象的方法
		
		p1.eat();
		
		p1.study();

		
		
		
		
		
	}

}
