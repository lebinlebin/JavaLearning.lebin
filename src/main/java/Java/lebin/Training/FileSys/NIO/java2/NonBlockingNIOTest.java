package Java.lebin.Training.FileSys.NIO.java2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

//以TCP方式传输，使用NIO实现非阻塞式的网络通信
/*
 * Selector:选择器
 * 是 SelectableChannel 对象的多路复用器，
 * Selector 可以同时监控多个 SelectableChannel 的 IO 状况。
 * 
 * 	SelectableChannel
 * 		|-----SocketChannel  ---TCP的客户端
 * 		|-----ServerSocketChannel ---TCP的服务器端
 * 		|-----DatagramChannel   ---UDP
 * 
 */
public class NonBlockingNIOTest {

	@Test
	public void client() throws Exception {
		SocketChannel socketChannel = SocketChannel
				.open(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8989));

		// 切换为非阻塞式
		socketChannel.configureBlocking(false);
		
		//通过控制台输入的方式，向服务器端发送数据
		Scanner scanner = new Scanner(System.in);
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(scanner.hasNext()){
			String words = scanner.nextLine();
			buffer.put((new Date() + "\n" + words).getBytes());
			buffer.flip();
			socketChannel.write(buffer);
			buffer.clear();
		}
		
		
		// 关闭资源
		socketChannel.close();
		scanner.close();

	}

	@Test
	public void server() throws IOException {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		SocketChannel sChannel = null;
		//设置为非阻塞式
		ssChannel.configureBlocking(false);
		//创建Selector
		Selector selector = Selector.open();
		//注册
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		//设置端口号
		ssChannel.bind(new InetSocketAddress(8989));
		while(selector.select() > 0){
			
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			
			while(iterator.hasNext()){
				SelectionKey selectionKey = iterator.next();
				
				if(selectionKey.isAcceptable()){//当前客户端的Channel已经就绪
					sChannel = ssChannel.accept();
					
					sChannel.configureBlocking(false);
					
					sChannel.register(selector, SelectionKey.OP_READ);
					
					
				}else if(selectionKey.isReadable()){//当前客户端的Channel可读
					
					sChannel = (SocketChannel) selectionKey.channel();
					
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					while(sChannel.read(buffer) > 0){
						buffer.flip();
						System.out.println(new String(buffer.array(),0,buffer.limit()));
						buffer.clear();
					}
					
					
				}
				
				iterator.remove();
			}
			
			
		}
		
		//关闭资源
		ssChannel.close();
		sChannel.close();
	}
}
