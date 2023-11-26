package Java.lebin.Training.Array;
import java.util.Scanner;
import java.text.MessageFormat;
class MyFamilyAccount
{
	public static void main(String[] args)
	{
		Scanner input  = new Scanner(System.in);
		String details = "收支\t收支金额\t账户金额\t说  明\n";//保存收支明细
		double money = 10000;//初始本金
		boolean loop = true;
		boolean isLogin = false;//默认没有登记过
		do{

			//循环操作
			System.out.println("\n-----------------家庭收支记账软件-----------------\n");
			System.out.println("                   1 收支明细");
			System.out.println("                   2 登记收入");
			System.out.println("                   3 登记支出");
			System.out.println("                   4 退    出\n");
			System.out.print("请选择(1-4)：");
			char key = input.next().charAt(0);

			//判断用户输入
			switch(key){

				case '1'://打印收支明细
					if(!isLogin){
						System.out.println("暂无收支明细，请赶紧来一笔吧！哈哈");
						continue;
					}

					System.out.println("----------------收支明细------------------");
					System.out.println(details);
					break;
				case '2'://等级收入

					System.out.print("本次收入金额：");
					double balance  = input.nextDouble();
					System.out.print("本次收入说明：");
					String account  = input.next();

					//---------------等记------------
					//①将money更新
					money+=balance;

					//②将details拼接
					//方式一：
					details+="收入\t"+balance+"\t\t"+money+"\t\t"+account+"\n";
					//方式二：使用String.format()方法进行格式字符串
					/*
						%d 整型变量
						%s 字符串变量
						%c 字符形变量
						%.2f 浮点型变量

					*/
					//details+=String.format("收入\t%.1f\t\t%.1f\t\t%s",balance,money,account);
					//方式三：使用MessageFormat.format()方法进行格式字符串
					details+=MessageFormat.format("收入\t{0}\t\t{1}\t\t{2}",balance,money,account);


					System.out.println("等记完成！");
					isLogin = true;//更新等记值


					break;
				case '3'://登记支出
					//本次支出金额：800
					//本次支出说明：物业费_
					System.out.print("本次支出金额：");
					int balance2  = input.nextInt();
					System.out.print("本次支出说明：");
					String account2  = input.next();

					//---------------等记------------
					//①将money更新
					money-=balance2;

					//②将details拼接
					details+="支出\t"+balance2+"\t\t"+money+"\t\t"+account2+"\n";
					System.out.println("等记完成！");

					isLogin = true;//更新等记值


					break;
				case '4'://退出
				/*
					确定要退出吗?Y/N
					x
					输入错误，请重新输入：
					x
					输入错误，请重新输入：
					n
					程序退出



				*/
					System.out.println("确定要退出吗?Y/N");

					for(;;){
						char isExit = input.next().toUpperCase().charAt(0);
						if(isExit=='Y'){
							loop=false;
							break;
						}
						if(isExit=='N'){

							break;
						}
						System.out.print("输入错误，请重新输入：");

					}


			}





		}while(loop);

	}
}
