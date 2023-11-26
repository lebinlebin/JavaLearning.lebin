package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo1;
/*
 *此类用于演示初始化块的特点2：
 *静态初始化块只能被调用一次，因为类只能加载一次。
 *普通初始化块可以被调用多次，因为可以创建多个对象
 */
public class TestInit2 {
	
	public static void main(String[] args) {
//		System.out.println(InitDemo2.a);//加载类
		new InitDemo2();
		new InitDemo2();
		new InitDemo2();
		new InitDemo2();
		new InitDemo2();
		
	}

}
class InitDemo2{
	static int a =100;
	{
		
		System.out.println("我是普通初始化块");
	}
	static{
		System.out.println("我是静态初始化块");
	}
}