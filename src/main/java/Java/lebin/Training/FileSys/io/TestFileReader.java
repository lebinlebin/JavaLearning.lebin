package Java.lebin.Training.FileSys.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 此类用于演示FileReader类的特点和使用
 * @author liulebin
 *
 */
public class TestFileReader {
	
	public static void main(String[] args) throws IOException {
		//1.创建FileReader对象
		FileReader reader = new FileReader("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/stars.txt");
		
		
		//2.调用读取方法
		/*
		 * 方式1：int read() 读取单个字符,然后当前读取到的字符，如果读到文件末尾，返回-1
		 */
		
//		int data = reader.read();
//		/*默认输出ascii码*/
//		System.out.println(data);
//		/*转化为char类型*/
//		System.out.println((char)data);

//		int data;
//		while((data=reader.read())!=-1){
//			System.out.print((char)data);
//		}
		
		
		
		/*
		 * 方式2：int read(char[]) 批量读取多个字符到char[],返回读取到的实际的字符个数，如果读到文件末尾，返回-1
		 */
		
		char[] chs = new char[10];
		
//		int len = reader.read(chs);
//
//		System.out.println("读取到字符个数:"+len);
//		System.out.println("读取到文件内容:"+new String(chs));
		
//		int data;
//		while((data=reader.read(chs))!=-1){
//			System.out.print(new String(chs,0,data));
//		}
		
		
		/*
		 * 
		 * 方式3：int read(char[],off,len)批量读取多个字符到char[]的指定部分，返回读取到的实际字符个数，如果读到文件末尾，返回-1
		 */
		
		
		int len = reader.read(chs, 2, 5);

		System.out.println(len);
		System.out.println(new String(chs));
		
		
		
		//3.关闭流资源
		reader.close();
	}

}
