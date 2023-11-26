package Java.lebin.Training.setSysMapSetList.treeMap;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 使用Map添加几个员工对象，要求键：员工
值：员工工资

员工类：姓名、工资、编号

要求：先对员工的编号排序，然后再按工资排序

 * @author liulebin
 *
 */
public class TestTreeMap {
	@Test
	public void test1(){
		
		//1.创建TreeMap对象
		TreeMap map = new TreeMap();
		
		//2.添加元素 Employee类，compareTo方法，在treeMap中可以直接按照 顺序打印元素
		map.put(new Employee("岳不群",3000,2), 3000);

		map.put(new Employee("岳灵珊",300,3), 300);
		map.put(new Employee("林平之",8,4), 8);
		map.put(new Employee("依琳",900,3), 300);
		
		//3.遍历元素  自然排序
		Set entrys = map.entrySet();
		
		for (Object object : entrys) {
			Entry entry = (Entry) object;
			
			System.out.println("--->  "+entry.getKey());
		}
	}
	
	//定制排序
	@Test
	public void test2(){
		
		//1.创建TreeMap对象
		TreeMap map = new TreeMap(new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				
				Employee e1=(Employee) o1;
				Employee e2 = (Employee) o2;
				if(e1.getId()>e2.getId())
					return 1;
				else if(e1.getId()<e2.getId())
					return -1;
				
				return Double.compare(e2.getSalary(), e1.getSalary());
			}
			
			
		});
		
		//2.添加元素
		map.put(new Employee("任我行",1000,1), 1000);
		map.put(new Employee("岳不群",3000,2), 3000);

		map.put(new Employee("岳灵珊",300,3), 300);
		map.put(new Employee("林平之",8,4), 8);
		map.put(new Employee("依琳",900,3), 300);
		
		//3.遍历元素
		Set entrys = map.entrySet();
		
		for (Object object : entrys) {
			Entry entry = (Entry) object;
			
			System.out.println(entry.getKey());
		}
	}

}
