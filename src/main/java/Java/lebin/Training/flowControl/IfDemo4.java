package Java.lebin.Training.flowControl;

/*
此类用于演示嵌套分支结构
案例1：参加百米运动会，如果用时8秒以内进入决赛，否则提示淘汰。并且根据性别提示进入男子组或女子组

*/

import java.util.Scanner;
class IfDemo4
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		System.out.println("请输入秒数：");
		double seconds = input.nextDouble();


		//先需要判断秒数，看是否能进入决赛
		if(seconds<=8){//决赛
			System.out.println("请输入性别：");
			char gender = input.next().charAt(0);
			if(gender == '男'){
				System.out.println("恭喜你，进入男子组！");
			}else{
				System.out.println("恭喜你，进入女子组！");
			}
		}else{//淘汰
			System.out.println("很遗憾，你被out了！");
		}
	}
}
/*
某旅游景点出票系统：
淡季：1 -3 10——12
成人（>18） 40块，儿童(<18)或老人(>70) 20

旺季：4——9
成人：60，儿童或老人 40， 学生(有无学生卡) 30

*/


class IfExec4
{
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		System.out.println("请输入月份：");
		int month = input.nextInt();


		if(month>=4&&month<=9){//旺季
			System.out.println("是否有学生卡？");
			boolean isStudent = input.nextBoolean();
			if(isStudent){
				System.out.println("￥30");
			}else{
				System.out.println("请输入年龄：");
				int age = input.nextInt();
				if(age>18&&age<70){

					System.out.println("￥60");
				}else{
					System.out.println("￥40");

				}

			}



		}else{//淡季
			System.out.println("请输入年龄：");
			int age = input.nextInt();
			if(age>18&&age<70){

				System.out.println("￥40");
			}else{
				System.out.println("￥20");

			}

		}





	}

}