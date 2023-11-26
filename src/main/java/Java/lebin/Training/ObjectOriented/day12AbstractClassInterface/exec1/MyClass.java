package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.exec1;


public class MyClass {
	static int x,y;  //x = 0 ；  y = 0
	static{//局部变量这个可以忽略
		int x=5;
		x--;
	}
	static{
		x--;//-1  0
	}

	public static void main(String[] args) {
		x--;//-2 0
		myMethod() ;
		System.out.println(x+y + ++x);//0 + -2 + 1 = -1
	}
	
	public static void myMethod() {
		y=x++ + ++x;//-2  + 0 = -2 	  x=0  y=-2
	}
}
