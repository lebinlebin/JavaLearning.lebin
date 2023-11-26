package Java.lebin.Training.FileSys.NIO.java2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

//演示阻塞式的NIO操作1:客户端给服务器端发送一个图片
public class BlockingNIOTest {

	@Test
	public void client() throws Exception{//客户端
		
		//SocketChannel是双向通道
		SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9090));
		
		//创建FileChannel
		FileChannel fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		
		//数据的读取和写出的过程
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(fileChannel.read(buffer) != -1){
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
		}
		
		//关闭资源
		fileChannel.close();
		socketChannel.close();
		
	}
	
	@Test
	public void server() throws IOException{//服务器端
		
		//创建ServerSocketChannel
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		//绑定端口号
		ssChannel.bind(new InetSocketAddress(9090));
		//接口发送来的Channel：双向通道
		SocketChannel sChannel = ssChannel.accept();
		
		//创建FileChannel
		FileChannel fileChannel = FileChannel.open(Paths.get("6.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		//数据的读取和写出的过程
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(sChannel.read(buffer) != -1){
			buffer.flip();
			fileChannel.write(buffer);
			buffer.clear();
		}
		
		//关闭资源
		fileChannel.close();
		sChannel.close();
		ssChannel.close();
		
	}
	
}
