package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.exec2;
/*
 * 设计方法的原则：
 * 	让方法的通用性越高越好！
 * 
 * 
 */
public class TestMethod {
	
	public static void main(String[] args) {
		MethodUtils mu = new MethodUtils();
		//调用方法1
		System.out.println(mu.verifyNum(100));
		
		//调用方法2
		System.out.println(mu.getArea(10, 8));;
		
		//测试计算器类
		Cale c = new Cale();
		c.a=10;
		c.b=5;
		
		System.out.println(c.add());
		System.out.println(c.sub());
		System.out.println(c.mul());
		System.out.println(c.div());
	}

}

//定义一个计算器类，实现两个数的加减乘除四个方法
class Cale{
	
	int a,b;
	public int add(){
		return a+b;
	}
	public int sub(){
		return a-b;
	}
	public int mul(){
		return a*b;
	}
	public int div(){
		return a/b;
	}
	
}

class MethodUtils{
	
	//判断一个数是否能被3整除
	
	public boolean verifyNum(int num){
		
//		if(num%3==0)
//			return true;
//		return false;
		
		return num%3==0;
	}
	
	//根据底和高，返回三角形面积
	public double getArea(double length,double height){
		return length*height/2;
	}
	
	
}