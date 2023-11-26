package Java.lebin.Training.FileSys.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 此类用于演示BufferedWriter的特点和使用
 * @author liulebin
 * 注意：多了newLine方法
 *
 */
public class TestBufferedWriterFileWriter {

	
	public static void main(String[] args) {
		BufferedWriter writer=null;
		try {
			//1.创建BufferedWriter对象
			 writer = new BufferedWriter(new FileWriter("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/datas.txt"));
			
			
			//2.写入
			
			writer.write("xiaohua");
			//windows 系统是\r\n, linux 是\n
			writer.write("\r\n");
			writer.newLine();//插入和平台相关的换行符
			writer.write("world");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(writer!=null)
					writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
