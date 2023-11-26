package Java.lebin.Training.communication.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  此类用于演示InetAddress类的特点和使用
 *   
 *   getLocalHost()
 *   getByName(主机名或ip地址)
 *   getHostName()
 *   getHostAddress()
 * 
 *
 */
public class TestInetAddress {
	
	public static void main(String[] args) throws UnknownHostException {
		
		
		//1.获取InetAddress类的对象
		InetAddress ip1 = InetAddress.getLocalHost();//本机
		
		System.out.println(ip1);
		
		
		InetAddress ip2 = InetAddress.getByName("HPK-PC");//根据主机名或ip地址获取InetAddress对象
		
		System.out.println(ip2);
		
		
		//2.获取InetAddress对象中的主机名或ip地址
		
		System.out.println("主机名："+ip1.getHostName());
		System.out.println("ip地址："+ip1.getHostAddress());
		
		
		
	}

}
