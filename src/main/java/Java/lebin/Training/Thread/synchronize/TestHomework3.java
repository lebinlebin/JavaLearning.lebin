package Java.lebin.Training.Thread.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * 4：编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
在main线程中，唤醒interrupt上述睡眠的线程，使其尽快打印集合内容。
 * @author liyuting
 *
 */
public class TestHomework3 {
	
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		p.start();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		p.interrupt();
	}

}
class PrintNum extends Thread{
	
	@Override
	public void run() {
		
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep((int)(Math.random()*200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int num = (int)(Math.random()*101);
			System.out.println(num);
			
			list.add(num);
			
		}
		
		//睡眠30s
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			//打印集合中的内容
			System.out.println("-------------------");
			for (Integer i : list) {
				System.out.print(i+"\t");
			}
		}
		
		
		
		
		
		
	}
}