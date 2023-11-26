package Java.lebin.Training.flowControl;

/*
此类用于演示双分支结构

案例1：
如果成绩>90,则奖励棒棒糖，否则面壁思过

*/
import java.util.Scanner;
class IfDemo2
{
	public static void main(String[] args)
	{
		int score = 10;

		//双分支判断

		if(score>90){
			System.out.println("奖励棒棒糖");
		}else{
			System.out.println("面壁思过");
		}
	}
}
//判断一个数是奇数还是偶数
class IfExec1
{
	public static void main(String[] args)
	{
		/*Scanner input = new Scanner(System.in);
		System.out.print("请输入：");
		int num = input.nextInt();

		if(num%2==0)//偶数
			System.out.println("偶数");

			System.out.println("哈哈");
		else
			System.out.println("奇数");


			*/
		int x = 4;
		int y = 1;
		if (x > 2)
			if (y > 2)
				System.out.println(x + y);
		System.out.println("atguigu");
//		else
		System.out.println("x is " + x);


	}

}

//2.判断两个数的较大值
class IfExec222
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Please input a:");
		int a = input.nextInt();
		System.out.print("Please input b:");
		int b = input.nextInt();

		if(a>b){

			System.out.println(a);
		}else{
			System.out.println(b);
		}



	}

}