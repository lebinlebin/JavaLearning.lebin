package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.exec3;
/**
 * 此类用于演示接口的应用
 * @author liulebin
 * 
 * 接口依然可以应用在多态上：
 * 	向上转型
 * 		接口	名 = new  实现类();
 * 	向下转型
 * 		实现类 名 =(实现类)接口引用;
 *	多态数组
 *  多态参数
 */
public class TestInterface2 {

	
	public static void main(String[] args) {
		Computer com = new Computer();
		com.work(new Flash());
		com.work(new Printer());
//		
		//多态数组
		
		USB[] usbs = new USB[2];
		usbs[0]=new Flash();
		usbs[1] = new Printer();
		for (int i = 0; i < usbs.length; i++) {
			usbs[i].start();
		}
	}
}
class Computer{
	/**
	 * 多态参数
	 * @param usb
	 */
	public void work(USB usb){//USB usb = new Flash();
		
		usb.start();
		usb.stop();
		
		
	}
}
interface USB{
	void start();
	void stop();
}
class Printer implements USB{

	@Override
	public void start() {
		System.out.println("打印机开始工作了~~");
		
	}

	@Override
	public void stop() {
		System.out.println("打印机停止工作了~~");
		
	}
	
}
class Flash implements USB{

	@Override
	public void start() {
		System.out.println("u盘启动了");
		
	}

	@Override
	public void stop() {
		System.out.println("u盘已经成功拔出");
		
	}
	
}