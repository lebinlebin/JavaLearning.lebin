package Java.lebin.Training.FileSys.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 此类用于演示FileOutputStream的特点和使用
 * @author liulebin
 *
 */
public class TestFileOutputStream {
	
	
	public static void main(String[] args) throws IOException {
		
		//1.创建FileOutputStream对象
		FileOutputStream fos = new FileOutputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/test.txt");
		
		//2.调用写入方法
		
		//写入单个字节
		fos.write('h');

		//批量写入整个字节数组
		byte[] b ="john".getBytes();
		fos.write(b);
		//批量写入字节数组的指定部分
		fos.write("habco".getBytes(), 1, 3);
		fos.write("\r\n".getBytes());
		fos.write("habco".getBytes(), 1, 3);
		

//		//3.关闭流资源
		fos.close();
	}
	
	

}
