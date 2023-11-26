package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.exec;
/*
 * 
 * 
 * 
请输入第一个整数：10
请输入第二个整数：5

*************************************

	    小小计算器


*************************************


10 + 5 =15

10 - 5 = 5

10 * 5 = 50

10 / 5 = 2

 */
public class Cale {
	int a;
	int b;
	public void add(){
		System.out.println(a+"+"+b+"="+(a+b));
	}
	public void sub(){
		System.out.println(a+"-"+b+"="+(a-b));
	}
	
	public void mul(){
		System.out.println(a+"*"+b+"="+(a*b));
	}
	
	public void div(){
		System.out.println(a+"/"+b+"="+(a/b));
	}
	
	

}
