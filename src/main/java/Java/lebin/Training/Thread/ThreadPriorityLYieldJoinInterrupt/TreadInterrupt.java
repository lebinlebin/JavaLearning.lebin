package Java.lebin.Training.Thread.ThreadPriorityLYieldJoinInterrupt;
/**
 * 此类用于演示线程的常见方法二：
 * @author liulebin
 * sleep和interupt
 * sleep:让当前线程休眠指定毫秒数，参数单位：ms,是一个静态方法，可以直接通过类名调用。
 * 一般来讲，用于模拟线程交错效果
 * interrupt：中断线程的休眠、等待状态，如果中断的线程正在休眠，则会抛InterruptedException
 * 线程优先级默认与创建它的线程的优先级相同
 */
public class TreadInterrupt {
	
	public static void main(String[] args) {
		//main 的优先级是5
		System.out.println("main:"+Thread.currentThread().getPriority());
		SleepThread st = new SleepThread();
		st.start();
		System.out.println("st:"+st.getPriority());
		
		for(int i=1;i<=100;i++){
			System.out.println("岳灵珊小师妹在练剑"+i);
			if(i==10){
				st.interrupt();
				break;
			}
		}
	}

}

class SleepThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=1;i<=50;i++){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.out.println("令狐冲睡醒啦，开始好好学习");//里面就可以做一些事情了、
				break;
			}
			
		}
		
	}
}