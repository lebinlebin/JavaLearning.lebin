package Java.lebin.Training.FileSys.File;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * 此类用于演示File类的特点和使用
 * @author liulebin
 *
 */
public class TestFile {
	//1.创建File对象，指向一个具体的文件或目录
	File file = new File("E:\\demo");
	//方法系列一：
	/*
	 * 案例：判断目录是否存在，如果存在删除，否则创建
	 * 
	 * exists:判断文件或目录是否存在
	 * mkdir：创建一层目录
	 * mkdirs:创建多层目录
	 * delete：删除文件或空目录
	 */
	@Test
	public void test1() {
		
		//1.创建File对象，指向一个具体的文件或目录
		File file = new File("E:\\demo");
		
		//2.调用方法
		if(file.exists()){
			file.delete();
		}else{
			file.mkdirs();
		}
		
		

	}
	
	//测试方法系列二：
	/*
	 * 案例：判断E:\\demo\\news.txt
	 * 文件是否存在，如果存在则删除，否则创建
	 * 
	 * new File(File parent,String child)
	 * new File(String parent,String child)
	 * 
	 * createNewFile:创建文件
	 */
	@Test
	public void test2() throws IOException {
		File sub = new File("E:\\demo","news.txt");
		
		if(sub.exists()){
			sub.delete();
		}else{
			sub.createNewFile();
		}
		

	}
	
	//测试方法系列三：
	/*
	 * 判断某File对象是否是文件还是目录还是隐藏或文件大小
	 * 
	 * isFile
	 * isDirectory
	 * isHidden
	 * length (只针对于文件有效)
	 */
	@Test
	public void test3() {
		File sub = new File("E:\\demo","news.txt");
		System.out.println("是否是文件？ "+sub.isFile());
		System.out.println("是否是目录? "+sub.isDirectory());
		System.out.println("是否隐藏? "+sub.isHidden());
		System.out.println("文件大小："+sub.length());

	}
	//测试方法系列四：
	
	@Test
	public void test4() {
		File sub = new File("E:\\demo","news.txt");
		System.out.println("文件名："+sub.getName());
		System.out.println("文件路径："+sub.getAbsolutePath());
		System.out.println("父目录："+sub.getParent());

	}

	//测试方法系列四：
	/*
	 *
	 * 案例：列出指定目录下所有的子级
	 * 方法：
	 * list:列出当前目录下的子级(一层)，返回类型String[]
	 * listFiles:列出当前目录下的子级（一层）,返回类型File[]
	 *
	 */

	@Test
	public void test5() {

		File file = new File("E:\\0308");
		//调用list
//		String[] list = file.list();
//		for (String string : list) {
//			System.out.println(string);
//		}

		//调用listFiles
		print(file);
	}
	/**
	 * 递归：
	 * 1、定义在方法内
	 * 2、方法自己调用自己
	 * 3、必须有一个出口条件
	 *
	 *
	 */

	public void print(File file){
		File[] listFiles = file.listFiles();

		for (File subFile : listFiles) {
			System.out.println(subFile.getName());
			if(!(subFile.isFile())){//如果是目录
				print(subFile);
			}

		}

	}

}
