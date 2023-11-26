package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类用于演示Map接口的特点和常见方法
 * @author liulebin
 *【面试题】通过size方法和isEmpty方法判断元素个数是否为0，谁的效率高？
 *
 *  答：一样
 */
public class TestMapBasicMethod {
	
	public static void main(String[] args) {
		//1.创建Map接口对象
		Map map = new HashMap();
		
		
		//2.调用方法
		//方法1：put
		//HashMap 允许null值，并允许key-value同时为null
		map.put("邓超","孙俪");
		map.put("张继科","景甜");
		map.put("李晨","范冰冰");
		map.put("贾乃亮","李小璐");
		map.put("邓超","江一燕");
		map.put("Pgone","李小璐");
		map.put("王宝强", null);
		map.put(null, "马蓉");
		
		
		//方法2：remove 指定key
		
		map.remove("贾乃亮");
		
		//方法3：get
		System.out.println(map.get("王宝强"));
		
		//方法4:containsKey|containsValue
		System.out.println(map.containsKey("邓超"));
		System.out.println(map.containsValue("马蓉"));

		//3.遍历 map可以直接sout输出
		System.out.println("---->  "+map);



		//方法5：clear
		map.clear();
		
		
		//方法6：size
		System.out.println(map.size());
		//方法7：isEmpty
		System.out.println(map.isEmpty());

		/**
		 * 这两个是等价的
		 */
		if(map.size()==0){}
		if(map.isEmpty()){}


		//3.遍历
		System.out.println("---->  "+map);

		
	}

}
