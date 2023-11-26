package Java.lebin.Training.ObjectOriented.DEMOTEST.exec2;
/*
 * 2.编写程序，定义三个重载方法并调用。方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。

3.定义三个重载方法max()，
第一个方法求两个int值中的最大值，第二个方法求两个double值中的最大值，第三个方法求三个double值中的最大值，并分别调用三个方法。

 */
public class TestOverLoad {
	public static void main(String[] args) {
		//创建OL 的对象
		OL ol = new OL();
		ol.mOL(100);
		ol.mOL(2, 3);
		ol.mOL("hello");
		
		
		double max = ol.max(1.7, 8.3, 1.5);
		System.out.println(max);
	}

}



class OL{
	public int max(int a,int b){
		return a>b?a:b;
	}
	public double max(double a,double b){
		return a>b?a:b;
	}
	public double max(double a,double b,double c){
		
		return max(max(a,b),c);
	}
	
	public void mOL(int a){
		System.out.println(Math.pow(a, 2));
		
	}
	
	public void mOL(int a,int b){
		System.out.println(a*b);
	}
	public void mOL(String s){
		System.out.println(s);
	}
	
	
}