package Java.lebin.Training.Thread.synchronize;
//2:模拟一个人生产50个玩具，每200毫秒生产一个，当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
public class TestHomework1 {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		Producer pro = new Producer(p );
		pro.start();
		
		EatBread eat = new EatBread(p);
		eat.start();
	}

}
class Person{
	
	boolean flag = true;
	
	//吃馒头
	public synchronized void eat(){
		
			if(!flag){
				for(int i=1;i<=3;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("吃了第"+i+"个馒头");
				}
				
				this.notify();
				
			
			}
		
		
		
	}
	//生产玩具
	public synchronized void product(){
		
		for(int i=1;i<=50;i++){
			if(i==21){
				flag = false;
				
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("生产了一个玩具，目前个数为："+i);
			
			
		}
		
	}
	
	
}


class Producer extends Thread{
	private Person p;

	public Producer(Person p){
		this.p=p;
	}
	
	
	@Override
	public void run() {
		
		p.product();
	}
	
}
class EatBread extends Thread{
	private Person p;

	public EatBread(Person p){
		this.p=p;
	}
	
	
	@Override
	public void run() {
			p.eat();
	}
	
}
