package Java.lebin.Training.setSysMapSetList.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Java.lebin.Training.setSysMapSetList.utils.CollectionUtils;

/**
 * 此类用于演示Collections工具类的常见方法
 * @author liulebin
 *reverse(List)：反转 List 中元素的顺序
shuffle(List)：对 List 集合元素进行随机排序
sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
Object min(Collection)
Object min(Collection，Comparator)
int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
void copy(List dest,List src)：将src中的内容复制到dest中
boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值


 */@SuppressWarnings({"unchecked","rawtypes"})
public class TestCollections {
	List list;
	@Before
	public void before(){
		 list = new ArrayList();
		list.add("john");
		list.add("Poly");
		list.add("john");
		list.add("lilei");
		
		CollectionUtils.print1(list);
	}
	//方法1：reverse
	@Test
	public void test1() {
		Collections.reverse(list);
		//遍历打印
		CollectionUtils.print1(list);
	}
	//方法2：shuffle
	@Test
	public void test2() {
		Collections.shuffle(list);
		//遍历打印
		CollectionUtils.print1(list);
	}
	//方法3：sort(list)
	@Test
	public void test3() {
		Collections.sort(list);
		CollectionUtils.print1(list);
	}
	//方法4：sort(list,comparator)
		@Test
		public void test4() {
			Collections.sort(list,new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					String s1 = (String) o1;
					String s2 = (String) o2;
					return -s1.compareTo(s2);
				}
				
				
			});
			CollectionUtils.print1(list);
		}
		
		//方法5：swap(int index1,int index2)
		@Test
		public void test5() {

			Collections.swap(list, 9, 1);
			CollectionUtils.print1(list);
		}

		//方法6：max(collection,comparator)
		@Test
		public void test6() {

			Object max = Collections.max(list,new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					String s1 = (String) o1;
					String s2 = (String) o2;
					return s1.compareTo(s2);
				}});
			
			System.out.println(max);
		}
		//方法7：frequency
		@Test
		public void test7() {
			
			int frequency = Collections.frequency(list, "john");
			
			System.out.println(frequency);

		}
		
		//方法8：copy
		@Test
		public void test8() {

			List dest=  new ArrayList();
			for(int i=1;i<=10;i++){
				dest.add("魏华"+i);
			}
			Collections.copy(dest, list);
			System.out.println("打印新集合的内容：");
			CollectionUtils.print1(dest);
			
		}
		//方法9：replaceAll
		@Test
		public void test9() {

			Collections.replaceAll(list, "john", "张益达");
			
			CollectionUtils.print1(list);
		}
}
