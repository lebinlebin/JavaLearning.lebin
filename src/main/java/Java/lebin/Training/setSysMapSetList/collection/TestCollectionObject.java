package Java.lebin.Training.setSysMapSetList.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 此类用于演示使用Collection添加对象类型元素 ★
 * @author liulebin
 *
 */
public class TestCollectionObject {
	
	public static void main(String[] args) {
		
		//1.创建Collection对象
		Collection col = new ArrayList();
	
		//2.调用方法
		
		col.add(new Book("红楼梦",98,"曹雪芹"));
		col.add(new Book("西游记",93,"吴承恩"));
		col.add(new Book("水浒传",108,"施耐庵"));
		col.add(new Book("三国演义",88,"罗贯中"));
		col.add(new Book("西厢记",68,"王师傅"));
		
		
		System.out.println(col);
		col.remove(new Book("三国演义",88,"罗贯中"));
		System.out.println(col);
		
		
		
	}

}
