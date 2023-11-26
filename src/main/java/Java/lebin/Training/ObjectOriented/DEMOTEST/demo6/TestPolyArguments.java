package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;
/**
 * 此类用于演示多态参数的使用
 * @author liulebin
 * 类型转换
 */
public class TestPolyArguments {
	
	
	public static void main(String[] args) {
		TestPolyArguments test = new TestPolyArguments();
		test.method2(new Person("段誉",20));
		test.method2(new Student("王语嫣", 12, 100));
		test.method2(new Teacher("无崖子", 12, 10000));
		
	}
	/**
	 * 功能：测试不同人的特有的功能
	 * @param per
	 */
	public void method2(Person per){
		if(per instanceof Student){
			Student s = (Student)per;
			s.study();
		}else if(per instanceof Teacher){
			Teacher t = (Teacher)per;
			t.teach();
		}else{
			per.work();
		}
		
	}
	/**
	 * 功能：测试不同人的getInfo方法
	 * 
	 */
	//方法：可以实现对person对象的getInfo方法调用
	public  void method(Person per){
		System.out.println(per.getInfo());
	}
}
