package Java.lebin.Training.FileSys.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 此类用于演示FileInputStream的使用
 * @author liulebin
 *
 */
public class TestFileInputStream {

	
	public static void main(String[] args) throws IOException {
		
		//1.创建FileInputStream对象，指向一个具体的文件
		/*
		 * 注意:fis的指针指向了文件的首端
		 */
		FileInputStream fis = new FileInputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/new2.txt");
		
		
		//2.调用读取方法
		//方法1：int read()
		/*
		 * 读取单个字节，每次调用将后移一位，返回读取到的字节，如果读到文件末尾，返回-1
		 * 类似于迭代器
		 *
		 */
//		int data = fis.read();
//		System.out.println((char)data);
//		int data1 = fis.read();
//		System.out.println((char)data1);
//		int data2 = fis.read();
//		System.out.println((char)data2);
//		int data3 = fis.read();
//		System.out.println((char)data3);
//		int data4 = fis.read();
//		System.out.println((char)data4);
//
//		int data5 = fis.read();
//		System.out.println(data5);

//		int data_;
//		while((data_=fis.read())!=-1){
//			System.out.println("---------------------------");
//			System.out.print((char)data_);
//
//		}




		//方法2：int read（byte[]）  【推荐使用】
		/*
		* 批量读取
		 * 功能：批量读取多个字节到字节数组中，返回读取到的字节个数，如果读到文件末尾，返回-1
		 * 
		 */
		
		byte[] buf = new byte[5];
		int len;
		while((len=fis.read(buf))!=-1){
			//将byte数组转化为string 字符串
			/**
			 * 这个输出有问题，为什么末尾会重复两个字母
			 * helloworld!!!
			 * helloworkow
			 */
//			System.out.print(new String(buf));
			//利用String的构造器
			//一次输出指定长度的字符
			System.out.print(new String(buf,0,len));
		}
		
		
		//方法3：int read(byte[],off,len)
		/**
		 * 功能：批量读取多个字节到字节数组的指定部分，返回读取到的字节个数，如果读到文件末尾，返回-1
		 */
//		byte[] b = new byte[5];
//		int len = fis.read(b, 1, 5);
//
//		System.out.println("读到的实际个数："+len);
//		System.out.println("读到的实际内容："+new String(b));
		
		
		
		//3.关闭流资源
		fis.close();
	}
}
