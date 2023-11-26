package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.HashMap;
import java.util.Map;
/**
 * 此类用于演示HashMap的底层结构和源码分析
 * @author liulebin
 *
 */

class Person{
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 999;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

	
}
public class HashMapSourceCodeAna {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//1.创建对象
		Map map = new HashMap();
		
		
		//2.添加
		
//		for(int i=1;i<=12;i++){
//			map.put("mr"+i, i);
//		}
//		for(int j=1;j<=12;j++){
//			map.put("lucy"+j, j);
//		}
		int i;
		for ( i =1; i <=8; i++) {
			map.put(new Person("john"+i), i);
		}
		for (; i <=13; i++) {
			map.put(new Person("john"+i), i);
		}
	}

}
