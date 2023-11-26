package Java.lebin.Training.FileSys.NIO.java2;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class CharsetTest {
	
	@Test
	public void test2() throws Exception{
		//1.实例化Charset
		Charset charset = Charset.forName("GBK");
		
		//2.得到编码器、解码器
		CharsetEncoder encoder = charset.newEncoder();//得到编码器
		CharsetDecoder decoder = charset.newDecoder();//得到解码器
		
		//编码
		CharBuffer charBuffer = CharBuffer.allocate(1024);
		charBuffer.put("尚硅谷大数据");
		charBuffer.flip();
		ByteBuffer byteBuffer = encoder.encode(charBuffer);//字符-->字节
		
		for(int i = 0;i < byteBuffer.limit();i++){
			System.out.println(byteBuffer.get());
		}
		
		//解码
		byteBuffer.flip();
		CharBuffer charBuffer2 = decoder.decode(byteBuffer);
		System.out.println(charBuffer2.toString());
		
		System.out.println("*********");
		Charset charset2 = Charset.forName("UTF-8");
		byteBuffer.flip();
		CharBuffer charBuffer3 = charset2.decode(byteBuffer);
		System.out.println(charBuffer3.toString());
		
		
	}
	
	@Test
	public void test1(){
		//获取Charset中保存的编码集
		Map<String,Charset> charsets = Charset.availableCharsets();
		
		Set<Entry<String,Charset>> entrySet = charsets.entrySet();
		for(Entry<String,Charset> e : entrySet){
			System.out.println(e.getKey() + "--->" + e.getValue());
		}
		
	}
}
