package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.homework;
/*
 * 三、多态参数：有一个显示器接口Graphoscope，具有display方法，
 * 有两个类：台式显示器和液晶显示器都实现显示器接口，有Computer类，
 * 有个测试显示器testGraphoscope的方法，要求传入显示器接口对象，测试显示功能，生产两台电脑，
 * 分别配置台式显示器和液晶显示器。查看是否正常运行
 */
public class TestGraphoscope {
	
	public static void main(String[] args) {
		Computer c1  = new Computer();
		c1.testGraphoscope(new Tai());
		
		Computer c2 = new Computer();
		c2.testGraphoscope(new Ye());
		
	}

}
class Computer{
	public void testGraphoscope(Graphoscope gs){
		gs.display();
	}
}
class Ye implements Graphoscope{

	@Override
	public void display() {
		System.out.println("我是液晶显示器");
		
	}
	
}
class Tai implements Graphoscope{

	@Override
	public void display() {
		System.out.println("我是台式显示器");
		
	}
	
}
interface Graphoscope{
	void display();
}