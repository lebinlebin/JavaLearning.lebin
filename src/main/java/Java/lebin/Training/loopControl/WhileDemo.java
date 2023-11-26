package  Java.lebin.Training.loopControl;
/*
此类用于演示while循环结构的特点和使用

*/


import java.util.Scanner;
//案例：打印100遍“我最帅”
class WhileDemo
{
	public static void main(String[] args)
	{

		int i = 1;

		while(i<=100){
			//循环操作
			System.out.println("我最帅！");

			i++;//i=i+1;

		}
	}
}


//案例1：打印1——100这些数字

class WhileExec1
{
	public static void main(String[] args)
	{
		//循环变量初始化 ①————————————————————执行了1遍
		int num = 1;

		while(num<=100){//循环条件  ②—————————执行了101遍
			//循环操作  ③—————————————————————执行了100遍
			System.out.println(num);
			//循环变量更新  ④—————————————————执行了100遍
			num++;

		}


	}


}

//案例2：打印100——200之间所有的偶数
class WhileExec2
{
	public static void main(String[] args)
	{

		//方式一：

	/*	int num = 100;
		while(num<=200){

			System.out.println(num);

			num+=2;


		}

		*/

		//方式二：

		int num = 100;
		while(num<=200){
			//循环操作
			//1.判断是否是偶数
			if(num%2==0)
				//2.打印
				System.out.println(num);

			num++;
		}



	}


}
//练习：打印1——100的和

/*
1+2+3+4+...+100

*/
class WhileExec3
{
	public static void main(String[] args)
	{
		int result = 0;//保存和
		int i=1;
		while(i<=100){
			//循环操作
			result+=i;

			i++;

		}

		System.out.println("result = "+result);

	}


}

//练习：100——999之间所有能被3但不能被7整除的数的和

class WhileExec4
{
	public static void main(String[] args)
	{

		int sum = 0;
		int i=100;
		while(i<1000){

			//循环操作
			//1.先判断
			if(i%3==0&&i%7!=0){
				//2.求和
				sum+=i;
			}

			i++;
		}

		System.out.println(sum);


	}

}

//案例：输入10名学生的年龄，统计>18岁的人数
/*
请输入第x名学生的年龄：xx    判断年龄>18 ,如果是，则统计上
请输入第x名学生的年龄：xx
请输入第x名学生的年龄：xx
请输入第x名学生的年龄：xx
。。。
请输入第x名学生的年龄：xx




*/

class WhileExec5
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int count = 0;//统计个数
		int i=1;
		while(i<=10){
			//循环操作
			//1.提示打印
			System.out.print("请输入第"+i+"名学生的年龄：");
			//2.接收键盘输入
			int age = input.nextInt();
			//3.判断
			if(age>18){
				//4.统计
				count++;

			}


			i++;

		}

		System.out.println("一共有"+count+"个");


	}


}


//不断输入姓名，直到输入 “q”为止
class WhileExec6
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);


		String name = "";//循环变量参数
		while(!name.equals("q")){//循环条件

			//循环操作
			System.out.print("请输入姓名：");
			name = input.next();//循环变量更新

		}


	}

}
//1_100求和
class WhileExec7
{
	public static void main(String[] args)
	{
		int i=1;
		int sum=0;
		while(i<=100){
			//循环操作
			sum+=i;


			i++;
		}
		System.out.println(sum);

	}

}
//不断输入月份，直到输入错误为止

class WhileExec8
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		int month=1;//①
		while(month>=1&&month<=12){//②
			System.out.print("请输入一个月份：");//③
			month = input.nextInt();//④

		}

	}


}
