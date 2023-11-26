package Java.lebin.Training.FileSys.NIO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Iterator;

import org.junit.Test;

/*
 * Path / Paths / Files的使用
 * 
 * 1.Path/ Paths / Files 在 jdk 7 的NIO2中新增的
 * 2.Path:理解为File类的升级版本
 * 
 */
public class PathFilesTest {
	
	//测试Files中的常用方法3
	@Test
	public void test5() throws IOException{
		//创建Channel的一种方式：jdk7.0以后才可以使用
//		SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
		Path path = Paths.get("d:\\nio\\hello.txt");
		//StandardOpenOption.CREATE_NEW:如果对应的目标文件不存在，就创建。如果存在，就报异常
		//StandardOpenOption.CREATE:如果对应的目标文件不存在，就创建。如果存在，就覆盖
		//此时创建的Channel是双通道的。
		SeekableByteChannel byteChannel = Files.newByteChannel(path, StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//遍历指明文件目录下的所有文件和子目录
//		DirectoryStream<Path>  newDirectoryStream(Path path) : 打开 path 指定的目录
		Path path1 = Paths.get("d:\\nio");
		DirectoryStream<Path> stream = Files.newDirectoryStream(path1);
		
		Iterator<Path> iterator = stream.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next() + "-----");
		}
		//另外一种方式，让流作用在文件上。
//		InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
		InputStream is = Files.newInputStream(path, StandardOpenOption.READ);
		
//		OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
		OutputStream os = Files.newOutputStream(path, StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
	}
	
	//测试Files中的常用方法2
	@Test
	public void test4() throws IOException{
		Path path1 = Paths.get("d:\\nio\\hello.txt");
//		boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
		System.out.println(Files.exists(path1, LinkOption.NOFOLLOW_LINKS));
		Path path2 = Paths.get("d:\\nio\\hello2.txt");
		System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));
		
//		boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
		Path path3 = Paths.get("d:\\nio");
		System.out.println(Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));
		System.out.println(Files.isDirectory(path3, LinkOption.NOFOLLOW_LINKS));
		
//		boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是文件
		System.out.println(Files.isRegularFile(path1, LinkOption.NOFOLLOW_LINKS));
		System.out.println(Files.isRegularFile(path3, LinkOption.NOFOLLOW_LINKS));
		
		
//		boolean isHidden(Path path) : 判断是否是隐藏文件
		System.out.println(Files.isHidden(path1));
		
//		boolean isReadable(Path path) : 判断文件是否可读
		System.out.println(Files.isReadable(path1));
//		boolean isWritable(Path path) : 判断文件是否可写
		System.out.println(Files.isWritable(path1));
		
//		boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
		System.out.println(Files.notExists(path1, LinkOption.NOFOLLOW_LINKS));
	}
	
	//测试Files中的常用方法1
	@Test
	public void test3() throws IOException{
		Path path1 = Paths.get("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/directory1/stars.txt");
		Path path2 = Paths.get("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/directory2/stars.txt");
//		Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
		//要想复制成功，path1对应的文件要存在。
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
		
		
//		Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
		Path path3 = Paths.get("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/directory3");
		Files.createDirectory(path3);//要想成功，保证path对应的文件目录不存在
		
//		Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
		Path path4 = Paths.get("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/directory4/hello2.txt");
		Files.createFile(path4);//要想成功，保证path对应的文件不存在
		
//		void delete(Path path) : 删除一个文件，如果不存在，执行报错
		Files.delete(path4);//只有path对应的文件存在的情况下，才能删除成功。否则，报异常
		
//		void deleteIfExists(Path path) : Path对应的文件如果存在，执行删除
		Files.deleteIfExists(path4);//不管存在与否，都不报异常
		
//		Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
		Path path5 = Paths.get("hello.txt");
		//要想执行成功，必须保证源文件src是存在的。至于目标路径dest存在与否没有影响。如果存在，也是对dest的覆盖
		Files.move(path1, path5, StandardCopyOption.ATOMIC_MOVE);
		
//		long size(Path path) : 返回 path 指定文件的大小
		long size = Files.size(path2);
		System.out.println(size);
		
	}

	// 测试Path中的常用方法
	@Test
	public void test2() {
		String datapath = "/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/";
		Path path = Paths.get(datapath+"stars.txt", datapath+"students.txt");
		Path path1 = Paths.get("stars.txt");

		// String toString() ： 返回调用 Path 对象的字符串表示形式
		System.out.println(path.toString());
		// boolean startsWith(String path) : 判断是否以 path 路径开始
		System.out.println(path.startsWith(datapath));
		// boolean endsWith(String path) : 判断是否以 path 路径结束
		System.out.println(path.endsWith("stars.txt"));
		// boolean isAbsolute() : 判断是否是绝对路径
		System.out.println(path.isAbsolute());
		System.out.println(path1.isAbsolute());
		// Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
		System.out.println(path.getParent());
		System.out.println(path1.getParent());
		// Path getRoot() ：返回调用 Path 对象的根路径
		System.out.println(path.getRoot());
		System.out.println(path1.getRoot());
		// Path getFileName() : 返回与调用 Path 对象关联的文件名
		System.out.println(path.getFileName());
		System.out.println(path1.getFileName());
		// Path getName(int idx) : 返回指定索引位置 idx 的路径名称
		// int getNameCount() : 返回Path 根目录后面元素的数量


		//基于盘符之后，getNameCount():得到包括文件在内的层数。
		//getName(index)：找到指定层数的文件或文件目录
		for(int i = 0;i < path.getNameCount();i++){
			System.out.println(path.getName(i) + "-->目录层级");
		}

		System.out.println("-------------toAbsolutePath() : 作为绝对路径返回调用 Path 对象--------------------------");
		// Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
		System.out.println(path1.toAbsolutePath());


		// Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
		System.out.println("-------------resolve合并两个文件Path对象--------------------------");
		Path path2 = Paths.get(datapath);
		Path path3 = Paths.get("hi.txt");
		Path path4 = path2.resolve(path3);
		System.out.println(path4);


		System.out.println("---------------path.toFile------------------------");
		// File toFile(): 将Path转化为File类的对象
		File file = path.toFile();
		System.out.println(file);

		System.out.println("---------------file.toPath------------------------");
		//File类提供了toPath()方法
		Path path5 = file.toPath();
		System.out.println(path5);
	}

	// 如何实例化Path:Paths类
	@Test
	public void test1() {
		Path path = Paths.get("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/copy.jpg", "/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/stars.txt");// 类似：new
														// File("d:\\","nio\\hello.txt");

		Path path1 = Paths.get("stars.txt");

		System.out.println(path);
		System.out.println("------------------------------");
		System.out.println(path1);

	}
}
