package Java.lebin.Training.ObjectOriented.day9Inheritance.exec2;
/**
 * 此类用于练习 继承和super关键字和构造器调用
 * 1.根据下图实现类。在TestCylinder类中创建Cylinder类的对象，设置圆柱的底面半径和高，并输出圆柱的体积。
 * @author liyuting
 *
 */
public class TestCircle {
	
	public static void main(String[] args) {
		Cylinder c = new Cylinder();
		
		System.out.println(c.findArea());
	}

}
/*
 * Cylinder():  构造方法,将length属性初始化为1
+setLength(double length):void
+getLength():double
+findVolume() :double   计算圆柱体积

 */
class Cylinder extends Circle{
	private double length;//高
	
	public Cylinder(){
		length=1;
	}
	public double findArea(){
		return super.findArea()*length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
}
/*
Circle(): 构造方法,将radius属性初始化为1
+setRadius(double radius) : void
+getRadius(): double
+findArea():double  计算圆的面积


*/

class Circle{
	
	private double radius;//半径
	
	public double findArea(){
		return Math.PI*radius*radius;
	}
	
	public Circle(){
		radius = 1;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}