package Java.lebin.Training.FileSys.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 此类用于演示BufferedInputStream和BufferedOutputStream的特点和使用
 * 读取图片和输出图片
 * @author liulebin
 *BufferedOutputStream追加形式
 * 必须和节点流配合使用
 */
public class TestBufferedInputOutputStream {
	
	public static void main(String[] args) throws IOException {
		
		//1.创建流对象
		BufferedInputStream bis =
				new BufferedInputStream(new FileInputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/beauty.jpg"));
		BufferedOutputStream bos =
				new BufferedOutputStream(new FileOutputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/copy.jpg"));
		
		
		//2.读写
		
		int len;
		byte[] b=new byte[1024];
		while((len=bis.read(b))!=-1){
			bos.write(b, 0, len);
		}
		
		//3.关闭
		bos.close();
		bis.close();
		
		
		
	}

}
