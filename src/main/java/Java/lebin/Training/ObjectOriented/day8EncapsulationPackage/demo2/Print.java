package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.demo2;

/**
 * 此类用于演示方法的重载
 * @author liyuting
 * 
 * 概念：
 * java中允许同一个类中，多个方法的名称相同，但参数列表必须不同
 * 这种现象称为重载！
 * 
 * 特点：
 * 
 * 	①、必须保证参数列表中至少有一样不同（参数类型、参数个数、参数顺序）
 *  ②、返回类型无要求
 *  ③、修饰符无要求
 *  
 *  
 *  经典案例：
 *  
 *  System.out.println();
 *
 */

public class Print {
	
//	public void print(int hang){
//		System.out.println("打印等边三角形");
//	}
	public void print(int hang,double lie){
		System.out.println("打印矩形");
	}
	 void print(double hang ){
		System.out.println("打印菱形");
	}
	public void print(double hang,int lie){
		System.out.println("打印菱形");
	}
	
	

}
