package Java.lebin.Training.Thread.synchronize;
/*
模拟银行取钱的问题
1.定义一个Account类
1）该Account类封装了账户编号（String）和余额（double）两个属性
2）设置相应属性的getter和setter方法
3）提供无参和有两个参数的构造器
Deposit, Withdraw 两个线程

 再写存钱线程和取钱线程
 取钱线程不断取钱, 每次取1000以内随机的钱,如果不够,则等待
 存钱线程也不断存钱,每次存1000以内随机的钱,存完以后,通知取钱线程,并睡眠2秒钟
 余额不允许出现0或负数.

 */
public class TestCommunication {
	
	public static void main(String[] args) {
		Account acc = new Account("张无忌",100000);
		
		Deposit d = new Deposit(acc);
		d.start();
		
		WithDraw1 w = new WithDraw1(acc);
		w.start();
	}

}

class WithDraw1 extends Thread{
	Account acc;
	public WithDraw1(Account acc){
		this.acc=acc;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (acc) {
				int money = (int) (Math.random() * 1001);
				while (money >= acc.getMoney()) {
					try {
						acc.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				acc.setMoney(acc.getMoney() - money);
				System.out.println(Thread.currentThread().getName() + "取了￥" + money + ",账户余额：￥" + acc.getMoney());
			}
					
					
		}
	}
	
}
//存钱
class Deposit extends Thread{
	Account acc;
	public Deposit(Account acc){
		this.acc=acc;
	}
	
	@Override
	public void run() {
		
		while(true){
			synchronized (acc) {
				int money = (int) (Math.random() * 1001);
				acc.setMoney(acc.getMoney() + money);
				System.out.println(Thread.currentThread().getName() + "存了￥" + money + ",账户余额：" + acc.getMoney());
				acc.notify();//唤醒其他线程
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		}
	}
	
}

class Account{
	private String accNo;
	private double money;
	@Override
	public String toString(){
		return accNo+":￥"+money;
	}
	
	public Account() {
		super();
	}
	public Account(String accNo, double money) {
		super();
		this.accNo = accNo;
		this.money = money;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}