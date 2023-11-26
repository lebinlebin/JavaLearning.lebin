package Java.lebin.Training.ObjectOriented.day9Inheritance.demo4;
/**
 * 此类用于演示方法的重写
 * @author liulebin
 * 要求：
 * 
 * 1、发生在父子类
 * 2、方法名必须相同
 * 3、参数列表必须相同
 * 4、返回类型相同或子类方法的返回为父类方法返回类型的子类型（jdk5.0）
 * 5、修饰符相同或权限更大
 *
 */
public class TestOverride {
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.eat();
	}

}


class Animal{
	 Object eat(){
		System.out.println("动物吃");
		return 0;
	}
}
class Dog extends Animal{
	@Override
	 String eat(){
		System.out.println("狗吃骨头");
		return null;
	}
	
}