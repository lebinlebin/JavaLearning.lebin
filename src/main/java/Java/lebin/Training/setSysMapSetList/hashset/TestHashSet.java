package Java.lebin.Training.setSysMapSetList.hashset;

import java.util.HashSet;
import Java.lebin.Training.setSysMapSetList.treeset.Book;
import Java.lebin.Training.setSysMapSetList.utils.CollectionUtils;

/**
 * 此类用于演示HashSet的特点和底层
 * @author liulebin
 *
 */

public class TestHashSet {
	public static void main(String[] args) {
		//1.创建HashSet对象
		HashSet set = new HashSet();
		//2.添加
		System.out.println(set.add(new Book("百年孤独",100,"马尔克斯")));
		System.out.println(set.add(new Book("春风十里不如你",80,"冯唐")));
		System.out.println(set.add(new Book("多情剑客无情剑",60,"古龙")));
		System.out.println(set.add(new Book("春风十里不如你",80,"冯唐")));
		//3.遍历
		CollectionUtils.print1(set);
	}

}
