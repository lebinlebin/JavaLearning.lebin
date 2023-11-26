package Java.lebin.Training.ObjectOriented.DEMOTEST.demo3;
/**
 * 此类用于演示可变参数的方法
 * 概念：jdk5.0出现的新特性。将同一个类中，多个方法名相同、参数类型相同、返回类型相同，仅仅是参数个数不同的方法抽取成一个方法，
 * 这种方法称为可变参数的方法
 * 好处：提高代码的重用性和维护性
 * 语法：
 * 
 * 		修饰符	返回类型	方法名(参数类型...参数名){
 * 			
 * 		}
 * 注意：使用时，将可变长度的参数当做数组使用
 * 使用特点：
 * 		1、可变参数的实参可以为0个或任意多个
 * 		2、可变参数的实参可以为一维数组类型
 * 		3、可变参数和普通类型参数 一起使用时，只能放在最后
 * 		4、一个参数列表中至多有一个可变参数！
 * 		
 *
 */
public class TestVarArgs {
	public static void main(String[] args) {
		GetSum gs = new GetSum();
		System.out.println(gs.sum(1));
		System.out.println(gs.sum(1,2));
		System.out.println(gs.sum(1,2,3,4));
		
		//是否可以放0个实参?可以
		System.out.println(gs.sum());
		
		//实参是否可以是一维数组?
		int[] a={1,2,3};
		System.out.println(gs.sum(a));
		
		//可变参数是否可以和普通类型的参数一起使用?可以，但必须可变参数在最后
		//一个参数列表中可以有多少个可变参数?至多一个
		gs.sum(2, 3);
	}

}

//案例：在一个类中，分别定义方法实现求两个数的和、三个数的和、四个数的和

class GetSum{
//	public int sum(String...b,int...a){//int[] a=new int[0];
//		int s = 0;
//		for(int i=0;i<a.length;i++){
//			s+=a[i];
//		}
//		return s;
//	}
	public int sum(int a,int b){
		System.out.println("a+b");
		return a+b;
	}
	public int sum(int...a){//int[] a=new int[0];
		int s = 0;
		for(int i=0;i<a.length;i++){
			s+=a[i];
		}
		return s;
	}
	/*
	public int sum(int a,int b){
		return a+b;
	}
	public int sum(int a,int b,int c){
		return sum(sum(a,b),c);
	}
	public int sum(int a,int b,int c,int d){
		return sum(sum(a,b,c),d);
	}
	*/
	
	
	
	
}
