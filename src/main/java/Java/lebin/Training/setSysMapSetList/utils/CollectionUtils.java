package Java.lebin.Training.setSysMapSetList.utils;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
	/**
	 * 使用迭代器进行遍历
	 * @param col
	 */
	public static void print1(Collection col){
		Iterator iterator = col.iterator();
		
		while(iterator.hasNext()){
			Object book = iterator.next();
			System.out.println(book);
		}
		
	}
	
	/**
	 * 使用增强for进行遍历
	 * @param col
	 */
	public static void print2(Collection col){
		for (Object object : col) {
			System.out.println(object);
		}
		
	}

}
