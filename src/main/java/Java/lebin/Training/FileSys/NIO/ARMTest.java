package Java.lebin.Training.FileSys.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

//自动资源管理的实现
public class ARMTest {

	// jdk 7的新增特性
	@Test
	public void test2() {
		try (
				// 声明在try()中的资源在执行最后，会自动执行关闭
				// 要求：
				// 1.可以在一条 try 语句中管理多个资源，每个资源以“;” 隔开即可。
				// 2.需要关闭的资源，必须实现了 AutoCloseable 接口或其子接口 Closeable

				FileInputStream fis = new FileInputStream("hello.txt");
				FileOutputStream fos = new FileOutputStream("hello1.txt");
				ByteChannel channel = Files.newByteChannel(Paths.get("hello.txt"), StandardOpenOption.READ)) {
			// 可能包含异常的代码
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 一定会被执行的代码
		}
	}

	@Test
	public void test1() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt");

			int data = fis.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {

				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
