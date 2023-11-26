package Java.lebin.Training.flowControl;

/*
此类用于演示多重分支结构

案例1：
岳小鹏参加Java考试，他和父亲岳不群达成承诺：
如果：
成绩为100分时，奖励一辆BMW；
成绩为(80，99]时，奖励一台iphone7plus；
当成绩为[60,80]时，奖励一个 iPad；
其它时，什么奖励也没有。
请从键盘输入岳小鹏的期末成绩，并加以判断


*/
import java.util.Scanner;
class IfDemo3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your score：");
		double score = input.nextDouble();


		if(score>80){
			System.out.println("iphoneX");

		}
		else if(score == 100){
			System.out.println("奖励BMW");
		}

		else if((score+=10)>=60){
			System.out.println("ipad");
		}
		System.out.println(score);

	}
}


/*
3)  求ax2+bx+c=0方程的根。a,b,c分别为函数的参数，如果：b2-4ac>0，则有两个解；b2-4ac=0，则有一个解；b2-4ac<0，则无解；
提示1：x1=(-b+Math.sqrt (b2-4ac))/2a
               X2=(-b-Math.sqrt(b2-4ac))/2a
提示2：Math.sqrt(num);


*/

class IfExec11
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("a:");
		double a = input.nextDouble();

		System.out.println("b:");
		double b = input.nextDouble();
		System.out.println("c:");
		double c = input.nextDouble();
		double result= b*b-4*a*c;

		if(result>0){//两个解
			System.out.println("解1："+(-b+Math.sqrt (result))/(2*a));
			System.out.println("解2："+(-b-Math.sqrt (result))/(2*a));
		}else if(result==0){//一个解
			System.out.println("1："+(-b+Math.sqrt (result))/(2*a));
		}else{
			System.out.println("无解");

		}

	}

}


/*
大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出一定的条件：高：180cm以上；富：财富1千万以上；帅：是。
如果这三个条件同时满足，则：“我一定要嫁给他!!!”
如果三个条件有为真的情况，则：“嫁吧，比上不足，比下有余。”
如果三个条件都不满足，则：“不嫁！”


*/


class IfExec22
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入男朋友的身高：");
		double height = input.nextDouble();

		System.out.println("请输入男朋友的财富：单位w");
		double money = input.nextDouble();

		System.out.println("请输入男朋友的颜值：true 帅 false 不帅");
		boolean isHandsome = input.nextBoolean();

		if(height>=180&&money>=1000&&isHandsome){
			System.out.println("赶紧嫁吧，否则被抢了");

		}else if(height>=180||money>=1000||isHandsome){
			System.out.println("比上不足，比下有余");
		}else{
			System.out.println("算了吧，再找找！");

		}



	}

}