package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//1、（字符流+缓冲流）读取一个文本文件，每行都追加一个“好”，在文件结尾再追加“完毕”。
public class TestHomework1 {
	
	
	public static void main(String[] args) throws IOException {
		
		//1.创建流对象
		BufferedReader reader = new BufferedReader(new FileReader("src\\测试题20.txt"));

		//2.读取
		StringBuilder builder= new StringBuilder();
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line+"好\r\n");
			
		}
		builder.append("完毕");
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("src\\测试题20.txt"));
		
		writer.write(builder.toString());
		
		//3.关闭
		writer.close();
		reader.close();
		
		
	}

}
