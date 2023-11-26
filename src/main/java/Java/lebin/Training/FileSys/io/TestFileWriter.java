package Java.lebin.Training.FileSys.io;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 此类用于演示FileWriter的特点和使用
 */
public class TestFileWriter {

	public static void main(String[] args) throws IOException {

		//1.创建FileWriter对象
		FileWriter writer = new FileWriter("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/names.txt",true);//覆盖

		//2.写入
		writer.write("zhong");
		writer.write("张三丰".toCharArray());
		writer.write("鸠摩智".toCharArray(), 2, 1);

		writer.write("古力娜扎");
		writer.write("古力娜扎", 3, 1);

		//3.关闭
		writer.flush();//刷新，将内容写入到文件中
		writer.close();//①先刷新  ②关闭资源
	}

}
