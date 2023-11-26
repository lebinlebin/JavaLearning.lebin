package Java.lebin.Training.Thread.synchronize;

/**
 * 此类用于演示线程的通信
 * 
 * @author liulebin
 *
 */
public class TestCommunicationWithDraw {
	public static void main(String[] args) {
		WithDraw2 w1 = new WithDraw2();
		Thread t1 = new Thread(w1);
		t1.setName("周芷若");
		t1.start();

		Thread t2 = new Thread(w1);
		t2.setName("赵敏");
		t2.start();
	}

}

class WithDraw2 implements Runnable {
	int money = 10000;

	@Override
	public void run() {

		while (true) {
			synchronized (this) {
				if (money <= 0) {
					System.out.println("钱已经取完");
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "取了1000，还剩余：" + (money -= 1000));
				
				//通知对方线程可以取钱了
				this.notify();
				
				//当前线程等待
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}