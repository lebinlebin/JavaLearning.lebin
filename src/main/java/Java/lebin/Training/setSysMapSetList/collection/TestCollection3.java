package Java.lebin.Training.setSysMapSetList.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * 此类用于演示Collection接口的遍历方式
 * @author liulebin
 *
 */
public class TestCollection3 {
	Collection col;
	
	@Before
	public void before(){

		//1.创建Collection对象
		 col = new ArrayList();
	
		//2.调用方法
		
		col.add(new Book("红楼梦",98,"曹雪芹"));
		col.add(new Book("西游记",93,"吴承恩"));
		col.add(new Book("水浒传",108,"施耐庵"));
		col.add(new Book("三国演义",88,"罗贯中"));
		col.add(new Book("西厢记",68,"王师傅"));
		
		System.out.println("----------------------before----------------");
	}
	
	//方式1：使用迭代器
	@Test
	public void test1(){
		//3.遍历集合
		//①获取迭代器
		Iterator iterator = col.iterator();
		
		//②判断,如果返回true，则进行下一步
		while(iterator.hasNext()){
				//③下移一位，并获取对应元素
				System.out.println(iterator.next());
		}
	}
	
	//方式二：为了简化Iterator的语法，jdk5.0出现了增强for
	/*
	 * 增强for的本质就是Iterator，只是语法简化了！
	 * 
	 * 语法：
	 * for(元素类型 元素名:集合或数组名){
	 * 		//访问元素即可
	 * }
	 * 
	 */
	
	@Test
	public void test2() {
		//3.遍历集合
		for(Object o: col){
			System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<");
			System.out.println(o);
		}
	}
	
	

}
