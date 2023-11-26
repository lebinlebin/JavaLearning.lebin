package Java.lebin.Training.Exception;

import java.util.Scanner;

public class TestException4 {

	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		
		try{
			System.out.println("请输入a:");
			String a = input.next();
			
			System.out.println("请输入b:");
			String b= input.next();
			//判断两个字符串是否相等
//			a=null;
			if(a.equals(b)){
				System.out.println("相等");
			}
			//将字符串转换成int类型
			int num1 = Integer.parseInt(a);
			int num2 = Integer.parseInt(b);
			//数学运算
			System.out.println("div="+num1/num2);//容易出现异常
			System.out.println("哈哈");
			System.out.println(args[0]);
		}catch(NumberFormatException e){
			System.out.println("数字格式不正确吧");
		}catch(ArithmeticException e){
			System.out.println("除数为0了吧！");
		}catch(NullPointerException e){
			System.out.println("空指针了吧");
		}catch(Exception e){
			System.out.println("下标越界吧");
		}finally{//最后一定要执行的语句
			System.out.println("try catch块后面的语句");
		}
	}
}
