package Java.lebin.Training.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 此类用于演示泛型的好处
 * @author liulebin
 *
 */
public class TestGeneric1 {
	//使用泛型之前
	@Test
	public void test1() {
		
		List list  = new ArrayList();
		//不足1：任意类型元素都可以添加 不安全
		list.add("lucy");
		list.add("john");
		list.add(100);
		
		
		Iterator iterator = list.iterator();
		//不足2：遍历时，需要向下转型
		while (iterator.hasNext()) {
			String	object = (String) iterator.next();
			System.out.println(object.length());
		}
	}
	
	//使用泛型之后
	@Test
	public void test2() {

		List<String> list = new  ArrayList<>();
		//好处1:只能添加指定类型的元素，提高安全性
		list.add("lucy");
		list.add("john");
//		list.add(100);

		//好处2：不需要向下转型，提高效率
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string.length());
		}
	}

}
