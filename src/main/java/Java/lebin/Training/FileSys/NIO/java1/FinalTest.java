package Java.lebin.Training.FileSys.NIO.java1;

public class FinalTest {
	public static void main(String[] args) {
		
	}
	//如果在方法的局部内部类的方法中，调用局部内部类所在方法中的局部变量，那么要求此局部变量声明声明为final.
	//在jdk8以前（不包含8）：需要显示的声明出final.
	//在jdk8中：可以不显示的声明 。
	public void method(){
		final int num = 10;
		
		//局部内部类
		class InnerClass{
			
			public void method1(){
				System.out.println(num);
			}
		}
		
	}
	
}
