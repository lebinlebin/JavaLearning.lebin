package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo2StaticMethod;
/**
 * 此类用于演示静态属性的特点
 * @author liulebin
 * 1.静态属性 被所有对象所共享的属性，其中一个对象对其更改，影响另外的对象
 *   普通属性 被对象所独享的属性，其中一个对象对其更改，不影响另外的对象
 * 2.生命周期不同
 * 	 静态属性 随着类的加载而加载（开辟空间），随着类的消亡而消亡
 *   普通属性 随着对象的创建而加载（开辟空间），随着对象的消亡而消亡
 *   
 *  3.存储位置不同
 *   静态属性存储在方法区
 *   普通属性存储在堆中
 *   
 *  4.静态属性和对象无关，属于类成员，所以也称为类属性，可以直接通过类名调用,也可以通过对象调用，但不建议
 *    普通属性和对象有关，属于实例成员，不能直接通过类名调用，必须通过对象调用
 *    
 *  5、静态属性在内存中只有一份，因为类只加载一次
 *    普通属性在内存中可以有多份，根据对象的个数决定
 *    
 *  6、从设计上来讲
 *  	当该类的某属性所有对象都具有同样的值，而且不轻易更改，这样的属性建议设计成静态属性
 *  
 *  	示例：圆周率：3.14，利率
 */
public class TestStaticField {
	
	public static void main(String[] args) {
		Person p1 = new Person("柳岩","中国");
		System.out.println(p1);
		
		Person p2 = new Person("特朗普","美国");//更改了静态变量，会影响其他对象
		System.out.println(p2);
		System.out.println(p1);
		
		//调用普通属性
		System.out.println(p1.name);
		//调用静态属性
		System.out.println(Person.nation);
		System.out.println(p1.nation);
		
	}

}
class Person{
	String name;
	static String nation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getNation() {
		return nation;
	}
	public static void setNation(String nation) {
		Person.nation = nation;
	}
	public Person(String name,String nation) {
		super();
		this.name = name;
		this.nation=nation;
	}
	@Override
	public String toString(){
		return name+"\t"+nation;
	}
	
}