package Java.lebin.Training.setSysMapSetList.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * 此类用于演示Collection接口的遍历时容易出现的问题！
 * 特点：
 * ①使用迭代器过程，不适合做增删，容易报异常ConCurrentModificationException
 * ②使用迭代器过程，可以做修改，但如果修改地址，没有效果！
 * ③使用迭代器过程，如果非要做删除，可以使用迭代器本身的remove方法！
 *断点调试：
 *
 *、	1、设置断点
 *	2、启动调试
 *	3、F6 单步执行，不进入方法
 *    F5 单步执行，进入方法
 *    F7 结束当前方法的执行，返回调用方
 *    F8 跳过当前断点，直接执行下一个断点
 */
public class TestCollectionRemove {
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
	@SuppressWarnings("rawtypes")
	@Test
	public void test1(){
		//3.遍历集合
		Iterator iterator = col.iterator();
		
		while(iterator.hasNext()){
			/**
			 *  Object next = iterator.next();
			 *  这样编译类型为Object 需要进行强转换为Book才能获取对应的属性值
			 */
			Book next = (Book) iterator.next();
				//演示：添加
//				col.add(new Book("笑傲江湖",100,"金庸"));
				//演示：删除
				
//				if(next.getPrice()<70){
//					col.remove(next);
//				}
//				System.out.println(next);
			
				//演示：修改
				//更改属性
//				if(next.getPrice()<70){
//					next.setPrice(9999);
//				}
				//更改地址
//				next = new Book("白夜追凶",100,"东野圭吾");
			
			
				//使用迭代器本身的remove方法【建议使用】
				if(next.getPrice()<70){
					iterator.remove();//删除当前指向的元素  expectedModCount实现同步
				}
				
		}
		
		
		for (Object object : col) {
			System.out.println(object);
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
			System.out.println(o);
		}
	}
	
	

}
