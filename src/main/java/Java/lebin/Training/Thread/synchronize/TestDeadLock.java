package Java.lebin.Training.Thread.synchronize;
/**
 * 此类用于演示线程的死锁问题
 * @author liulebin
 * 案例：绑匪绑了李员外家的千金 ：李小华
 *     李员外：你把小花还给我，我把钱给你
 *     绑匪：你把钱给我，我把小花还给你
 */
public class TestDeadLock {
	
	public static void main(String[] args) {
		
		DeadDemo d1 = new DeadDemo(true);//李员外的线程
		
		DeadDemo d2 = new DeadDemo(false);//绑匪的线程
		
		d1.start();
		d2.start();
		
		
	}

}
class DeadDemo extends Thread{
	static MrLi ml = new MrLi();
	static BadBoy bb = new BadBoy();
	private boolean flag;
	public DeadDemo(boolean flag){
		this.flag = flag;
	}
	@Override
	public void run() {
		if (flag) {
			//执行李员外的线程
			synchronized (bb) {
				ml.say();
				synchronized (ml) {
					ml.get();
				}
			}
			
		} else {//执行绑匪的线程
			
			synchronized (ml) {
				bb.say();
				synchronized (bb) {
					bb.get();
				}
			}
		}
		
		
	}
	
	
}

class BadBoy{
	public void say(){
		System.out.println("绑匪说：你把钱给我，我把小花还给你");
	}
	public void get(){
		System.out.println("绑匪终于拿到了想要的钱！");
	}
	
}

class MrLi{
	
	public void say(){
		System.out.println("李员外说：你把小花还给我，我把钱给你");
	}
	public void get(){
		System.out.println("李员外终于救回了小花");
	}
}