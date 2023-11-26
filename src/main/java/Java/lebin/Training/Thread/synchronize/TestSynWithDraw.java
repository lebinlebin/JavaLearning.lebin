package Java.lebin.Training.Thread.synchronize;
/**
 * 本文件测试线程的同步
 * 有2个账户分别向同一个卡上取钱（10000），每次都取1000
 * @author liulebin
 *
 * 第一步：将需要上锁的代码分析出来
 * 第二步：将代码用 synchronized 包起来
 * 这里两个线程可能会导致最后只有一个抢到了，都是一个人在取钱。
 */
public class TestSynWithDraw {
	
	public static void main(String[] args) {
		
		WithDraw w1 = new WithDraw();
		Thread t1 = new Thread(w1);
		t1.setName("周芷若");
		t1.start();
		
		
		Thread t2 = new Thread(w1);
		t2.setName("赵敏");
		t2.start();
	}

}

/**
 * 如果不设置synchronized，那么会造成线程抢占
 */
class WithDraw implements Runnable{
	int money = 10000;
	@Override
	public void run() {
		while(true){
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
			}
			
			
		}
		
	}
	
}