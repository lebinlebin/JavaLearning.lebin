package Java.lebin.Training.setSysMapSetList.list;

import java.util.ArrayList;

/**
 * 此类用于演示ArrayList的底层结构和源码分析
 * @author liulebin
 *1  ArrayList介绍
 * ArrayList简介
 * ArrayList 是一个数组队列，相当于 动态数组。与Java中的数组相比，它的容量能动态增长。它继承于AbstractList，
 * 实现了List, RandomAccess, Cloneable, java.io.Serializable这些接口。
 * ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
 * ArrayList 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，
 * 为List提供快速访问功能的。在ArrayList中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。
 * 稍后，我们会比较List的“快速随机访问”和“通过Iterator迭代器访问”的效率。
 * ArrayList 实现了Cloneable接口，即覆盖了函数clone()，能被克隆。
 * ArrayList 实现java.io.Serializable接口，这意味着ArrayList支持序列化，能通过序列化去传输。
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class TestArrayList {
	
	public static void main(String[] args) {
		ArrayList list  = new ArrayList();
		for(int i=1;i<=10;i++){
			list.add("john"+i);
		}
		for(int i=11;i<=20;i++){
			list.add("john"+i);
		}
		
		
	}

}
