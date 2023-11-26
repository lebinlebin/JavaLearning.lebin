package Java.lebin.Training.Thread.TreadAndRunnable;

/**
 * 此类用于演示线程的创建并启动
 * @author liulebin
 *2 创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数
 */

public class TestThreadStart {
	
	public static void main(String[] args) {
		//创建子线程1
		A a = new A();
		a.start();

		//创建子线程2
		new Thread(new B()).start();
	}
}

class A extends Thread{
	
	@Override
	public void run() {
		
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (i%2==0) {
				System.out.println("----------------------"+i);
			}
		}
	}
}

class B implements Runnable{
	@Override
	public void run() {
	    //编写新线程的任务体
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i%2!=0) {
				System.out.println(i);
			}
		}
		
		
	}
}