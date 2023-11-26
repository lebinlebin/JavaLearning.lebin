package Java.lebin.Training.setSysMapSetList.treeset;

import java.util.Comparator;
import java.util.TreeSet;

import org.junit.Test;

import Java.lebin.Training.setSysMapSetList.utils.CollectionUtils;
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestTreeSet {
	//使用自然排序
	
	@Test
	public void test1(){
		
		//1.创建TreeSet对象
		TreeSet set = new TreeSet();
		
		//2.添加
		
		 set.add(new Book("百年孤独",100,"马尔克斯"));
		 set.add(new Book("春风十里不如你",80,"冯唐"));
		 set.add(new Book("多情剑客无情剑",60,"古龙"));
		 set.add(new Book("春风十里不如你",80,"冯唐"));
		 
		 
		 //3.遍历
		 
		 CollectionUtils.print1(set);
	}
	//使用定制排序
		@Test
		public void test2(){
			
			//1.创建TreeSet对象
			TreeSet set = new TreeSet(new Comparator(){

				@Override
				public int compare(Object o1, Object o2) {
					
					Book b1 = (Book) o1;
					Book b2 = (Book) o2;
					return Double.compare(b2.getPrice(),b1.getPrice());
				}
				
				
			});
			
			//2.添加
			
			 set.add(new Book("百年孤独",100,"马尔克斯"));
			 set.add(new Book("春风十里不如你",80,"冯唐"));
			 set.add(new Book("多情剑客无情剑",60,"古龙"));
			 set.add(new Book("春风十里不如你",80,"冯唐"));
			 
			 
			 //3.遍历
			 
			 CollectionUtils.print1(set);
		}

}
