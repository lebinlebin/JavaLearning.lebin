package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo4Final;
/**
 * 此类用于演示final关键字的特点
 * 
 * 1、修饰类
 * 如果用final修饰类，则该类变成了“太监类”，不能被继承
 * 代表类：String、Integer等
 * 2、修饰方法
 * 如果用final修饰方法，则该方法不能被重写，但可以被继承
 * 3、修饰属性和局部变量
 * ①如果修饰变量（属性和局部），该变量就变成了常量，一旦赋值，将不能更改！ ★
 * ②修饰属性，需要注意以下事项：
 * 		a、命名时最好遵循见名知义,且纯大写，提高代码的阅读性！
 * 		b、一般来讲static和final往往一起搭配修饰常量属性
 * 			两个修饰符的意思不冲突
 * 			调用比较方便
 * 			jvm对使用这两个修饰符搭配的属性，内部进行了优化
 * 
 * 		c、常量属性在声明时或构造器时必须初始化
 * 
 * ③基本类型的值，一旦更改，则就是更改值，不允许！
 *  引用类型的对象，如果更改属性值是允许的，但不能更改地址号！
 */
public  class TestFinal {
	public static void main(String[] args) {
		
//		Sub s = new Sub();
//		s.method();
		System.out.println(A.a);
//		System.out.println(A.b);

	}

}
class Sub extends A{
//	public final void method(){
//		
//	}
//	
}
 class A{
	 public static  int b = 100;
	 public static final int a = 100;
	 static{
		 System.out.println("A类被加载了！");
		 
	 }
	final String NAME;//常量属性
	
	public A(){
		
		NAME="john";
		
	}
	
	final double PI = 3.14;
	
	public void update(){
//		NAME="lucy";
	}
	public final void method(){
		
		
		final int i;
		i=10;
//		i++;
		System.out.println("method");
		
	}
}
 
 
 
 
 
 
 