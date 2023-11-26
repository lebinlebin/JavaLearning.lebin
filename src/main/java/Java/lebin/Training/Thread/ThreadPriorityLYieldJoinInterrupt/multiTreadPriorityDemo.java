package Java.lebin.Training.Thread.ThreadPriorityLYieldJoinInterrupt;
/**
 * 此类用于演示线程的常见方法三：
 * @author liulebin
 * setPriority:设置优先级 1_10  
 * getPriority：获取优先级
 *优先级数值越大，优先级越高
 * main的优先级是5
 * 具备优先权的线程不一定先执行完。只是优先权高的先完成的概率较大。
 */
public class multiTreadPriorityDemo {
	
	public static void main(String[] args) {
		PriorityDemo pd1 = new PriorityDemo("A");
		pd1.setPriority(Thread.MAX_PRIORITY);
		pd1.start();
		
		
		PriorityDemo pd2 = new PriorityDemo("B");
		pd2.setPriority(Thread.MIN_PRIORITY);
		pd2.start();
		
		
		PriorityDemo pd3 = new PriorityDemo("C");
		pd3.setPriority(Thread.NORM_PRIORITY);
		pd3.start();
		
	}

}
class PriorityDemo extends Thread{
	
	
	public PriorityDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for(int i=1;i<=100;i++){
			//                 默认打印优先级 线程名称都打印出来
			System.out.println(Thread.currentThread()+"-----"+i);
		}
	}
	
}