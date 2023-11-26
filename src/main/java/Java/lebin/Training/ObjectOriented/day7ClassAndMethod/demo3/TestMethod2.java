package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo3;
/**
 * 此类用于演示方法的调用语法和机制
 * @author liyuting
 *
 */
class A{
	public void method1(){
		System.out.println("method1-haha1");
		System.out.println("method1-haha2");
		System.out.println("method1-haha3");
		
		method2(10,5);
		
	}
	public void method2(int a,int b){
		System.out.println("method2-haha1");
		System.out.println("method2-haha2");
		System.out.println("method2-haha3"+a+b);
		int result = method3(a);
		
		
	}
	public int method3(int a){
		System.out.println("method3-haha1");
		System.out.println("method3-haha2");
		System.out.println("method3-haha3");
		method4(a);
		return a*a;
		
		
	}
	public void method4(int a){
		System.out.println("method4-haha1");
		System.out.println("method4-haha2");
		System.out.println("method4-haha3"+a);
		method1();
		
		
	}
}



public class TestMethod2 {
	
	public static void main(String[] args) {
		A a = new A();
		a.method1();
		a.method4(100);
	}

}
