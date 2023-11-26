package  Java.lebin.Training.loopControl;

/*

此类用于演示do while循环结构的特点和使用

*/


import java.util.Scanner;
//案例：打印1——100
class DoWhileDemo
{
	public static void main(String[] args)
	{
		int i=1;//循环变量初始化①————————————————————执行了1遍
		do{
			System.out.println(i);//循环操作 ③———————————执行了100遍

			i++;//循环变量更新④——————————————————————————执行了100遍
		}while(i<=100);//循环条件  ②—————————————————————执行了100遍
	}
}


//题型1:1——1000之内所有奇数的和，要求使用do while

class DoWhileExec1
{
	public static void main(String[] args)
	{
		int sum = 0;
		int i=1;
		do{
			//循环操作

			//1.判断是否是奇数，如果是则继续下一步
			if(i%2!=0)
				//2.求和
				sum+=i;
			i++;
		}while(i<=1000);
		System.out.println(sum);



	}

}


//题型2：不断输入一个姓名，直到输入exit或q停止，要求使用 do while
class DoWhileExec2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String name;//循环变量初始化
		do{
			//循环操作
			System.out.print("请输入姓名：");
			//循环变量更新
			name = input.next();
			//循环条件
		}while(!(name.equals("exit")||name.equals("q")));
	}

}


