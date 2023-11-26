package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.exec3;

public class Account {

	
	private  String name;
	private String  pwd;
	private double money;
	
	public void setName(String n){
		int len = n.length();
		if(len==2||len==3||len==4){
			name=n;
		}else{
			name="匿名";
			System.out.println("姓名无效！");
		}
		
	}
	public String getName(){
		return name;
	}
	
	
	public void setPwd(String p){
		if(p.length()==6){
			pwd=p;
		}else{
			pwd="000000";
			System.out.println("密码无效");
		}
	}
	public String getPwd(){
		return pwd;
	}
	
	public void setMoney(double m){
		if(m>20){
			money=m;
		}else{
			money=0;
			System.out.println("余额无效");
		}
	}
	public double getMoney(){
		return money;
	}
}
