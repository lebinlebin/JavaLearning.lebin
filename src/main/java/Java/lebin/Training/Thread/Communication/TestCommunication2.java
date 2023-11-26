package Java.lebin.Training.Thread.Communication;


/**
 * 此类用于演示线程的通信
 * @author liulebin
 * 
 * 案例：多个生产者和多个消费者
 * 修改：
 * ①notify——>notifyAll
 * ②wait的条件判断，改成循环判断 if=>whlie
 * 
 *
 */
public class TestCommunication2 {
	
	public static void main(String[] args) {
		Clerk2 c = new Clerk2();
		
		Productor2 p1 = new Productor2(c,"张无忌");
		p1.start();
		
		Productor2 p2 = new Productor2(c,"令狐冲");
		p2.start();
		
		Consumer2 con1 = new Consumer2(c,"赵敏");
		con1.start();
		Consumer2 con2 = new Consumer2(c,"小昭");
		con2.start();
		Consumer2 con3 = new Consumer2(c,"依琳小师妹");
		con3.start();
	}

}
class Consumer2 extends Thread{
	private Clerk2 c;
	public Consumer2(Clerk2 c,String name){
		super(name);
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

class Productor2 extends Thread{
	
	private Clerk2 c;
	public Productor2(Clerk2 c,String name){
		super(name);
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


class Clerk2{
	int count = 0;//产品数量
	//生产
	public synchronized void save(){//默认锁对象：this
		//将之前if换成while。
		//因为，notifyAll，唤醒其他正在等待的所有线程，生产者唤醒的可能还是生产者；需要一直判断
		while(count>=20){ //库存已满
			//等待
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
		System.out.println(Thread.currentThread().getName()+"生产了一件产品，目前库存为："+(++count));
		this.notifyAll();//唤醒其他正在等待的所有线程，生产者唤醒的可能还是生产者
	}
	
	
	//消费
	public synchronized void get(){
		
		while(count<=0){
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
		System.out.println(Thread.currentThread().getName()+"消费了一件产品，目前库存为："+(--count));
		
		this.notifyAll();//唤醒其他正在等待的所有线程，消费者线程可能唤醒的还是消费者
		
	}
	
	
}