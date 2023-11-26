package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.innerClass;
/**
 * 此类用于演示内部类：局部内部类的特点和使用
 * @author liulebin
 * 特点：
 * ①类中可以有五大成员,但不能有静态成员（和类的加载顺序有关）
 * ②不能有访问修饰符和static修饰符,作用域：仅仅是定义它的方法或代码块中，而且遵循前向引用
 * ③互访原则
 * 		内部类————>外部类
 * 			直接访问，包含私有的
 * 
 * 		外部类————>内部类
 * 			只能在作用域范围内，通过创建对象并访问(包含私有的！)
 * 			语法：new Inner（）.方法();
 * 			
 * 		细节：局部内部类可以访问外部类的局部变量，但只能访问，不能更新！（只能访问外部类的final修饰的局部变量！）
 * 			原因：局部内部类的生命周期>局部变量生命周期，所以不能直接访问一个可能已经消亡的变量。于是将局部变量复制了一个拷贝让局部内部类使用，
 * 				但不能更新，因为如果更新，会导致两个变量的值不一致！
 * 				jdk7:要求局部内部类中访问的局部变量必须显式的声明final修饰符
 * 				jdk8:局部内部类中访问的局部变量不用显式的声明final修饰符
 * 		
 * 	
 *
 */
public class TestInner3 {
	public static void main(String[] args) {
		Outer3 outer3 = new Outer3();
		outer3.print();
//		new outer3
	}

}

class Outer3{
	
	private String name;
	public void print(){
//		new Inner3().show();//无法访问
		Object x = method();
		System.out.println(x);
		
	}
	public Object method(){
		 int  age =99;
		 class Inner3{
			 private String color;
			public void show(){
//				System.out.println(name);
//				name="john";
				System.out.println(age);
//				age++;
			}
			
		}
		/**
		 * 外部类————>内部类
		 * 只能在作用域范围内，通过创建对象并访问(包含私有的！)
		 * 语法：new Inner（）.方法();
		 */
		 Inner3 i = new Inner3();
		 i.show();
		 return i;
	}
}