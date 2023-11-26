package Java.lebin.Training.ObjectOriented.day9Inheritance.demo2;

/**
 * 
 * 此类用于演示this关键字的使用
 * @author liyuting
 * 
 * 概念：this代表的是当前类的对象，可以用于访问属性、方法、构造器
 * 语法：
 * 		访问属性：this.属性名=值;
 * 		访问方法：this.方法名(实参列表);
 * 		访问构造器：this(实参列表);
 * 			注意事项：只能放在构造器的第一句！
 * 总结：构造器的调用形式
 * 		①通过new关键字调用  【才会触发 对象的创建】
 * 		②通过this或super关键字调用【不会创建对象，目的就是为了执行里面的语句】
 * 好处：
 * 
 * 		1.当形参和成员变量（属性）重名时，默认访问的是形参，如果想访问成员变量，则必须添加this关键字去访问
 * 		2.调用本类中的成员变量或方法时，可以使用this提高代码的阅读性（写不写都可以）
 * 		3.当一个类中，需要互相调用构造器时，则必须通过this关键字去访问构造器
 * 
 * 		
 *
 */

public class TestThis {

}

class Animal{
	String name;
	int age;
	String color;
	public void show(){
//		this();
	}
	public Animal(){
		System.out.println("Animal的初始化操作");
	}
	public Animal(String name){
		this();
//		System.out.println("Animal的初始化操作");
		
		this.name=name;
		
	}
	public Animal(String name,int age){
		this(name);
//		System.out.println("Animal的初始化操作");
//		this.name=name;
		this.age=age;
	}
	
	
}

