package Java.lebin.Training.Thread.synchronize;

import java.io.File;

/**
 * 3：在main方法中创建并启动两个线程。
 * 
 * 第一个线程统计指定目录下的文件个数及所占总空间数并打印输出，另一个线程打印输出此目录中每个文件信息如文件名称和大小。

 * @author liyuting
 *
 */
public class TestHomework2 {
	
	public static void main(String[] args) {
		
		File file = new File("E:\\0308");
		
		
		MyThread2 m2 = new MyThread2(file);
		
//		m2.setPriority(Thread.MAX_PRIORITY);
		m2.start();
		
		MyThread1 m1 = new MyThread1(file);
//		m1.setPriority(Thread.MIN_PRIORITY);
		m1.start();
	}

}
class MyThread2 extends Thread{
	
	File file;
	public MyThread2(File file){
		this.file=file;
	}
	@Override
	public void run() {
		digui(file);
	}

	private void digui(File file) {
		
		File[] subFiles = file.listFiles();
		for (File sub : subFiles) {
			if(sub.isFile()){
				System.out.println(sub.getName()+":"+sub.length());
			}else{
				digui(sub);
			}
		}
		
	}
		
}

class MyThread1 extends Thread{
	
	File file;
	int countFile = 0;//统计文件的总个数
	long length = 0;//统计文件的总大小
	public MyThread1(File file){
		this.file=file;
	}
	@Override
	public void run() {
		
		digui(file);
		System.out.println("文件个数："+countFile);
		System.out.println("文件总大小:"+length);
	}
	
	public void digui(File file){
		File[] subFiles = file.listFiles();
		
		for (File sub : subFiles) {
			if(sub.isFile()){
				countFile++;
				length+=sub.length();
				
			}else{
				digui(sub);
			}
		}
		
	
		
	}
	
	
}