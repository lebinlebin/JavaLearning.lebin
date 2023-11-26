package Java.lebin.Training.setSysMapSetList.hashset;

import java.util.HashSet;
import java.util.Set;

import Java.lebin.Training.setSysMapSetList.utils.CollectionUtils;

/**
 * 此类用于演示Set接口的特点和特有方法
 * @author liulebin
 *
 */

public class TestSet {
	
	public static void main(String[] args) {
		//1.创建Set接口的对象
		Set set  = new HashSet();
		
		//2.添加
		set.add("john");
		set.add("lucy");
//		set.add(null);
		
		set.add("john");
		
		set.add("rose");
		set.add(null);
		
		//3.遍历
		
		System.out.println(set);
		
//		CollectionUtils.print1(set);
		CollectionUtils.print2(set);
	}

}
