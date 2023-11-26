package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.exec2;
/**
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，定义封装这些属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。

 * @author liulebin
 *
 */
public class TestAccount {
	
	public static void main(String[] args) {
		
		Account a1 = new Account("123456",100);
		System.out.println(a1);
		
		Account a2 = new Account("888888",100);
		System.out.println(a2);
		
		Account a3 = new Account("999999",100);
		System.out.println(a3);
		
		Account a4 = new Account("123456",100);
		System.out.println(a4);
	}

}


class Account{
	
	private String  accountNo;//账户
	private String pwd;//密码
	private double money;//余额
	private static double rate = 0.0024;//利率
	private static double minBalance=10;//最小余额
	
	private static int currentNum = 100000;

	@Override
	public String toString(){
		return accountNo+"\t"+pwd+"\t"+money;
	}
	
	public Account(String pwd, double money) {
		super();
		this.pwd = pwd;
		this.money = money;

		this.accountNo="95599 "+currentNum++;
		
	}
	
	public static double getRate() {
		return rate;
	}
	public static double getMinBalance() {
		return minBalance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}