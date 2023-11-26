package Java.lebin.Training.ObjectOriented.DEMOTEST.demo8;

public class TestStaticOverride {
	
	public static void main(String[] args) {
		Father f = new Son();
		f.show();
		
	}

}
class Father{
	
	public static void show(){
		System.out.println("Father show");
	}
}
class Son extends Father{
	public static void show(){
		System.out.println("Son show");
	}
	
}
