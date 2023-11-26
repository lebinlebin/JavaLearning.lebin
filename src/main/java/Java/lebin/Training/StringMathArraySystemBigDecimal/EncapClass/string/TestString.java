package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.string;

public class TestString {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "atguigu";

		Person p2 = new Person();
		p2.name = "atguigu";

		System.out.println(p1.name .equals( p2.name));
		System.out.println(p1.name == p2.name);
		System.out.println(p1.name == "atguigu");
		
		
		String a = "hello";
		String b = "abc";
		
		String c = a+b;
		
		System.out.println(c);

	}

}
class Person{
	String name;
}