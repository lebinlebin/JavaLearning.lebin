package Java.lebin.Training.FileSys.NIO.java1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/*
 * 一、java.nio.channels.Channel接口：表示表示 IO 源与目标节点打开的连接。
 * Channel 只能与 Buffer 进行交互，才能实现数据的传输。
 * 
 * 二、主要实现类：
 * 	java.nio.channels.Channel:
 * 			|----FileChannel:适用于本地数据传输
 * 		
 * 			|----SocketChannel：适用于TCP中的网络传输的客户端
 * 			|----ServerSocketChannel：适用于TCP中的网络传输的服务器端
 * 			|----DatagramChannel：适用于UDP中的网络传输
 * 
 * 			|----Pipe.SinkChannel:
 * 			|----Pipe.SourceChannel:
 * 
 * 三、实例化Channel:
 *  方式一： 调用getChannel()
 *  	FileInputStream--->FileChannel
 *  	FileOutpuStream--->FileChannel
 *  	RandomAccessFile--->FileChannel
 *  	-------------
 *  	Socket--->SocketChannel
 *  	ServerSocket--->ServerSocketChannel
 *  	DatagramSocket--->DatagramChannel
 * 
 *  方式二： jdk7.0以上才可以使用
 *       调用XxxChannel的静态方法：open()，得到XxxChannel实例。
 *  
 *  方式三：jdk7.0以上才可以使用
 *  	 Files.newByteBuffer(),返回一个字节通道
 *  
 * 四、Channel特点：既可以是单向的，也可以是双向的。
 * 
 */
public class ChannelTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test4() throws IOException{
		RandomAccessFile raf1 = new RandomAccessFile("EclipseKeys.java", "rw");
		RandomAccessFile raf2 = new RandomAccessFile("EclipseKeys1.java", "rw");
		
		FileChannel inChannel = raf1.getChannel();
		FileChannel outChannel = raf2.getChannel();
		
		ByteBuffer buf1 = ByteBuffer.allocate(1024);
		ByteBuffer buf2 = ByteBuffer.allocate(2048);
		//分散读入
		inChannel.read(new ByteBuffer[]{buf1,buf2});
		
		buf1.flip();
		buf2.flip();
		
		System.out.println(new String(buf1.array(),0,buf1.limit()));
		System.out.println("**********************");
		System.out.println(new String(buf2.array(),0,buf2.limit()));
		
		
		//聚集写出
		outChannel.write(new ByteBuffer[]{buf1,buf2});
		
		
		outChannel.close();
		inChannel.close();
	}
	
	@Test
	public void test3() throws IOException{
		FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("5.jpg"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		//transferTo / transferFrom:将数据从指定的通道传输到另外的支出输出的通道中
//		inChannel.transferTo(0, inChannel.size(), outChannel);
		
		outChannel.transferFrom(inChannel, 0, inChannel.size());
		
		inChannel.close();
		outChannel.close();
		
	}
	
	

	//使用FileChannel + MappedByteBuffer（直接缓冲区）-->物理内存映射文件
	@Test
	public void test2() throws Exception {
		
		long start = System.currentTimeMillis();
		
		
		//1.创建Channel
//		FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
//		FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Desktop\\1.mkv"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Desktop\\3.mkv"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		//2.创建得到直接缓冲区
		MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		//3.数据的读写
		byte[] dst = new byte[inMappedBuffer.limit()];
		inMappedBuffer.get(dst);//将数据写入到dst中
		outMappedBuffer.put(dst);//从dst中将数据取出
		
		//4.关闭资源
		inChannel.close();
		outChannel.close();
		
		
		long end = System.currentTimeMillis();
		System.out.println("直接缓冲区：" + (end - start));//1573-1575
		
	}

	// 实现文件的复制:FileChannel + ByteBuffer(使用非直接缓冲区)
	@SuppressWarnings("resource")
	@Test
	public void test1() throws Exception {
		
		long start = System.currentTimeMillis();
		
		// 1.提供相应的输入输出流
//		FileInputStream fis = new FileInputStream("1.jpg");
//		FileOutputStream fos = new FileOutputStream("2.jpg");
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\1.mkv");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\2.mkv");
		// 2.创建得到相应的Channel
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();

		// 3.提供缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (inChannel.read(buffer) != -1) {
			buffer.flip();// 切换为读取数据的模式
			outChannel.write(buffer);
			buffer.clear();// 清空
		}

		// 4.关闭资源
		fis.close();
		fos.close();
		inChannel.close();
		outChannel.close();

		long end = System.currentTimeMillis();
		System.out.println("非直接缓冲区：" + (end - start));//8902-9092
	}
}
