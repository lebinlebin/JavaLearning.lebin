package Java.lebin.Training.ObjectOriented.day9Inheritance.demo3;

public class TestSuper {
	public static void main(String[] args) {
		
		Son s = new Son();
//		s.show();
		s.method();
	}

}
//爷爷类
class Grand{
	public Grand(){
		super();
		System.out.println("Grand");
	}
	int height=180;
	
}
//父类
class Father extends Grand{
	
	public Father(){
		super();
		System.out.println("Father");
	}
	String name="张翠山";
	int age=1000;
	int height=160;
	
	public void show(){
		System.out.println("我是父类");
	}
	
	public int getHeight(){
		return super.height;
	}
	
	
}
//子类
class Son extends Father{
	
	public Son(){
		super();
		System.out.println("Son");
	}
	String name="张无忌";
	int height=120;
	
	
	public void method(){
//		this.name="张无忌子";
//		System.out.println("super.name:"+super.name);
//		System.out.println("this.name:"+this.name);
		
		
		this.age=999;
		System.out.println("super.age:"+super.age);
		System.out.println("this.age:"+this.age);
		
	}
	@Override
	public void show(){
//		super.show();
//		System.out.println(super.name+"\t"+age);
		
		System.out.println(super.height);
	}
	
	
	
}