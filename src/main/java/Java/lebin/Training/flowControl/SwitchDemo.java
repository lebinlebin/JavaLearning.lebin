package Java.lebin.Training.flowControl;


/*

此类用于演示switch结构

如果按1，显示：王语嫣的号
如果按2，显示：木婉清的号
如果按3，显示：钟灵的号
如果按4，显示：慕容复的号


*/

import java.util.Scanner;
class SwitchDemo
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//System.out.println("请输入号码：");
		//int num = input.nextInt();

		//分支结构
/*
		if(num==1){
			System.out.println("王语嫣");
		}else if(num==2){
			System.out.println("木婉清");
		}else if(num==3){
			System.out.println("钟灵");
		}else if(num==4){
			System.out.println("慕容复");
		}


		*/

		//语法注意事项1：判断的变量或表达式的类型只能是int以及能自动转换成int的byte、short、char，jdk5.0可以是枚举enum，jdk7.0可以是String

	/*	double x=1.5;
		String s = "john";
		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);
		switch(ch){
			case '1':
				System.out.println("王语嫣");break;
			case '2':
				System.out.println("木婉清");break;
			case 3:
				System.out.println("钟灵");break;
			case 4:
				System.out.println("慕容复");break;

		}


		//语法注意事项2：case 后面只能是常量

		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);
		char temp = '1';
		switch(ch){
			case temp:
				System.out.println("王语嫣");break;
			case '2':
				System.out.println("木婉清");break;
			case 3:
				System.out.println("钟灵");break;
			case 4:
				System.out.println("慕容复");break;

		}

		//语法注意事项3：case 后面的常量值不能重复

		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);

		switch(ch){
			case '1':
				System.out.println("王语嫣");break;
			case '2':
				System.out.println("木婉清");break;
			case '3':
				System.out.println("钟灵");break;
			case '4':
				System.out.println("慕容复");break;

		}


		//语法注意事项4：break语法可以省略，但会影响效果
		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);
		char temp = '1';
		switch(ch){
			case '1':
				System.out.println("王语嫣");
			case '2':
				System.out.println("木婉清");
			case '3':
				System.out.println("钟灵");
			case '4':
				System.out.println("慕容复");

		}*/


		//语法注意事项5：default语法上可以省略，也可以提到case前面，但可能影响效果
		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);

		switch(ch){
			case '1':
				System.out.println("王语嫣");

			case '2':
				System.out.println("木婉清");
			case '3':
				System.out.println("钟灵");
			case '4':
				System.out.println("慕容复");
			default:
				System.out.println("段正淳");

		}
	}
}
//1.使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输出 other
class SwitchExec1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("请输入一个字符：");
		char ch = input.next().charAt(0);
		//方式一：
		if(ch>='a'&&ch<='e'){
			System.out.println((char)(ch-32));
		}else{
			System.out.println("other");
		}
		//方式二：
		//判断
		switch(ch){
			case 'a':System.out.println('A');break;
			case 'b':System.out.println('B');break;
			case 'c':System.out.println('C');break;
			case 'd':System.out.println('D');break;
			case 'e':System.out.println('E');break;
			default:System.out.println("other");break;

		}


	}

}
//2.对学生成绩大于等于60分的，输出“合格”。低于60分的，输出“不合格”

class SwitchExec2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("请输入一个成绩：");
		double score  = input.nextDouble();

		switch((int)score/60){
			case 1:
				System.out.println("合格");break;
			case 0:
				System.out.println("不合格");break;

		}
	}


}

//3.根据用于指定月份，打印该月份所属的季节。
//3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季

class SwitchExec3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("请输入月份：");
		int month = input.nextInt();

		switch(month){
			case 3:
			case 4:
			case 5:System.out.println("春季");break;
			case 6:
			case 7:
			case 8:System.out.println("夏季");break;
			case 9:
			case 10:
			case 11:System.out.println("秋季");break;
			case 12:
			case 1:
			case 2:System.out.println("夏季");break;

		}


	}


}
