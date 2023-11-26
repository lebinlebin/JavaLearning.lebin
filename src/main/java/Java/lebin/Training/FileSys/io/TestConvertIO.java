package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * 此类用于演示转换流的特点和使用
 * @author liulebin
 * 
 * 功能：将字节流转换成字符流
 * 分类：
 * 	InputStreamReader
 * 	OutputStreamWriter
 * 好处：
 * 		如果读写的数据是纯字符，采用字符流读写更高效而且更方便！
 *
 */

public class TestConvertIO {
	//测试InputStreamReader  :将InputStream——>Reader
	@Test
	public void test1() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"gbk"));
		System.out.println("请输入：");
		String line =reader.readLine();
		System.out.println(line);
		
		

	}
	
	
	//测试OutputStreamWriter:将OutputStream——>Writer
	
	@Test
	public void test2() throws IOException {
		
		BufferedWriter writer = 
				new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("src\\convert.txt")));
		
		
		writer.write("张三丰");
		
		writer.close();
		
		

	}
}
