package Java.lebin.Training.ObjectOriented.DEMOTEST.exec7;

public class Teacher {

	public static void main(String[] args) {
		new Teacher("john");
	}
	String name ;
	public Teacher(String string) {
		this.name=string;
		System.out.println("构造器："+name);
	}
	static {
		System.out.println("嘿嘿");
	}
	static Teacher t = new Teacher("鸠摩智");
	{
		System.out.println("哈哈哈："+name);
	}
	static{
		System.out.println("呵呵");
	}
}
