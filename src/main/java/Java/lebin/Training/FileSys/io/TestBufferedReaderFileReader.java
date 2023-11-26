package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 此类用于演示BufferedREader的特点和使用
 * @author liulebin
 *
 * 注意：多了readLine方法，功能：读取一行文本，如果到文件末尾返回null
 * 必须和节点流FileReader结合使用
 */
public class TestBufferedReaderFileReader {

	public static void main(String[] args)  {
		//1.创建流对象
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/students.txt"));
			//2.读取
			
			String line;
			while((line= reader.readLine())!=null){
			
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally{
		try {
			//3.关闭
			if(reader!=null)
				reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}
	
	
}
