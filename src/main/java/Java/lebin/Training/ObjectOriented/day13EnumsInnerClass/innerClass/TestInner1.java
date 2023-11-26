package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.innerClass;
/**
 * 此类用于演示内部类：成员内部类的特点和使用
 * @author liulebin
 * 特点：
 * ①类中可以有五大普通成员，不能有静态成员！（因为静态成员随着外部类的加载而加载，但成员内部类随着外部类的对象创建而加载）
 * ②可以添加任意访问修饰符，遵循访问权限限定！
 * ③互访原则：
 * 	内部类————>外部类
 * 		直接访问，包含任意成员（私有的也可以）
 * 	外部类————>内部类
 * 		不能直接访问，需要通过创建内部类对象再去访问，包含任意成员（私有的也可以）
 * 		语法：new Inner().方法();
 *  外部其他类——>内部类
 *  	不能直接访问，需要通过创建内部类对象再去访问，只能访问在权限范围内的成员（私有的不可以！！！）
 *  	语法：new Outer().new Inner().方法();
 *  ④当外部类和内部类成员重名时，默认访问的是内部类的成员，遵循就近原则。如果非要访问外部类的成员，可以通过外部类名.this.成员的方式！
 * 
 *
 */
public class TestInner1 {
	
	String color;
	public static void main(String[] args) {
		Outer o = new Outer();
		o.new Inner().show();
//		o.new Inner().color="";
	}

}
class Outer{
	protected class Inner{
		
		private String name="张无忌";
//		public Inner(){
//			
//		}
//		static{
//			
//		}
//		class InnerInner{
//			class InnerInner2{
//				
//			}
//			
//		}
		public  void show(){
			System.out.println(Outer.this.name);
		}
		
	}
	private String name = "张翠山";
	public void method(){
		new Inner().show();
//		new Inner().color="";
		
	}
	
	
	
	
}