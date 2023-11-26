package Java.lebin.Training.flowControl;


/*

此类用于演示单分支结构
*/
//案例1：如果成绩>90,则奖励棒棒糖

import java.util.Scanner;
class IfDemo1
{
	public static void main(String[] args)
	{
		int score = 100;
		//分支结构
		if(score>90){
			System.out.println("奖励棒棒糖");

		}


		System.out.println("哈哈哈");


	}
}
//编写程序，声明2个int型变量并赋值。判断两数之和，如果大于等于50，打印“hello world!”
class IfExec111
{
	public static void main(String[] args){
		int a = 10;
		int b = 8;
		if(a+b>=50){

			System.out.println("Hello World");


		}


	}
}

//编写程序，声明2个double型变量并赋值。判断第一个数大于10.0，且第2个数小于20.0，打印两数之和。

class IfExec2
{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.print("请输入第一个数字：");
		double num1 = input.nextDouble();
		System.out.print("请输入第二个数字：");
		double num2 = input.nextDouble();
		//分支结构

		if(num1>10.0&&num2<20.0){
			//打印两数之和。
			System.out.println(num1+num2);
		}


	}

}
//3)【选作】定义两个变量，判断二者的和，是否技能被3又能被5整除，打印提示信息
class IfExec3
{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入第一个数字：");
		int num1 = input.nextInt();
		System.out.print("请输入第二个数字：");
		int num2 = input.nextInt();
		int sum = num1+num2;//保存两个数的和
		if(sum%3==0&&sum%5==0){
			//打印提示信息
			System.out.println("能被3和5整除");

		}
	}


}