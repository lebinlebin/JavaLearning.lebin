package Java.lebin.Training.ObjectOriented.DEMOTEST.demo1;
/**
 * 此类用于演示方法的传参
 * @author liulebin
 * 基本类型做参数，传递的是值，形参的改变不影响实参
	引用类型做参数，传递的是地址，形参的改变（成员）影响实参

	【面试题】java中方法的参数传递的是什么？
	java中，方法参数是按值传递！
	如果是基本类型，则值 代表元素内容
	如果是引用类型，则值 代表地址号


	注意：
	当引用类型做参数时，如果形参改变的是地址，则最终不影响实参
 *
 */
public class TestIntentArgs {

	public static void main(String[] args) {
		
		MethodUtils2 mu = new MethodUtils2();
		Person p1 = new Person();
		p1.name="张无忌";
				
		mu.method(p1);
		System.out.println(p1.name);
	}
}


class MethodUtils2{
	
	public void method(Person person){
		person = new Person();
		person.name="john";
		System.out.println("------------"+person.name);
		
	}
	
}
class Person{
	String name;
}