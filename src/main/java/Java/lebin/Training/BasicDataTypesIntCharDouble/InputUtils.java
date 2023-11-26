package Java.lebin.Training.BasicDataTypesIntCharDouble; /**
 /**
 此类用于演示键盘输入语句


 Scanner类
 步骤：

 1、找到卖扫描仪的厂家

 import java.util.Scanner;//导包
 2、买一台扫描仪放家里
 Scanner input = new Scanner(System.in);//创建Scanner 类的对象
 3、使用扫描仪的扫描功能

 String name = input.next();//输入字符串

 */

import java.util.Scanner;//导包

class InputUtils
{
	public static void main(String[] args)
	{


		Scanner input = new Scanner(System.in);//创建Scanner 类的对象

		System.out.print("请输入姓名：");
		String name = input.next();//输入字符串
		System.out.print("请输入年龄：");
		int age  = input.nextInt();//输入整型
		System.out.print("请输入成绩：");
		double score = input.nextDouble();//输入浮点型
		System.out.print("请输入性别：");
		char gender = input.next().charAt(0);//输入字符型

		System.out.println("您输入的用户信息为：");
		System.out.println(name+"\t"+age+"\t"+score+"\t"+gender);



	}
}
