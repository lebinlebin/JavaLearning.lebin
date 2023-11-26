package Java.lebin.Training.Thread.ThreadPriorityLYieldJoinInterrupt;
/**
 * 此类用于演示线程的常见方法一：
 * @author liulebin
 * 
 * setName
 * getName
 * 
 * currentThread:获取当前线程对象，是一个静态方法，直接用类名调用即可
 * 
 * 
 * 注意：新线程没有设置名称，也有默认名。
 * 		Thread-0
 * 		Thread-1
 * 		...
 *
 */
public class TestThreadMethod1 {
	
	public static void main(String[] args) {
		A a = new A("小黄");//方式一
//		a.setName("小黄");//方式二
//		a.start();
		a.run();
	}

}

class A extends Thread{
	
	public A(String name){
		super(name);
	}
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			System.out.println(getName()+"----"+i);
		}
	}
}
