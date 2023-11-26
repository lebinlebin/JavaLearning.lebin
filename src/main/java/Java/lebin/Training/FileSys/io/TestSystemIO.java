package Java.lebin.Training.FileSys.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * 
 * @author liulebin
 *
 * 此类用于演示标准输入输出流
 * 
 * System.in    标准输入流		InputStream		默认设备：键盘
 * System.out	标准输出流		PrintStream		默认设备:显示器		黑色
 * System.err	标准错误流		PrintStream		默认设备:显示器		红色
 * 
 * 
 * 可以重定向标准输入输出流的默认设备
 * 
 * System.setIn(InputStream);
 * 
 * System.setOut(PrintStream);
 * 
 * System.setErr(PrintStream);
 * 
 * 
 */

public class TestSystemIO {
	//测试标准输入流
	@Test
	public void test1() throws IOException {
		
		InputStream is = System.in;
		
		int read = is.read();
		System.out.println((char)read);
		
	}
	//测试标准输出流
	@Test
	public void test2() throws FileNotFoundException {
		
		System.setOut(new PrintStream("src\\print.txt"));
		
		System.out.println("hello");
//		//步骤1：创建流对象
//		PrintStream ps = System.out;
//		
//		//步骤2：打印
//		
//		ps.println();
		
		
		
	}

}
