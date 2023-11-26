package Java.lebin.Training.Thread.synchronize;

//1.打印1——100，通过两个线程，实现一一交替
//线程同步
public class AlternatePrintingSyn {
	public static void main(String[] args) {
		Print p=new Print();
		Thread t1 = new Thread(p);
		t1.setName("进程1");
		Thread t2 = new Thread(p);
		t2.setName("进程2");
		t1.start();
		t2.start();
	}
}

class Print implements Runnable{
	private int i=1;
	@Override
	public void run() {
		synchronized (this) {			
			while (true) {
				notify();//线程激活
				if(i>100) {
					break;
				}				
				System.out.println(Thread.currentThread().getName()+"\t"+(i++));
				try {
					wait();//当前新城等待。wait的调用 会导致锁的释放
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}