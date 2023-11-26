package Java.lebin.Training.Thread.ThreadPriorityLYieldJoinInterrupt;
/**
 * 此类用于演示线程的常见方法四：
 * @author liulebin
 * 
 * yield:线程的礼让，但是礼让的时间不确定。 是一个静态方法，直接通过类名调用即可
 * join：线程的插队，当前线程已经抢到cpu占用权，让其他线程插队在自己前面执行
 * 				如果其他线程插队成功，则肯定其他线程先执行完
 * 				注意：其他线程有可能没有插队成功
 */

public class ThreadYieldAndJoin {
	
	public static void main(String[] args) {

		//线程中主要做了字符串的拼接，打印字符串拼接的耗时长短
		YieldDemo yd = new YieldDemo();
		yd.start();//礼让应该比不礼让耗时间
		
		JoinDemo jd = new JoinDemo();
		jd.start();

		for(int i=1; i <= 500; i++){
			System.out.println("马兰伟在买包子~~"+i);
			if(i>= 5){
				try {
					jd.join();//让jd线程插队在当前线程前面去，先执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
class JoinDemo extends Thread{
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("王腾飞要买包子~~"+i);
		}
		
	}
}
class YieldDemo extends Thread{
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		
		String str="";
		for(int i=1;i<=5000;i++){
			str+="hello"+i;
			Thread.yield();//让当前线程礼让
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时时间："+(end-start));
	}
	
}