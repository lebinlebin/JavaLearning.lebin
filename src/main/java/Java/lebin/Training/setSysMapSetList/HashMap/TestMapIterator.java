package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * 此类用于演示Map接口的遍历方式
 * @author liulebin
 * 
 * 
方式一：通过调用entrySet


方式二：通过调用keyset
 *
 */
public class TestMapIterator {
	Map map;
	@Before
	public void before(){
		//1.创建Map接口对象
		 map = new HashMap();
		
		
		//2.调用方法
		//方法1：put
		map.put("邓超","孙俪");
		map.put("张继科","景甜");
		map.put("李晨","范冰冰");
		map.put("贾乃亮","李小璐");
		map.put("邓超","江一燕");
		map.put("Pgone","李小璐");
		map.put("王宝强", null);
		map.put(null, "马蓉");
	}
	//方式2：通过调用keySet
	@Test
	public void test2() {

		//通过键值遍历Map
		//步骤1：获取所有的键
		Set keys = map.keySet();
		
		//步骤2：遍历所有的键
		for (Object key : keys) {
			System.out.println(key+":"+map.get(key));
		}
	}

	//方式1：通过调用entrySet；map转化为set集合
	@Test
	public void test1() {
		
		//步骤1 ：获取所有的关系
		Set entrys = map.entrySet();
		//步骤2：遍历所有的关系
		
		Iterator iterator = entrys.iterator();
		while(iterator.hasNext()){
			//获取每一对关系
			Entry entry = (Entry) iterator.next();
			
			//根据关系，获取对应的键
			//根据关系，获取对应的值
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
		

	}
}
