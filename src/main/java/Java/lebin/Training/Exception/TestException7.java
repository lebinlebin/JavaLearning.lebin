package Java.lebin.Training.Exception;

import java.util.Scanner;

/**
 * 此类用于演示自定义异常类
 * @author liyuting
 * 定义步骤：
 * 
 * 1、定义类XXException 继承RuntimeException（运行异常）或Exception（编译异常）
 * 2、类体中，设计无参和有参构造器
 * 
 * 
 * 生成异常对象：
 * 
 * 1、手动生成：throw new 异常类型(参数);   针对于任何异常类型
 * 2、系统自动生成的                                                       仅仅针对于系统定义好的异常类型
 *
 */
public class TestException7 {
	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("年龄：");
		int age = input.nextInt();
		
		if(age>120 || age<0){
			//生成一个异常对象
			
//			AgeIllegalException ae = new AgeIllegalException("年龄不合法！");
			try {
				throw new RuntimeException("年龄不合法！");
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("出错了，信息："+e.getMessage());
			}
			
		}
		System.out.println("年龄是："+age);
		
	}

}

class AgeIllegalException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgeIllegalException(String msg){
		super(msg);
	}
	
	public AgeIllegalException(){
		
	}
	
}


