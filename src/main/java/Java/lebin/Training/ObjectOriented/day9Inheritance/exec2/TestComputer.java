package Java.lebin.Training.ObjectOriented.day9Inheritance.exec2;

/**
 编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回Computer的详细信息
编写PC子类，继承Computer类，添加特有属性和方法
编写NotePad子类，继承Computer类，添加特有属性和方法
编写Test类，在main方法中创建PC和NotePad对象，分别访问对象中特有的属性、方法，以及从Computer类继承的属性和方法并打印输出。
改写Computer类，将所有属性声明为private，getDetails方法用于返回Computer的详细信息
在PC子类中直接访问继承的私有属性，结果如何？
在Computer类中对私有属性添加公有的get/set方法，在PC子类中通过这些公有的get/set方法访问私有属性，结果如何？

 * @author liyuting
 *
 */
public class TestComputer {
	public static void main(String[] args) {
		NotePad np = new NotePad();
		np.color="黄色";
		np.ram="";
		np.disk=100;
		System.out.println(np.getDetails());
		
	}

}
class NotePad extends Computer{
	String color;
}
class PC extends Computer{
	public void show(){
		System.out.println("我是一个PC机");
	}
	
}
class Computer{
	private String cpu;
	protected String ram;
	int disk;
	public String getDetails(){
		return cpu+"\t"+ram+"\t"+disk;
	}
	
}
