package Java.lebin.Training.setSysMapSetList.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

public class TestList3 {
	//测试ArrayList
	@Test
	public void test1() {

		//1.创建List对象
		ArrayList list = new ArrayList();
		
		//2.添加元素
		
		list.add(new Book("西厢记",12.5,"王师傅"));
		list.add(new Book("梦里花落知多少",60.5,"郭敬明"));
		list.add(new Book("围城",100,"钱钟书"));
		
		//3.遍历
		print2(list);
		
		
	}
	@Test
	public void test2() {

		//1.创建List对象
		LinkedList list = new LinkedList();
		
		//2.添加元素
		
		list.add(new Book("西厢记",12.5,"王师傅"));
		list.add(new Book("梦里花落知多少",60.5,"郭敬明"));
		list.add(new Book("围城",100,"钱钟书"));
		
		//3.遍历
		print2(list);
		
		
	}
	@Test
	public void test3() {

		//1.创建List对象
		Vector list = new Vector();
		
		//2.添加元素
		
		list.add(new Book("西厢记",12.5,"王师傅"));
		list.add(new Book("梦里花落知多少",60.5,"郭敬明"));
		list.add(new Book("围城",100,"钱钟书"));
		
		//3.遍历
		print2(list);
		
		
	}
	//方式1：使用iterator
		public void print1(List list) {
			//3.遍历
			Iterator iterator = list.iterator();
			
			while(iterator.hasNext()){
				Object book = iterator.next();
				System.out.println(book);
			}
		}
		//方式2：使用增强for
		public void print2(List list) {
			//3.遍历
			for (Object object : list) {
				System.out.println(object);
			}
		}

		//方式3：使用普通for
		public void print3(List list) {
			for(int i=0;i<list.size();i++){
				Object object = list.get(i);
				System.out.println(object);
			}
		}

}
