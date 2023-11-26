package Java.lebin.Training.ObjectOriented.day9Inheritance.demo2;
/**
 * 此类用于演示构造器的特点和使用
 * 概念：构造器又称为构造方法。属于类中的第三大成员。本质上就是一个方法，只是没有返回类型，而且不是通过对象显式调用的。但有方法体
 * 语法：
 * 
 * 		访问修饰符		方法名(参数列表){
 * 			方法体;
 * 
 * 		}
 * 注意：
 * 		1、没有返回值
 * 		2、方法名必须和当前类名相同
 * 
 * 好处：
 * 
 * 		1、用于创建对象的
 * 
 * 		2、可以进行初始化操作，一定程度上提高了代码的重用性
 * 
 * 特点：
 * 		1、每个类都有构造器，如果没有，则没办法创建该类对象
 * 		2、如果类中没有显式的声明构造器，则系统将默认提供一个无参的构造器
 * 		3、如果类中显式的声明了构造器，则系统将不再提供构造器
 * 		4、对于任何一个对象来说，构造器只可能调用一次
 * 
 * 		5、一个类中允许构造器重载
 * 
 *
 */
public class TestConstructor {
	
	public static void main(String[] args) {
		
		//没有使用有参构造器之前
//		Person p = new Person();//创建对象
//		p.name="张翠山";
//		p.age=2;
//		p.height=180;
//		p.gender='男';;
//		p.weight=180;
//		
//		Person p = new Person();//创建对象
//		p.name="张翠山";
//		p.age=2;
//		p.height=180;
//		p.gender='男';;
//		p.weight=180;
//		
//		
//		Person p = new Person();//创建对象
//		p.name="张翠山";
//		p.age=2;
//		p.height=180;
//		p.gender='男';;
//		p.weight=180;

		//使用有参构造器
		
//		Person p = new Person("张翠山",12,128,'男',180);
//		Person p2 = new Person("张翠山",12,128,'男',180);
//		Person p3 = new Person("张翠山",12,128,'男',180);
		
		Person p1 = new Person();
		System.out.println(p1.getInfo());
		
		Person p2 = new Person("john",20);
		System.out.println(p2.getInfo());
		
		
	}

}

class Person{
	
	String name;
	int age;
	public String getInfo(){
		return name+"\t"+age;
	}
	
	public Person(){
		age=18;
		
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	
	}
	
}













