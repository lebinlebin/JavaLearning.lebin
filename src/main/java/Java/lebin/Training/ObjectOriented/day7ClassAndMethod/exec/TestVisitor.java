package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.exec;

import java.util.Scanner;

/**
 * 测试游客类（出票系统类）
 * @author liyuting
 *
 */
public class TestVisitor {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do{
			Visitor v = new Visitor();
			//循环操作
			System.out.print("请输入游客姓名：");
			v.name=input.next();
			if("n".equals(v.name)){
				System.out.println("程序结束");
				break;
			}
			System.out.print("请输入游客年龄：");
			v.age=input.nextInt();
			
			if(v.age>18){
				System.out.println(v.name+"的年龄是："+v.age+",门票价格：20");
			}else{
				System.out.println(v.name+"的年龄是："+v.age+",门票价格免费");
				
			}
			
			
			
		}while(true);
	}

}
