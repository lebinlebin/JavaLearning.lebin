package Java.lebin.Training.ObjectOriented.day9Inheritance.demo3;

/**
 * 此类用于演示继承的特点和使用
 * @author liulebin
 *
 */

public class TestInherit {
	public void show(){
		
	}
	public static void main(String[] args) {
		Dog d = new Dog();
		d.age=12;//缺省  可以访问父类的成员
//		d.name="";//private 无法访问
		d.color="";//protected 可以访问父类的成员
		d.weight=100;//public
		
		
		
	}

}


