package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 此类用于演示使用缓冲流实现文本文件的复制
 * @author liulebin
 *
 */
public class TestCopyByBufferReaderFileReaderWriter {
	
	public static void main(String[] args) throws IOException {
		
		//1.创建流对象
		BufferedReader reader = new BufferedReader(new FileReader("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/toBecopy.txt"));
		BufferedWriter writer = new BufferedWriter(new  FileWriter("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/copy.txt"));
		
		
		//2.读写
		
		String line;
		while((line=reader.readLine())!=null){
			writer.write(line);
			writer.newLine();
		}
		//3.关闭
		writer.close();
		reader.close();
	}

}
