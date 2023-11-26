package  Java.lebin.Training.loopControl;


import java.util.Scanner;
class BreakDemo
{
	public static void main(String[] args)
	{
		int i=1;
		while(i<=10){
			System.out.println("哈哈"+i);
			if(i==5){
				break;
			}
			i++;

		}
	}
}
//100以内的数求和，求出和第一次大于20的当前数

class BreakExec1{
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<=100;i++){
			sum+=i;
			if(sum>=20){
				System.out.println("当前数:"+i);
				break;

			}
		}
		System.out.println(sum);

	}


}
/*
实现登录验证，有三次机会，如果用户名为”张无忌” ,密码”888”提示登录成功，否则提示还有几次机会


*/

class BreakExec2
{
	public static void main(String[] args)
	{

		Scanner input  = new Scanner(System.in);

		for(int i=1;i<=3;i++){
			//循环操作

			//1.提示输入
			System.out.print("Please input username:");
			//2.输入
			String username = input.next();
			System.out.print("Please input password:");
			String password = input.next();

			//3.判断是否登录成功

			if(username.equals("张无忌")&&password.equals("8888")){
				System.out.println("Login Success!");
				break;
			}else{
				if(i==3){
					System.out.println("Login Failure!");
				}else{
					System.out.println("You only have "+(3-i)+" chances!");
				}

			}
		}

	}

}

class BreakExec3
{
	public static void main(String[] args)
	{
		label:for(int i=1;i<=10;i++){
			for(int j=1;j<=5;j++){
				if(j==3){
					break label;
				}
				System.out.println("哈哈"+j);
			}
			System.out.println("嘻嘻------------"+i);
		}
	}

}