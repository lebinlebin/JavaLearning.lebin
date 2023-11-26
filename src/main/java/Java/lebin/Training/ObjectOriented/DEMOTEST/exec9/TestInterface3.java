
package Java.lebin.Training.ObjectOriented.DEMOTEST.exec9;
/**
 * 此类用于演示接口的综合练习
 * @author liyuting
 * 定义一个接口用来实现两个对象的比较。
interface CompareObject{
	public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 }
定义一个Circle类。
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的面积大小。
定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。

 *
 */
public class TestInterface3 {
	public static void main(String[] args) {
		ComparableCircle cc1 = new ComparableCircle(3);
		ComparableCircle cc2 = new ComparableCircle(5);
		
		System.out.println(cc1.compareTo("john"));
		
		
	}

}

class ComparableCircle extends Circle implements Comparable{

	public ComparableCircle(double radius) {
		super(radius);
	}
	/**
	 * 功能：比较两个圆的半径
	 * 如果当前圆大，则返回1
	 * 如果当前圆小，则返回-1
	 * 相等，返回0
	 * 注：如果实参不是当前类型，则返回1，代表当前对象大！
	 * this pk o
	 */
	@Override
	public int compareTo(Object o) {
		if(this==o)
			return 0;
		
		if(!(o instanceof ComparableCircle))
			return 1;
		ComparableCircle cc = (ComparableCircle) o;
		
		if (this.getArea()>cc.getArea()) {
			return 1;
		} else if(this.getArea()<cc.getArea()){
			return -1;
		}
		return 0;
	}
	
	
	
}
abstract class Circle{
	public static final double PI = 3.14;
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea(){
		return PI*radius*radius;
	}
	
	
}
//interface CompareObject{
//	 int compareTo(Object o);
//	
//}