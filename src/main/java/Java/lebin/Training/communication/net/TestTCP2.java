package Java.lebin.Training.communication.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 此类用于演示基于TCP的网络通信
 * @author liyuting
 * 
 * 场景2：客户端向服务端发送一句话：hello，服务端接受并打印,然后回应一句话给客户端，客户端接受并打印
 *
 */
public class TestTCP2 {
	//演示服务端
	@Test
	public void testServer() throws IOException {
		
		//1.创建服务端套接字对象,同时指定端口号
		ServerSocket ss = new ServerSocket(8888);
		
		
		//2.接受客户端的连接请求
		Socket socket = ss.accept();
		
		
		//3.------------------读写数据------------------
		
		//读取网络中传来的数据
		//①获取读取数据的流对象
		InputStream inputStream = socket.getInputStream();
		
		//②通过流对象读取数据
		byte[] b = new byte[1024];
		int len;
		while((len=inputStream.read(b))!=-1){
			System.out.print(new String(b,0,len));
		}
		
		
		//向客户端写入数据
		//①获取写入数据的流对象
		OutputStream outputStream = socket.getOutputStream();
		
		//②通过流对象写入数据
		outputStream.write("Hi,I am Server!".getBytes());
		
		
		
		//③设置写入结束的标记
		socket.shutdownOutput();
		
		
		//4.关闭资源（连接资源和套接字资源）
		outputStream.close();
		
		inputStream.close();
		socket.close();
		
		ss.close();

	}
	
	//演示客户端
	@Test
	public void testClient() throws Exception{
		
		//1.创建客户端套接字对象，同时指定服务端的ip和端口号，发送连接请求
		
		Socket socket = new Socket(InetAddress.getLocalHost(),8888);
		
		
		//2.-----------------读写数据------------------
		
		//向服务端发送数据
		
		//①获取写入数据的流对象
		OutputStream outputStream = socket.getOutputStream();
		
		//②通过outputStream写入数据
		outputStream.write("hello,I am Client!".getBytes());
		
		
		//③设置写入结束的标记（代表写入完毕）
		socket.shutdownOutput();
		
		//读取网络中发来的数据
		
		//①获取读取数据的流对象
		InputStream inputStream = socket.getInputStream();
		//②循环读取
		byte[] b = new byte[1024];
		int len;
		while((len=inputStream.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		
		
		//3.关闭资源（流和套接字）
		
		inputStream.close();
		outputStream.close();
		socket.close();
		
		
	}
	

}
