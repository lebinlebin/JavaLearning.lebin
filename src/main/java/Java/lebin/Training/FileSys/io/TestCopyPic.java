package Java.lebin.Training.FileSys.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 此类用于演示图片的复制
 * @author liulebin
 * 
 * 将 E:\beauty\cang.jpg复制到src\beauty.jpg下面
 * 
 * 1.从E:\beauty\cang.jpg 读取到程序   FileInputStream
 * 2.从程序写入到src\beauty.jpg      FileOutputStream
 */
public class TestCopyPic {

	
	public static void main(String[] args){
		
		//1.创建流对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/beauty.jpg");
			
			fos = new FileOutputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/beautycopyed.jpg");
			
			//2.读写
			
			byte[] buf = new byte[1024];
			int len;
			while((len=fis.read(buf))!=-1){
				fos.write(buf,0,len);
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		finally{
		
			//3.关闭流资源
			try {
				if(fos!=null)
					fos.close();
				if(fis!=null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
	}
}
