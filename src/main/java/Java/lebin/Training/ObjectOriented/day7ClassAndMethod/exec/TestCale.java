package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.exec;

import java.util.Scanner;

public class TestCale {
	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		//创建计算器对象
		Cale c = new Cale();
		
		//为属性赋值
		System.out.println("请输入第一个整数：");
		c.a=input.nextInt();
		System.out.println("请输入第二个整数：");
		c.b=input.nextInt();
		
		//调用
		c.add();
		c.sub();
		c.mul();
		c.div();
	}

}
