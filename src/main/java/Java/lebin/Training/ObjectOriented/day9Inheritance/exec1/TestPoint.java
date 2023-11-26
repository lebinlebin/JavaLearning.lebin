package Java.lebin.Training.ObjectOriented.day9Inheritance.exec1;
/*
 * 3.定义一个“点”（Point）类用来表示三维空间中的点（有三个坐标）。要求如下：
    1通过有参构造器可以生成具有特定坐标的点对象。
    2）提供可以设置三个坐标的方法。
    3）提供可以计算该“点”距原点距离平方的方法。

 */
public class TestPoint {
	
	public static void main(String[] args) {
		Point p = new Point(1,2,3);
		
		System.out.println(p.getLength());
	}

}


class Point{
	
	private double x;
	private double y;
	private double z;
	
	public Point(double a,double b,double c){
		x=a;
		y=b;
		z=c;
	}
	
	public double getLength(){
		return x*x+y*y+z*z;
	}
	public void setX(double a){
		x=a;
	}
	public void setY(double b){
		y=b;
	}
	public void setZ(double c){
		z=c;
	}
	
	
	
	
	
	
}