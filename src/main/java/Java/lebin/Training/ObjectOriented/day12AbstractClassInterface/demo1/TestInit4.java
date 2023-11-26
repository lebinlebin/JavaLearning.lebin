package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo1;
/*
 * 此类用于演示初始化块的特点4：
 * 如果一个类中有普通属性初始化、静态属性初始化、普通初始化块、静态初始化块、构造器，则执行顺序：
 * 静态属性初始化|静态代码块——>普通属性初始化|普通代码块——>构造器
 * 同一个类别的属性初始化和代码块的执行顺序取决于定义的先后顺序
 * 
 * 
 */
public class TestInit4 {
	
	public static void main(String[] args) {
		InitDemo4 id = new InitDemo4();
	}

}
class InitDemo4{
	
	
	public InitDemo4(){
		System.out.println("我是构造器");
	}
	String a=msg("普通属性初始化1");
	
	public static String msg(String info){
		System.out.println(info);
		return info;
	}
	static{
		System.out.println("静态初始化块2");
	}
	static String b=msg("静态属性初始化1");
	
	{
		System.out.println("我是普通初始化块1");
	}
	
	String c=msg("普通属性初始化2");
	
	
	{
		System.out.println("我是普通初始化块2");
	}
	static String d=msg("静态属性初始化2");
	
	
	static{
		System.out.println("静态初始化块1");
	}
	
	
	
}