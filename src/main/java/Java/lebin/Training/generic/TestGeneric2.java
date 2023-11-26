package Java.lebin.Training.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import Java.lebin.Training.setSysMapSetList.treeMap.Employee;

/**
 * 此类用于演示泛型的语法和使用
 * @author liulebin
 *
 */
public class TestGeneric2 {

	//测试Set
	
	@Test
	public void test1() {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<>();//jdk7.0 类型推断
		Set<Integer> set3 = new HashSet();//为了新老版本兼容性，不推荐使用
		Set set4 = new HashSet<Integer>();//为了新老版本兼容性，不推荐使用
		
		
		set.add(100);
//		set.add("");
		Iterator<Integer> iterator = set.iterator();
	}
	
	//测试map
	@Test
	public void test2() {

		Map<String,Employee> map = new HashMap<>();
		
		map.put("john", new Employee("john",13,1));
		
		Set<Entry<String,Employee>> entrySet = map.entrySet();
		
		Iterator<Entry<String,Employee>> iterator = entrySet.iterator();
		
		while (iterator.hasNext()) {
			Entry<String,Employee> entry = iterator
					.next();
			
			System.out.println(entry.getKey());
			
		}
		
		
	}
	
	@Test
	public void test3() {
		List<String> 	 list = new ArrayList<>();
		list.add("john");
		list.add("Poly");
		list.add("john");
		list.add("lilei");
		
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		

	}
}
