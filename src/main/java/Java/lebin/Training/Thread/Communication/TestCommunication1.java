package Java.lebin.Training.Thread.Communication;

/**
 * 此类用于演示线程的通信
 * @author liulebin
 * 
 * 案例：一个生产者和一个消费者
 * 
 * 
 *
 */
public class TestCommunication1 {
	
	public static void main(String[] args) {
		Clerk c = new Clerk();
		
		Productor p = new Productor(c);
		p.start();
		
		Consumer con = new Consumer(c);
		con.start();
	}

}


class Consumer extends Thread{
	private Clerk c;

	/**
	 * 构造器传值
	 * @param c
	 */
	public Consumer(Clerk c){
		this.c=c;
	}
	@Override
	public void run() {
		
		while(true){
			//消费产品（调用Clerk对象的get方法）
			c.get();
		}
	}
}


class Productor extends Thread{
	
	private Clerk c;
	public Productor(Clerk c){
		this.c=c;
	}
	@Override
	public void run() {
		
		while(true){
			//生产产品（调用Clerk对象的save方法）
			c.save();
			
		}
	}
	
	
}


class Clerk{
	int count = 0;//产品数量
	//生产
	public synchronized void save(){//默认锁对象：this
		if(count >= 100){
			//库存已满
			//等待
			try {
				this.wait();//锁对象为this，wait和notify必须是锁对象调用
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者生产了一件产品，目前库存为："+(++count));
		
		this.notify();//唤醒消费者线程去消费
	}
	
	
	//消费
	public synchronized void get(){
		
		if(count <= 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者消费了一件产品，目前库存为："+(--count));
		this.notify();//唤醒生产者去生产
	}
}