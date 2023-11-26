package Java.lebin.Training.setSysMapSetList.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 此类用于演示List接口的遍历方式
 * @author liulebin
 * 
 * 案例：
 * 使用List的实现类添加三本图书，并遍历，打印如下效果
 
名称：xx	价格：xx	作者：xx
名称：xx	价格：xx	作者：xx
并要求按价格排序

 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class TestList2 {
	
	List list;
	@Before
	public void before(){
		//1.创建List对象
		 list = new ArrayList();
		
		//2.添加元素
		list.add(new Book("西厢记",12.5,"王师傅"));
		list.add(new Book("梦里花落知多少",60.5,"郭敬明"));
		list.add(new Book("围城",100,"钱钟书"));
	}
	//按价格进行排序
	@Test
	public void exec(){
		for(int i=0;i<list.size()-1;i++){
			for(int j=0;j<list.size()-1-i;j++){
				Book b1 = (Book) list.get(j);
				Book b2 = (Book)list.get(j+1);
				
				if(b1.compareTo(b2)>0){
					list.set(j, b2);
					list.set(j+1, b1);
				}
			}
		}
		
		print1();
		
		
		
	}
	
	//方式1：使用iterator
	public void print1() {
		//3.遍历
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()){
			Object book = iterator.next();
			System.out.println(book);
		}
	}
	//方式2：使用增强for
	public void print2() {
		//3.遍历
		for (Object object : list) {
			System.out.println(object);
		}
	}

	//方式3：使用普通for
	public void print3() {
		for(int i=0;i<list.size();i++){
			Object object = list.get(i);
			System.out.println(object);
		}
	}
}
