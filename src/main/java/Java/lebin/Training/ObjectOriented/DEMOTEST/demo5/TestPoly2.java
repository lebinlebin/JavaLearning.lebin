package Java.lebin.Training.ObjectOriented.DEMOTEST.demo5;
/**
 * 此类用于演示关于属性的多态性
 * @author liulebin
 * 属性：没有重写之说
 * 通过多态访问属性时，属性值要看左边的编译类型！
 *
 */
public class TestPoly2 {
	
	public static void main(String[] args) {
		//使用多态
//		Son f = new Son();
		Father f = new Son();

		f.show();
		
		System.out.println(f.name);
	}

}
class Father{
	
	String name="张翠山";
	
	public void show(){
		System.out.println("father show");
	}
	
}
class Son extends Father{
	String name="张无忌";
	@Override
	public void show(){
		System.out.println("son show");
		System.out.println(super.name);
		System.out.println(this.name);
	}
}
