package Java.lebin.Training.netWork.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 此类用于演示基于TCP的网络通信
 * @author liyuting
 * 
 * 场景3：客户端向服务端发送一句话：hello，服务端接受并打印,然后回应一句话给客户端，客户端接受并打印
 * 
 * 
 * 进阶：使用包装流对节点流进行一层包装
 * 细节注意：
 * 
 * 	因为网络中不像文件一样，到了末尾有个标记，值为-1
 *  
 *  网络中写入结束，必须自己指定一个标记
 *  
 *  方式一：单纯使用字节流，写入结束之后，添加socket.shutdownOutput();
 *  
 *  方式二：如果读写的是纯文本，则可以使用缓冲流或打印流进行包装
 *  
 *  	1、缓冲流
 *  	writer.write();
 *  	writer.newLine();
 *  	writer.flush();
 *  
 *  	2、打印流
 *  	printer.println();
 *  
 *  	
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class TestTCP3 {
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		//②读取数据
		
		String line = reader.readLine();
		System.out.println(line);
		
		//向客户端写入数据
		//②获取写入数据的流对象
		OutputStream outputStream = socket.getOutputStream();//SocketOutputStream的流对象
		
		//方式一：使用打印流
		PrintStream writer = new PrintStream(outputStream);
		
		writer.println("Hello,我是服务端！");
		
		//方式二：使用缓冲流
		
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//		
//		writer.write("Hello,我是服务端！");
//		writer.newLine();
//		writer.flush();
		
		
//		//③设置写入结束的标记
//		socket.shutdownOutput();
		
		
		
		//4.关闭资源（连接资源和套接字资源）
		
		writer.close();//SocketOutputStream.close();//h+关闭
		reader.close();
		
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
		
		
		//方式一：使用打印流
		PrintStream writer = new PrintStream(outputStream);
		
		writer.println("Hello,我是客户端！");
		
		//方式二：使用缓冲流
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//		//②写入数据
//		writer.write("Hello,我是客户端！");
//		writer.newLine();
//		writer.flush();
		
//		//③设置写入结束的标记
//		socket.shutdownOutput();
		
		//读取网络中发来的数据
		
		//①获取读取数据的流对象
		InputStream inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		//②循环读取
		System.out.println(reader.readLine());
		
		
		//3.关闭资源（流和套接字）
		
		reader.close();
		writer.close();
		socket.close();
		
		
	}
	

}
