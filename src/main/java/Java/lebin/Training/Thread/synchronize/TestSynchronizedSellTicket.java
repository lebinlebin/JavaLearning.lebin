package Java.lebin.Training.Thread.synchronize;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 此类用于演示线程的同步问题
 * @author liulebin
 *
 */
public class TestSynchronizedSellTicket {
	
	public static void main(String[] args) {
		SellTicket2 s = new SellTicket2();
		Thread t1 = new Thread(s);
		t1.setName("窗口A");
		t1.start();
		
		Thread t2 = new Thread(s);
		t2.setName("窗口B");
		t2.start();
		
		
		Thread t3 = new Thread(s);
		t3.setName("窗口C");
		t3.start();

		/**
		 * 线程池方法
		 */
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

		singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
		singleThreadPool.shutdown();

	}

}
//方式二：使用同步方法实现同步
class SellTicket2 implements Runnable{
	 int tickets = 100;//总票数
	 
	 boolean loop=true;
		@Override
		public void run() {
			while(loop){
				sellTicket();
			}
		}
		private synchronized void sellTicket() {
			if (tickets <= 0) {
				System.out.println("票已经售完！");
				loop=false;
				return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖了一张票，票数余额：" + (--tickets));
		}
		
		
}

//方式一：使用同步代码块实现同步
class SellTicket implements Runnable{
	 int tickets = 100;//总票数
		@Override
		public void run() {
			while(true){
				// 普通同步方法，锁对象：this//锁对象要求多个线程使用的锁对象必须是同一个。
				synchronized (this) {
					if (tickets <= 0) {
						System.out.println("票已经售完！");
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "卖了一张票，票数余额：" + (--tickets));
				}
			}
			
		}
}
