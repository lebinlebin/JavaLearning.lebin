package Java.lebin.Training.communication.exec;

import org.junit.Test;

public class TestMethodRef {
	
	@Test
	public void test1() {

		A a = new A(){

			@Override
			public void method1() {
				new MyClass().run();
			}
			
		};
		
		
		A b = new MyClass()::run;
		
	}
	
	@Test
	public void test2() {

		B<Integer> b = MyClass::cale;
		
	}
	
	@Test
	public void test3() {

		C<Double,Double> c = MyClass::sum;
		C<Double,String> c2 = new MyClass()::concat;
		
		
	}
	
	@Test
	public void test4() {
		
		D<Integer,String> d = new MyClass()::max;

	}
	
	@Test
	public void test5() {
		E<MyClass,String,Integer,Character> e = MyClass::getCharacter;
	}

}
interface A{
	void method1();
}
interface B<T>{
	void method2(T t1, T t2);
}
interface C<T,R>{
	R method3(T t1, T t2, T t3);
}
interface D<T,R>{
	R method4(T... ts);
}
interface E<T,R,U,M>{
	M method5(T t, R r, U u);
}

class MyClass{
	public void run(){
		System.out.println("跑啊跑啊");
	}
	public static void cale(int a,int b){
		System.out.println(a+b);
	}
	
	public static double sum(double d1,double d2,double d3){
		return d1+d2+d3;
	}
	public  String concat(double d1,double d2,double d3){
		return "hi:"+d1+d2+d3;
	}
	public String max(Integer...is){
		int max=is[0];
		for (int i = 0; i < is.length; i++) {
			if(max<is[i])
				max=is[i];
		}
		return "最大值："+max;
	}

	public char getCharacter(String str,int index){
		return str.charAt(index);
	}
}
