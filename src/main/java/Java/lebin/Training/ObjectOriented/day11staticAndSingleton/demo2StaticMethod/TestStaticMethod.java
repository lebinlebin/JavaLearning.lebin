package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo2StaticMethod;
/**
 * 此类用于演示静态方法的特点
 * @author liulebin
 * 1.静态方法和普通方法都是随着类的加载而加载
 * 2.静态方法和普通方法的存储位置都是：方法区
 * 3.不同点 ★
 * 	静态方法 存储时的参数列表：没有this
 *  普通方法 存储时的参数列表：有this
 *  所以：
 *  静态方法可以不通过对象调用
 *  普通方法必须通过对象调用，因为这样才能保证形参和实参的列表一致
 *  
 *  4.谁可以调用？ ★
 *  静态方法可以不通过对象调用，直接通过类名调用
 *  普通方法必须通过对象调用，因为这样才能保证形参和实参的列表一致
 *  
 *  5.静态方法可以直接调用谁？可以直接调用静态成员，但不能直接调用普通成员，除非新创建对象再去调用。
 *    普通方法可以直接调用谁？可以直接调用任意成员，包含普通成员和静态成员！
 *    
 *  6.静态方法中不允许使用this和super关键字
 *  
 *  7.从设计上来讲
 *  
 *  当某个方法中不涉及到任何和对象相关的成员时，一般将该方法设计成静态方法。因为这样的话，调用比较方便！
 *  
 *  示例：
 *  	Math类的方法
 *  	Arrays类的方法
 */
public class TestStaticMethod {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.show(100);
		
//		Animal.method();
//		Animal.show();
	}
	
}
class Animal{
	String name;
	static int age;
	public void show(int a){
		//this
		System.out.println(name);
		System.out.println(age);
		method();
		show2();
		System.out.println("我是普通方法："+a);
	}
	public static void method(){
		Animal ani = new Animal();
		System.out.println("我是静态方法");
		System.out.println(ani.name);//普通属性，必须声明对象，然后通过对象调用
		System.out.println(age);//静态成员
		ani.show2();//普通方法
//		show2();//不能直接调用。普通方法，不能被静态方法直接调用。
//		this.name="";
	}
	public void show2(){
		
	}
}