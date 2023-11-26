package Java.lebin.Training.netWork.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 此类用于演示Lambda表达式的好处
 * @author liulebin
 * 
 * 语法更加简洁，使用更加灵活
 *
 */
public class TestLambda1 {

	
	@Test
	public void test1() {

//		Runnable r = new A();
		
		
//		Runnable r = new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("哈哈哈，我跑啊跑");
//				
//			}
//			
//		};
		//使用匿名内部类
//		Thread t = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				System.out.println("哈哈哈，我跑啊跑");
//				
//			}
//			
//		});
//		
//		t.start();
		
		
		//使用Lambda表达式
		
//		Thread t2 =new Thread( ()->System.out.println("哈哈哈，我跑啊跑"));
//		t2.start();
		
		new Thread( ()->System.out.println("哈哈哈，我跑啊跑")).start();
	}
	
	@Test
	public void test2() {
		//使用匿名内部类
		TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		//使用Lambda
		TreeSet<Integer> set2 = new TreeSet<>((o1,o2)->Integer.compare(o1, o2));
	}
	
}


class A implements Runnable{
	public void run() {};
}
