package Java.lebin.Training.Thread.TreadCall;
/**
 * 此类用于演示线程创建并启动方式的区别
 * @author liulebin
 *案例：三个售票窗口卖票
 */
public class TestThreadStartDiffsellticket {
	
	public static void main(String[] args) {
		
		//创建并启动 方式一
		/**
		 * 这种会造成票卖完了还卖的现象
		 * 每一个售票窗口都维护了100张票
		 */
//		SellTicket s1 = new SellTicket();//每次初始化都会使得tickets初始化为100；
//		s1.start();
//
//		SellTicket s2 = new SellTicket();
//		s2.start();
//
//		SellTicket s3 = new SellTicket();
//		s3.start();


		/**
		 * 将tickets声明为静态
		 */
//		SellTicket3 s11 = new SellTicket3();//每次初始化都会使得tickets初始化为100；
//		s11.start();
//
//		SellTicket3 s22 = new SellTicket3();
//		s22.start();
//
//		SellTicket3 s33 = new SellTicket3();
//		s33.start();

		/**
		 * 创建并启动 方式二
		 * SellTicket2的对象只有一份；
		 * 这三份共享了tickets变量
		 */
		
		SellTicket2 st = new SellTicket2();

		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		
		
		
	}

}

//方式二：

class SellTicket2 implements Runnable{
	 int tickets = 100;//总票数
//	static int tickets2 = 100;
		@Override
		public void run() {
			while(true){
				if(tickets<=0){
					System.out.println("票已经售完！");
					break;
				}
				System.out.println(Thread.currentThread().getName()+"卖了一张票，票数余额："+(--tickets));
			}
			
		}
}



//方式一：
class SellTicket extends Thread{
	
   int tickets = 100;//总票数，应该是共享资源；没创建一个线程tickets就会被初始化一次
	@Override
	public void run() {
		while(true){
			if(tickets<=0){
				System.out.println("票已经售完！");
				break;
			}
			//                   获取当前线程的方法
			System.out.println(Thread.currentThread().getName()+"卖了一张票，票数余额："+(--tickets));
		}
		
	}
	
	
}
class SellTicket3 extends Thread{

	//总票数，应该是共享资源；
	//但是利用static的条件是该变量确实与对象无关；而且被声明为static的变量的生存周期较长，是随着类的创建而创建，随着类的消亡而消亡。
	static 	int   tickets = 100;
	@Override
	public void run() {
		while(true){
			if(tickets<=0){
				System.out.println("票已经售完！");
				break;
			}
			//                   获取当前线程的方法
			System.out.println(Thread.currentThread().getName()+"卖了一张票，票数余额："+(--tickets));
		}

	}


}