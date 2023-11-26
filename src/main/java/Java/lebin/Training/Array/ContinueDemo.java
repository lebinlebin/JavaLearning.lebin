package Java.lebin.Training.Array;

/*
此类用于演示continue的使用和特点


*/

import java.util.Scanner;
class ContinueDemo
{
	public static void main(String[] args)
	{

		/*
		label:for(int i=1;i<=10;i++){

			for(int j=1;j<=5;j++){
				if(j==3){
					continue label;
				}
				System.out.println("哈哈"+j);

			}
			System.out.println("嘻嘻"+i);

		}


		for(int i=1;i<=10;i++){

			for(int j=1;j<=5;j++){
				switch(j){

					case 1:System.out.println();continue;



				}
				System.out.println("哈哈"+j);

			}
			System.out.println("嘻嘻"+i);

		}

		int i=10;
		switch(i){
			case 1:continue;


		}
*/

	}
}
//打印1——100之内的奇数

class ContinueExec1
{
	public static void main(String[] args)
	{

		for(int i=1;i<=100;i++){
			if(i%2==0)
				continue;

			System.out.println(i);


		}


	}


}
/*
编写程序一，打印1-100之间13的倍数，使用continue语句


*/

class ContinueExec2
{
	public static void main(String[] args)
	{

		for(int i=1;i<=100;i++){

			if(i%13!=0)
				continue;

			System.out.println(i);
		}




	}


}
//编写程序二：从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。

class ContinueExec3
{
	public static void main(String[] args)
	{
		Scanner input  = new Scanner(System.in);

		int countPositive = 0;//正数的个数
		int countNegative = 0;//负数的个数

		while(true){

			//循环操作

			System.out.print("请输入：");
			int num = input.nextInt();
			if(num==0)
				break;
			if(num>0){
				countPositive++;
				continue;
			}

			countNegative++;

		}

		System.out.println("正数的个数："+countPositive);
		System.out.println("负数的个数："+countNegative);





	}

}