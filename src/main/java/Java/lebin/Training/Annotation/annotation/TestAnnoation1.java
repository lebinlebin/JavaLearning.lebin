package Java.lebin.Training.Annotation.annotation;

public class TestAnnoation1 {
	
	public static void main(String[] args) {
		Father2 f = new Sub();
		f.ol();
	}

}
class Sub extends Father2{
//	@Override
	public void o1(){
		System.out.println("Sub 方法");
	}
	
}

class Father2{
	public void ol(){
		System.out.println("Father 方法");
	}
}