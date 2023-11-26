package  Java.lebin.Training.loopControl;

//2、判断一个年份是否为闰年 ★能被4整除，但不能被100整除或能被400整除


import java.util.Scanner;
class Homework1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a year:");
		int year = input.nextInt();
		if(year%4==0 && year%100!=0||year%400==0){
			System.out.println("This is a LeapYear");

		}else{
			System.out.println("This is not a LeapYear");

		}



	}
}
//3、判断一个整数是否是水仙花数，
//所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。例如： 153 = 1*1*1 + 3*3*3 + 5*5*5   ★
class Homework2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个三位数字：");
		int num = input.nextInt();
		int ge = num%10;//个
		int shi = num/10%10;//十
		int bai = num/100;//百

		if(num>=100&&num<=999){
			//方式一
			/*
			if( num == ge*ge*ge+shi*shi*shi+bai*bai*bai){//水仙花
				System.out.println("是");
			}else{
				System.out.println("不是");

			}*/
			//方式二：

			if( num == Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3)){//水仙花
				System.out.println("是");
			}else{
				System.out.println("不是");

			}

		}else{
			System.out.println("不是一个有效的三位数");


		}


	}

}
//保存用户名和密码，判断用户名是否为“张三”，密码是否为1234，如果是，提示登录成功，否则提示登录失败  ★
/*

== 可以用于比较两个基本类型或两个引用类型
如果比较基本类型，判断的是值（内容）是否相等。要求：两个操作数的类型一致或兼容。
		示例： 100==100.0  true    'a'==97  true
如果比较引用类型，判断的是地址是否相等  （所以一般来讲，不用它去判断）,可以使用equals方法去判断内容

		示例：string1.equals(string2) 结果为：boolean类型;
*/
class Homework3
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.next();
		System.out.println("请输入密码：");
		String pwd = input.next();
		if(name.equals("张三")&&pwd.equals("1234")){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");

		}


	}

}

/*
6、编写程序，根据输入的月份和年份，求出该月的天数（1-12）【switch题目】  ★
1/3/5/7/8/10/12  ————31
2——29/28
其他——30

输入年、月、日，求该天为该年的第几天
switch
循环
*/

class Homework4
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("请输入年份：");
		int year = input.nextInt();
		System.out.print("请输入月份：");
		int month = input.nextInt();

		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:System.out.println(31);break;
			case 2:
				if(year%4==0 && year%100!=0||year%400==0){
					System.out.println("This is a LeapYear");

				}else{
					System.out.println("This is not a LeapYear");

				}
				break;
			default:
				System.out.println(30);break;


		}




	}

}
//打印随机数
class RandomDemo
{
	public static void main(String[] args)
	{
		//默认产生的是；0——1之间的浮点数   [0,1)
		//double d = Math.random();
		//System.out.println("随机数："+d);

		//产生：10——99的整数

		//[0-90)
		double n1 = Math.random()*90;
		//[10-100) 10-99.xx
		int n2 = (int)(Math.random()*90+10);
		//	System.out.println("随机数："+n2);

		//公式：a-b之间的整数 [a,b]
		//(int)(Math.random()*(b-a+1)+a)

		System.out.print("幸运组为："+((int)(Math.random()*6+1)));



	}

}