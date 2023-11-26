package Java.lebin.Training.ObjectOriented.DEMOTEST.demo5;
/**
 * 此类用于演示对象的转型
 * @author liulebin
 * 基本类型的类型转换：
 * 	byte——>short——>int——>long——>float——>double
 * 
 * 	自动类型转换：小——>大
 * 			int i=100;
 * 			long l = i;
 * 	强转类型转换：大——>小
 * 			int j = (int)l;
 * 
 * 引用类型的类型转换：
 * 	前提：类型转换 的两个类必须为父子类！
 * 	向上转型（自动类型转换）
 * 
 * 		语法：
 * 		父类类型  引用名 = new  子类类型();
 * 
 * 		①对象的左右两边的类型（编译类型和运行类型）不一致了，这种现象称为多态
 * 		②=左边的类型称为编译类型，=右边的类型称为运行类型
 * 		③编译看左边，运行看右边
 * 		能调用哪些成员，主要看编译类型中有哪些成员！
 * 		运行的具体的是哪个方法，主要看运行类型中的方法
 * 		
 * 	向下转型（强制类型转换）
 * 
 * 		语法：
 * 		子类类型 引用名 = (子类类型)父类引用;
 * 		特点：
 * 		①只能强转父类的引用，不能强转父类对象
 * 		②只能强转本身就属于该类对象的引用
 * 		③可以调用子类中定义的以及从父类继承来的所有成员
 * 
 *
 */
public class TestPoly {
	
	public static void main(String[] args) {
		
		//子类——>父类
//	 	向上转型（自动类型转换）:小——>大
		Animal a =new Cat();
		//可以调用哪些成员
		a.eat();
		a.run();
		a.age=10;
		a.name="";
		a.method();
//		a.climb();
	 	 		
//	 	向下转型（强制类型转换）
		Cat c = (Cat) a;
//		Cat c2 = (Cat)(new Animal()); 	//①只能强转父类的引用，不能强转父类的对象
		
//		Animal b = new Pig();
//		Cat c3 = (Cat)b;
		//可以调用哪些成员？
		c.run();
		c.eat();
		c.climb();
		c.method();
		c.name="";
		c.age=1;
		c.color="";
	}

}

class Animal{
	String name;
	int age;
	public void eat(){
		System.out.println("动物的吃");
	}
	public void run(){
		System.out.println("动物的跑");
	}
	public void method(){
		System.out.println("method");
	}
	
	
}

class Pig extends Animal{
	
}
class Dog extends Animal{
	@Override
	public void eat(){
		System.out.println("狗吃骨头");
	}
}
class Cat extends Animal{
	
	String color;
	@Override
	public void run(){
		System.out.println("猫飞快的跑");
	}
	
	public void climb(){
		System.out.println("猫爬树");
	}
	@Override
	public void eat(){
		System.out.println("猫吃鱼");
	}
}