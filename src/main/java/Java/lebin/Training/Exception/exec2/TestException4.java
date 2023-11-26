package Java.lebin.Training.Exception.exec2;

import java.util.Scanner;

/**
 * 实现登录验证
输入用户名 和密码，判断是否 为“john”和“000”
如果用户名输入错误，生成错误信息为“用户名不存在”的异常对象
如果用户名正确，密码输入错误，生成错误信息为“密码不正确”的异常对象

 * @author liyuting
 *
 */
public class TestException4 {
	
	
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String name = input.next();
		System.out.print("请输入密码：");
		String pwd = input.next();
		
		try {
			verifyUser(name, pwd);
			System.out.println("登录成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	/**
	 * 功能：验证是否登录成功
	 * @param name
	 * @param pwd
	 * @return 如果登录成功，则返回true，否则返回 异常信息
	 */
	public static void verifyUser(String name,String pwd) throws LoginException{
		
		if(!name.equals("john"))
			throw new LoginException("用户名不存在！");
		if(!pwd.equals("000"))
			throw new LoginException("密码不正确！");
		
	}

}


class LoginException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
