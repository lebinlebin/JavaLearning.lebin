package Java.lebin.Training.FileSys.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * 此类用于演示Properties类的特点和使用
 * @author liyuting
 *
 */
public class TestProperites {
	//测试读取配置文件
	@Test
	public void test1() throws FileNotFoundException, IOException {
		
		//1.创建Properties对象
		Properties pro = new Properties();
		
		//2.读取db.properites（文件——>内存）
		pro.load(new FileInputStream("src\\db.properties"));
		
		//3.遍历Properties集合
		//操作1：将所有的键值对打印到指定控制台
//		pro.list(System.out);
		//操作2：根据键获取值
		String name = pro.getProperty("name");
		String pwd = pro.getProperty("password");
		System.out.println(name+"\t"+pwd);
		

	}
	
	//测试写入配置文件
	@Test
	public void test2() throws FileNotFoundException, IOException {
		//1.创建Properties对象
		Properties pro = new Properties();
		
		//2.为Properties保存键值对信息(内存)
		pro.setProperty("ip", "192.168.10.165");
		pro.setProperty("port", "8888");
		
		//3.将pro中的键值对存储在配置文件（内存——》文件）
		pro.store(new FileOutputStream("src\\host.properties"), null);
		
		
		
		
		
		

	}

}
