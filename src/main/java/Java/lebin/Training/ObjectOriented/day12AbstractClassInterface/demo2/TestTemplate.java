package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.demo2;
/**
 * 此类用于演示模板方法设计模式
 * @author liulebin
 * 
 * 模板类：（抽象父类）
 * 		1、实现好的方法（普通方法）
 * 		2、没有实现的方法（抽象方法）
 * 
 * 应用类：（普通子类）
 *		1、实现好的方法，不用改造
 *		2、实现父类的抽象方法（改造）
 */
public class TestTemplate {
	public static void main(String[] args) {
		
		Template t = new Sub1();
		t.caleTimes();
		
		
		Template t2 = new Sub2();
		t2.caleTimes();
	}

}
class Sub2 extends Template{

	@Override
	public void code() {
		String s = "hello";
		for (int i = 1; i <=50000; i++) {
			s+=i;
		}
		
	}
	
}

class Sub1 extends Template{

	@Override
	public void code() {
		long sum=0;
		for (int i = 1; i <=50000; i++) {
			sum+=i;
		}
	}
	
}
abstract class Template{
	/*
	 * 功能：计算代码的耗时时间
	 */
	public void caleTimes(){
		//记录一下，代码执行前距离1970-1-1 0:0:0的时间差
		long start = System.currentTimeMillis();
		
		//代码
		code();
		
		//记录一下，代码执行后距离1970-1-1 0:0:0 的时间差
		long end = System.currentTimeMillis();
		
		System.out.println("耗时："+(end-start));
	}
	
	public abstract void code();
	
}