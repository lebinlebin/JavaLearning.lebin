package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.TestInterfacejava8;
/**
 *  此类用于演示java8对接口的改进
 * @author liulebin
 *
 */
public class TestInterface {
	
	public static void main(String[] args) {
		
//		MyClass myc = new MyClass();
//		myc.method2("john");
//		A.method1(1, 2);
		
		Son s = new Son();
		s.method2("john");
				
		
	}

}
class MyClass implements A{

	@Override
	public void fun1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fun2(int a, int b) {
		// TODO Auto-generated method stub
		
	}
	static String method1(int a,int b){
		 System.out.println("我是接口中的静态方法");
		 return a+"\t"+b;
	}
	@Override
	public  void method2(String str){
		 System.out.println("我是实现类中的方法，对接口的默认方法的重写"+str);
	}
	
}
class Son extends Super implements A{

	@Override
	public void fun1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fun2(int a, int b) {
		// TODO Auto-generated method stub
		
	}
	
}
class Son2 implements A,B{

	@Override
	public void fun1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fun2(int a, int b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2(String str) {
//		A.super.method2(str);
		
	}
	
}
class Super{
	public void method2(String str){
		System.out.println("我是父类 的方法");
	}
}
interface B{
	void fun1();
	//默认方法：
		public default void method2(String str){
			 System.out.println("我是B接口中的默认方法："+str);
		}
}
interface A{
	void fun1();
	void fun2(int a, int b);
	
//	静态方法：
	 static String method1(int a, int b){
		 System.out.println("我是接口中的静态方法");
		 return a+"\t"+b;
	}

//默认方法：
	public default void method2(String str){
		 System.out.println("我是A接口中的默认方法："+str);
	}
}