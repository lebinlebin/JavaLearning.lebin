package  Java.lebin.Training.loopControl;


/*

此类用于演示嵌套循环的特点和使用


案例1：
：打印3个班，每个班5名同学的平均分
*/

import java.util.Scanner;

class InnerLoopDemo
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double result = 0;//所有的成绩和
		for(int i=1;i<=3;i++){//i:班级数

			double sum = 0;//一个班的成绩和
			for(int j=1;j<=5;j++){//j:每个班级的学生数
				//循环操作

				//1.提示输入
				System.out.print("请输入第"+j+"名同学成绩：");
				//2.输入
				double score = input.nextDouble();
				//3.求和
				sum+=score;
				result+=score;
			}
			//result+=sum;
			System.out.println("第"+i+"个班的平均分："+(sum/5));


		}
		System.out.println(result/15);



	}
}

/*

打印图形：


进阶1：

****
****
****


*/
class InnerLoopExec1
{
	public static void main(String[] args)
	{
		/*
		System.out.println("****");
		System.out.println("****");
		System.out.println("****");

		*/


		for(int i=1;i<=3;i++){//i:控制行数
			//①打印*
			for(int j=1;j<=4;j++){//j：控制*的个数
				System.out.print("*");//控制打印内容

			}

			//②换行
			System.out.println();

		}
	}
}

/*

打印图形：


进阶2：

*
**
***

i	*
1	1
2	2
3	3





*/
class InnerLoopExec2
{
	public static void main(String[] args)
	{

		for(int i=1;i<=10;i++){//i:控制行数
			//①打印*
			for(int j=1;j<=i;j++){//j：控制*的个数
				System.out.print("*");//控制打印内容

			}
			//②换行
			System.out.println();

		}
	}
}

/*

打印图形：


进阶3：

1*1=1
2*1=2 2*2=4
....

9*1=9 9*2=18.............9*9=81

i	*
1	1
2	2
3	3





*/
class InnerLoopExec3
{
	public static void main(String[] args)
	{

		for(int i=1;i<=9;i++){//i:控制行数
			//①打印*
			for(int j=1;j<=i;j++){//j：控制*的个数
				System.out.print(i+"*"+j+"="+i*j+" ");//控制打印内容

			}
			//②换行
			System.out.println();

		}
	}
}

/*

打印图形：


进阶4：

    *
   ***
  *****
 *******

i	空格	*
1	2		1
2	1		3
3   0		5

2i-1


*/
class InnerLoopExec4
{
	public static void main(String[] args)
	{
		int row = 10;
		for(int i=1;i<=row;i++){//i:控制行数

			//①打印空格
			for(int j=1;j<=row-i;j++){//j：控制空格的个数
				System.out.print(" ");//控制打印内容
			}

			//②打印*
			for(int j=1;j<=2*i-1;j++){//j：控制*的个数
				System.out.print("*");//控制打印内容
			}
			//②换行
			System.out.println();

		}
	}
}
/*

打印图形：


进阶5：

 *****
  ***
   *

i	空格	*
1	0		5
2	1		3
3   2		1






*/
class InnerLoopExec5
{
	public static void main(String[] args)
	{
		int row2 = 30;
		for(int i=1;i<=row2;i++){//i:控制行数

			//①打印空格
			for(int j=1;j<=i-1;j++){//j：控制空格的个数
				System.out.print(" ");//控制打印内容
			}

			//②打印*
			for(int j=1;j<=2*row2-(2*i-1);j++){//j：控制*的个数
				System.out.print("*");//控制打印内容
			}
			//②换行
			System.out.println();

		}
	}
}
/*

******
 *    *
  ******

i	空格
1	0
2	1
3	2
*/

class InnerLoopExec6
{
	public static void main(String[] args)
	{
		int row = 10;
		for(int i=1;i<=row;i++){//i:控制行数

			//①打印空格
			for(int j=1;j<=i-1;j++){//j：控制空格的个数
				System.out.print(" ");//控制打印内容
			}

			//②打印*
			for(int j=1;j<=6;j++){//j：控制*的个数

				if(i==1||i==row||j==1||j==6){
					System.out.print("* ");//控制打印内容
				}else{
					System.out.print("  ");
				}
			}
			//②换行
			System.out.println();

		}
	}
}

