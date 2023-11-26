package Java.lebin.Training.setSysMapSetList.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 此类用于演示List接口的特点和特有方法
 * @author liulebin
 * add(object)增
 * remove(index)按指定索引删
 * set(index,object)改
 * indexOf(object)查
 * add(index,object)插入
 * get(index)获取
 * 
 * 
 *
 */
public class TestList2ArrayList {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//1.创建List接口的对象
		List list = new ArrayList();
		//2.调用添加
		list.add("john");
		list.add("lucy");
		list.add(null);
		list.add("john");
		list.add(null);
		list.add("jack");
		System.out.println(list);
		
		//特有方法1：add(index,object)插入
		list.add(0, "张益达");
		System.out.println(list);
		//特有方法2：remove(index) 删除
		/*
		 * 细节：如果元素类型为整型，如果删除的实参为int类型，默认是按索引删除；
		 * 如果想按指定元素删除，则需要装箱再删除！
		 */
		list.remove(2);
		
		//特有方法3：set(index,object)修改
		System.out.println(list);
//		[张益达, john, null, john, null, jack]
		list.set(2, "虚竹");
		
		//特有方法4：indexOf(object)查找
		System.out.println(list.indexOf("张益达"));
		
		//特有方法5：get(index)获取
		System.out.println(list.get(3));
		

		//3.遍历
		
		System.out.println(list);
		
	}
	
	
	@Test
	public void exec1() {
		
		List list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		System.out.println(list);
		/*
		 * 细节：如果元素类型为整型，如果删除的实参为int类型，默认是按索引删除；
		 * 如果想按指定元素删除，则需要装箱再删除！
		 */
		list.remove(200);
		list.remove(new Integer(100));
		System.out.println(list);

	}
	
}
