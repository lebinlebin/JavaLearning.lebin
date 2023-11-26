package Java.lebin.Training.Exception;
/*
 * 此类用于演示异常处理的方式二：抛
 */
public class TestException5 {
	
	public static void main(String[] args ){
		method1();
	}

	private static void method1()  {
		method2();
		
	}

	private static void method2() {

		method3();
	}

	private static void method3()  {
		method4();
	}

	private static void method4(){
		
		int[] arr = {1,2,3};
		System.out.println(arr[3]);//下标越界异常
		
	}

}


