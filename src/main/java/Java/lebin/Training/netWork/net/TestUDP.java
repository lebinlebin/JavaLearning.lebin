package Java.lebin.Training.netWork.net;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 此类用于演示基于UDP的网络通信
 * 
 * @author liyuting
 *
 */
public class TestUDP {
	


	// 发送端
	@Test
	public void testSend() throws IOException {
		
		//1.创建DatagramSocket套接字对象
		DatagramSocket socket = new DatagramSocket(7777);
		//-------------------------发送数据-------------------------------------
		
		//①.创建DatagramPacket对象，用于包装要发送的数据
		byte[] buf="嗨,我是土豆".getBytes();
		DatagramPacket packet = new DatagramPacket(buf,buf.length,InetAddress.getLocalHost(),6666);
		
		//②.发送
		
		socket.send(packet);
		
		//-------------------------接收数据-------------------------------------
		
			//①.创建DatagramPacket对象，用于接受要发来的数据
			
			byte[] buf2 = new byte[1024];
			DatagramPacket packet2 = new DatagramPacket(buf2 , buf2.length);
			
			
			//②.接受数据并处理
			socket.receive(packet2);
			
			String data = new String(packet2.getData(),0,packet2.getLength());
			
			System.out.println(data);
		
		
		//4.关闭
		socket.close();
		
		
		

	}

	// 接受端
	@Test
	public void testReceive() throws IOException {
		//1.创建DatagramSocket套接字对象
		DatagramSocket socket = new DatagramSocket(6666);
		
		//-------------------------接收数据-------------------------------------
	
		//①.创建DatagramPacket对象，用于接受要发来的数据
		
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf , buf.length);
		
		
		//②.接受数据并处理
		socket.receive(packet);
		
		String data = new String(packet.getData(),0,packet.getLength());
		
		System.out.println(data);
		
		
		//-------------------------发送数据-------------------------------------
		
		
		//①.创建DatagramPacket对象，用于包装要发送的数据
				byte[] buf2="嗨,我是地瓜".getBytes();
				DatagramPacket packet2 = new DatagramPacket(buf2,buf2.length,InetAddress.getLocalHost(),7777);
				
				//②.发送
				
				socket.send(packet2);
		
		//4.关闭
		socket.close();
		
		
		
		
		
		

	}
}
