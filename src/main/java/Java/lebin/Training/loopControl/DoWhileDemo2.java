package  Java.lebin.Training.loopControl;

/*

此类用于演示do while循环结构的特点和使用

*/


import java.util.Scanner;
//案例：打印1——100
class DoWhileDemo1
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

class DoWhileExec11
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
class DoWhileExec22
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String name;//循环变量初始化
		do{

			//循环操作
			System.out.print("请输入姓名：");
			name = input.next();//循环变量更新


		}while(!(name.equals("exit")||name.equals("q")));//循环条件


	}

}

//1.如果老公同意老婆购物，则老婆将一直购物，直到老公说不同意为止
/*
老婆问：可以继续购物吗？
老公答：买
老婆继续疯狂shopping！

老婆问：可以继续购物吗？
老公答：买
老婆继续疯狂shopping！

老婆问：可以继续购物吗？
老公答：买
老婆继续疯狂shopping！

老婆问：可以继续购物吗？
老公答：不同意



*/

class DoWhileExec3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String answer;
		do{

			//循环操作
			System.out.print("老婆问：可以继续购物吗？");
			answer = input.next();
			if("买".equals(answer)){

				System.out.println("老婆疯狂购物！");
			}




		}while(answer.equals("买"));



	}


}
//2. 统计1——200之间能被5整除但不能被3整除的个数

class DoWhileExec4
{
	public static void main(String[] args)
	{
		int count = 0;
		int i = 1;
		do{
			//循环操作

			//1.判断是否满足条件，如果能，则进行下一步
			if(i%5==0&&i%3!=0){
				//2.统计个数
				count++;

			}



			i++;
		}while(i<=200);

		System.out.println(count);


	}


}