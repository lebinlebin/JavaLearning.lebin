package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.innerClass;
/**
 * 此类用于演示内部类：静态内部类的特点和使用
 * @author liulebin
 * 特点：
 * ①类中可以有任意五大成员，包含普通和静态
 * ②可以添加任意访问修饰符，遵循访问权限限定！
 * ③互访原则：
 * 内部类————>外部类
 * 		可以直接访问外部类的静态成员，包含私有的，但不能直接访问外部类的普通成员（遵循静态成员的特点）
 * 
 * 外部类————>内部类
 * 		不能直接访问，必须通过创建内部类对象去访问，包含私有的！
 * 		语法：new 内部类对象().方法();
 * 		
 * 
 * 外部其他类——>内部类
 * 		不能直接访问，必须通过创建内部类对象去访问，必须遵守访问权限限定，不包含私有的！
 * 		语法：new 外部类.内部类().方法();
 * 
 * ④当外部类和内部类成员重名时，默认访问内部类的成员，遵循就近原则，如果非要访问外部类的成员,可以通过外部类名.成员 的方式！
 * 
 */
public class TestInner2 {
	public static void main(String[] args) {
		new Outer2.Inner2().show();
	}

}
class Outer2{
	
	private static String name="段正淳";
	//静态内部类
	public static class Inner2{
		String name = "段誉";
		private  int age;
		public void show(){
			System.out.println(Outer2.name);
		}
		static{}
		public Inner2(){}
		static class InnerInner{}
	}
	//外部类的方法
	public void method(){
		new Inner2().show();
		new Inner2().age=12;
		
	}
	
}