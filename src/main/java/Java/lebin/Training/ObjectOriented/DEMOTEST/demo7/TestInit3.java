package Java.lebin.Training.ObjectOriented.DEMOTEST.demo7;
/*
 * 此类用于演示初始化块的特点3：
 * 一个类中允许有多个普通初始化块和静态初始化块，则执行顺序：
 * 静态初始化块————普通初始化块
 * 同一个类别的初始化块，执行顺序取决于定义的先后顺序
 */
public class TestInit3 {
	
	public static void main(String[] args) {
//		System.out.println(InitDemo2.a);//加载类
		new InitDemo3();//加载+创建对象
	}

}
class InitDemo3{
	{
		
		System.out.println("我是普通初始化块1");
	}
	static{
		System.out.println("我是静态初始化块1");
	}
	
	{
		
		System.out.println("我是普通初始化块2");
	}
	{
		
		System.out.println("我是普通初始化块3");
	}
	static{
		System.out.println("我是静态初始化块2");
	}
	static{
		System.out.println("我是静态初始化块3");
	}
	
}












