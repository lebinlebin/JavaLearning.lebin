package Java.lebin.Training.setSysMapSetList.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 此类用于演示Collection接口的常见方法
 * add/addAll
 * remove/removeAll
 * contains/containsAll
 * clear
 * size
 * isEmpty
 */
public class TestCollectionbasic {

	public static void main(String[] args) {
		//1.创建Collection接口对象
		Collection col = new ArrayList();
		//2.调用常见方法
		//方法1：add
		col.add("赵四");
		col.add(true);
		col.add(null);
		col.add("男");
		col.add(180.5);
		System.out.println(col);
		//方法2：addAll
		Collection c = new ArrayList();
		c.add("蓝盈莹");
		c.add("周一围");
		col.addAll(c);
		System.out.println(col);
		//方法3：remove
		col.remove("蓝盈莹2");
		System.out.println(col);
		//方法4：removeAll
		Collection c1 = new ArrayList();
		c1.add(null);
		c1.add(180.5);
		col.removeAll(c1);
		System.out.println(col);
		
		
		//方法5：clear清除
//		col.clear();
//		System.out.println(col);
		
		
		//方法6：contains查找
		boolean contains = col.contains("赵四");
		System.out.println(contains?"赵四存在":"赵四没了");
		
		
		//方法7：containsAll批量查找
		Collection c2 = new ArrayList();
		c2.add("赵四");
		c2.add("蓝盈莹");
		c2.add("周一围");
		
		System.out.println(col.containsAll(c2));
		
		
		//方法8：size 获取实际元素个数
		System.out.println(col.size());
		
		
		//方法9：isEmpty 判断是否为空
		System.out.println(col.isEmpty());
	}
}
