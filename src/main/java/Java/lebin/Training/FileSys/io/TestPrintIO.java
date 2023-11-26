package Java.lebin.Training.FileSys.io;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 此类用于演示打印流的特点和使用
 * @author liulebin
 * 分类：
 * 	PrintStream和PrintWriter
 * 
 * 特点：
 * 	①只有输出没有输入
 * 	②打印流提供了一系列重载好的print、println或printf方法，可以实现对任意类型数据 的输出
 *  ③打印流除了调用构造器时会有FileNotFoundException,其他调用write或print都不会抛出异常
 *  ④打印流通过配置一个参数可以实现自动刷新
 *  	但要求：PrintWriter必须调用了println、printf或format中的一个
 *  		  PrintStream必须调用了println或write方法+\n
 *  
 *  ⑤打印流可以在构造器中设置字符集
 *  
 * 
 * 
 * 	
 * 
 *
 */
public class TestPrintIO {

	public static void main(String[] args) throws IOException {
		
		String name = "李雷";
		int age =10;
		double score = 98.5999;
		char sex = '男';
		//格式化打印
//		System.out.printf("姓名：%s,年龄:%d,成绩:%.1f，性别:%c", name,age,score,sex);
		
		
//		PrintWriter ps = new PrintWriter(new FileWriter("src\\a.txt"),true);
		PrintWriter ps = new PrintWriter("src\\a.txt","utf-8");
		
		ps.println("今天天气真好");
		
		ps.close();
	}
}
