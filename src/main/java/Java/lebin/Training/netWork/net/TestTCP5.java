package Java.lebin.Training.netWork.net;

import Java.lebin.Training.netWork.utils.StreamUtils;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 此类用于演示基于TCP协议的网络通信
 * @author liulebin
 * 
 * 场景4：客户端向服务端发送一张图片，服务端接受保存到本地，然后向客户端回应：照片不错呦！
 *
 */
public class TestTCP5 {

	//服务端
	/*
	 * 
	 * 1.读取网络中的图片（读）
	 * 2.将读取到的图片写入到本地（写）
	 * 3.向客户端发送数据（写）
	 * 
	 * 
	 * 
	 */
	@Test
	public void testServer() throws IOException {
		
		//1.创建服务端套接字对象
		
		ServerSocket  ss = new ServerSocket(9999);
		
		//2.接受连接请求
		Socket socket = ss.accept();
		
		//3.----------------------读写-----------------------
		
		//3-1.读取网络中的图片（读） &将读取到的图片写入到本地（写）
		
		InputStream inputStream = socket.getInputStream();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\beauty.jpg"));
		
		bos.write(StreamUtils.streamToByteArray(inputStream));
		
		
		
		
		//3-2 向客户端发送数据（写）
		
		//①创建写入的流对象
		PrintStream printer= new PrintStream(socket.getOutputStream());
		
		//②写入
		printer.println("照片不错呦，再来一张~");
		
		
		//4.关闭
		
		printer.close();
		
		bos.close();
		inputStream.close();
		socket.close();
		ss.close();
	}
	
	//客户端
	/*
	 * 
	 * 1.从本地读取图片(读)
	 * 2.向服务端发送图片（写
	 * 3.接受服务端发来的文本数据（读）
	 * 
	 * 
	 * 
	 */
	@Test
	public void testClient() throws IOException {
		//1.创建客户端套接字对象
		Socket socket =new Socket(InetAddress.getLocalHost(),9999);
		
		
		//2.读写数据
		
		//2-1 .将本地图片读取，然后再写入到网络中（复制图片）
		//①获取流对象
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\beauty\\rb.jpg"));
		OutputStream bos = socket.getOutputStream();
		
		//②边读边写
		byte[] b=new byte[1024];
		int len;
		while((len=bis.read(b))!=-1){
			bos.write(b, 0, len);
		}
			
		socket.shutdownOutput();
		
		//2-2.读取服务端发来的文本
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		System.out.println(reader.readLine());
		
		
		//3.关闭
		
		reader.close();
		bos.close();
		bis.close();
		socket.close();
		
		
		
		
		
	}
}
