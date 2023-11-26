package Java.lebin.Training.ObjectOriented.DEMOTEST.demo7;
/*
 * 此类用于演示初始化块的特点5：
 * 如果父子类中都有普通属性初始化、静态属性初始化、普通初始化块、静态初始化块、构造器，
 * 则执行顺序：
 * 爷爷类的静态属性初始化|静态代码块——>父类的静态属性初始化|静态代码块——>子类的静态属性初始化|静态代码块——>
 * 爷爷类的普通属性初始化|普通代码块——>爷爷类的构造器——>父类的普通属性初始化|普通代码块——>父类的构造器——>子类的普通属性初始化|普通代码块——>子类的构造器
 *  同一个类别的属性初始化和代码块的执行顺序取决于定义的先后顺序
 */
public class TestInit5 {
	
	public static void main(String[] args) {
		InitDemo5 id = new InitDemo5();
	}
}
class Grand{
	public Grand(){
		
//		System.out.println("爷爷类的普通代码块");
		System.out.println("我是爷爷类的构造器");
	}
	String a=fun("爷爷类的普通属性初始化");
	
	public static String fun(String info){
		System.out.println(info);
		return info;
	}
	static{
		System.out.println("爷爷类的静态代码块");
	}
	
	{
		System.out.println("爷爷类的普通代码块");
	}
	
	
	static String d=fun("爷爷类的静态属性初始化");
}
class Father extends Grand{
	public Father(){
//		System.out.println("爷爷类的普通代码块");
		System.out.println("我是爷爷类的构造器");
//		System.out.println("父类的普通代码块");
		System.out.println("我是父类的构造器");
	}
	String a=method("父类的普通属性初始化");
	
	public static String method(String info){
		System.out.println(info);
		return info;
	}
	static{
		System.out.println("父类的静态代码块");
	}
	
	{
		System.out.println("父类的普通代码块");
	}
	
	
	static String d=method("父类的静态属性初始化");
	
}
class InitDemo5 extends Father{
	public InitDemo5(){
		System.out.println("我是子类的构造器");
	}
	String a=msg("子类的普通属性初始化");
	
	public static String msg(String info){
		System.out.println(info);
		return info;
	}
	static{
		System.out.println("子类的静态代码块");
	}
	
	{
		System.out.println("子类的普通代码块");
	}
	
	
	static String d=msg("子类的静态属性初始化");
	
	
}