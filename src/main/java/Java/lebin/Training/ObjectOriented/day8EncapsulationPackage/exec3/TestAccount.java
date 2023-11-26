package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.exec3;
/**
 * 1.创建程序,在其中定义两个类：Account和AccountTest类体会Java的封装性。
Account类要求具有属性：姓名（长度为2位3位或4位）、余额(必须>20)、密码（必须是六位）
并在AccountTest中测试

String  name=“”;
int len = name.length();

 * @author liyuting
 *
 */
public class TestAccount {
	
	public static void main(String[] args) {
		
		Account acc=new Account();
		acc.setName("张三丰");
		acc.setPwd("1234");
		acc.setMoney(10);
		
		System.out.println(acc.getName()+"\t"+acc.getPwd()+"\t"+acc.getMoney());
	}

}
