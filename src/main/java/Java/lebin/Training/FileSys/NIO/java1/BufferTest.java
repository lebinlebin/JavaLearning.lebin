package Java.lebin.Training.FileSys.NIO.java1;

import java.nio.ByteBuffer;

import org.junit.Test;

/*
 * 一、NIO中数据传输的两个要素：Buffer:缓冲区  ； Channel:通道
 *	Buffer:负责数据的存储（读写）
 *  Channel:代表了数据源与IO节点（文件、网络Socket)之间的连接。负责传输Buffer
 *  
 * 二、java.nio.Buffer：缓冲区
 * 		|----ByteBuffer
 * 		|----CharBuffer
 * 	
 * 		|----ShortBuffer
 * 		|----IntBuffer
 * 		|----LongBuffer
 * 		|----FloatBuffer
 * 		|----DoubleBuffer
 *   说明：XxxBuffer底层使用Xxx类型的数组存储的。
 * 三、如何实例化XxxBuffer.使用allocate(int capacity).
 * 		类似ArrayList list = new ArrayList(int capacity)
 * 
 * 四、XxxBuffer中常用的属性：
 *   capacity:容量，决定了底层数组的长度。也可以理解为决定了存储数据量的最大值。
 *   limit:限制，默认时与capacity相同。但是读数据模式，表示我们最大可以读取数据的量。
 *   position:位置，指明当前操作的数据的下一个位置。
 *   mark:标记，
 *   
 *   关系式：mark <= position <= limit <= capacity
 *   
 *  五、字节缓冲区（ByteBuffer):分为直接缓冲区(通过allocateDirect() / FileChannel 的 map() )
 *  						    和
 *  						    非直接缓冲区(通过allocate())
 */
public class BufferTest {
	
	
	
	@Test
	public void test3(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put("abcde".getBytes());
		buffer.flip();
		//array():将底层的数组返回
		byte[] array = buffer.array();
		System.out.println(new String(array,0,buffer.limit()));
		//isDirect():判断当前的ByteBuffer是否是直接缓冲区
		System.out.println(buffer.isDirect());//false
		
	}
	
	@Test
	public void test2(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put("abcde".getBytes());
		buffer.flip();
		byte[] buf = new byte[5];
		buffer.get(buf, 0, 2);
		
		System.out.println(buffer.position());
		//mark():给mark赋值为position.
		buffer.mark();
		System.out.println(buffer.position());
		
		buffer.get(buf, 2, 2);
		System.out.println(buffer.position());
		
		//reset():将position重置为最近的一次mark.(前提：reset()之前，必须调用过mark()).
		//mark()与reset()通常搭配使用。
		buffer.reset();
		System.out.println(buffer.position());
		
		if(buffer.hasRemaining()){
			System.out.println(buffer.remaining() );
		}
		
		while(buffer.hasRemaining()){
			System.out.println((char)buffer.get()+ "----");
		}
		
	}
	@Test
	public void test1(){
		ByteBuffer buffer = ByteBuffer.allocate(10);//底层创建了长度为10的byte[]
		System.out.println("**********allocate(10)*************");
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
//		System.out.println(buffer.mark());
		
		System.out.println("**********put()*************");
		String str = "hello";
		buffer.put(str.getBytes());//每put()一次，position就+1.
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		
		System.out.println("**********flip()*************");
		//修改limit为position。重置position
		buffer.flip();//将buffer从存入数据的模式改为取出数据的模式.
		
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		
		System.out.println("**********get()*************");
//		System.out.println((char)buffer.get());//每get()一次，positon+1
//		System.out.println((char)buffer.get());
		//方式二：
		byte[] dst = new byte[2];
		buffer.get(dst);
		System.out.println(new String(dst));
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		
		System.out.println("**********rewind()*************");
		buffer.rewind();//重置position
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		
		System.out.println("**********clear()*************");
		buffer.get();
		buffer.get();//此时position = 2,limit = 5,capacity = 10;
		buffer.clear();//清空。重置postion = 0;limit = capacity.
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		//clear()并没有清空数据。
		System.out.println((char)buffer.get());
		
		
	}
}
