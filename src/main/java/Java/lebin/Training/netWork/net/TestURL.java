package Java.lebin.Training.netWork.net;

import Java.lebin.Training.netWork.utils.StreamUtils;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 此类用于演示基于URL的网络通信
 * @author liyuting
 * 
 * 
 *
 */
public class TestURL {
	//测试URL的特点和使用
	@Test
	public void test1() throws MalformedURLException {

		//1.创建URL对象
		URL url = new URL("http://192.168.26.60:8080/cang.jpg?name=john");
		
		//2.调用方法，获取url的各部分
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		
		
		
		
	}
	
	//测试基于URL的网络通信——下载url指定的资源
	@Test
	public void test2() throws IOException {
		
		//1.创建url对象
		URL url = new URL("http://192.168.26.60:8080/cang.jpg");
		
		//2.打开连接
		URLConnection connection = url.openConnection();
		
		//3.读数据（下载）
		
		InputStream inputStream = connection.getInputStream();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\cang.jpg"));
		//边读边写
		bos.write(StreamUtils.streamToByteArray(inputStream));
		
		
		//4.关闭
		bos.close();
		inputStream.close();
		
		
		

	}
	

}
