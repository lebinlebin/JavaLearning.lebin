package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Java.lebin.Training.setSysMapSetList.treeMap.Employee;

/**
 * 使用Map添加几个员工对象，要求键：员工
值：员工工资

员工类：姓名、工资、编号

 * @author liulebin
 *
 */
public class TestMapIterator1 {
	
	public static void main(String[] args) {
		//1.创建Map对象
		Map map = new HashMap();
		
		//2.添加员工
		map.put(new Employee("任我行",1000,1), 1000);
		map.put(new Employee("岳不群",3000,2), 3000);

		map.put(new Employee("岳灵珊",300,3), 300);
		map.put(new Employee("林平之",8,4), 8);
		map.put(new Employee("岳灵珊",300,3), 300);
		
		//3.遍历
		
		//方式1：通过entryset
		
		Set entrys = map.entrySet();
		
		for (Object object : entrys) {
			Entry entry = (Entry) object;
			
			System.out.println(entry.getKey()+"的工资是："+entry.getValue());
			
		}
		System.out.println("---------------------------");
		
		//方式2：通过keySet
		
		Set keys = map.keySet();
		
		for (Object key : keys) {
			System.out.println(key+"的工资是："+map.get(key));
		}
		
		
	}

}
