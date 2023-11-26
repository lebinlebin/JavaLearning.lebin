package Java.lebin.Training.communication.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 此类用于演示通过反射观察泛型的本质
 * @author liulebin
 * 
 * 特点：泛型只保留在编译期间
 * 
 * 泛型擦除
 *
 */
public class TestReflect {
	
	@Test
	public void test1() {

		//没有使用泛型
		List list = new ArrayList();
		
		list.add("john");
		list.add(100);
		
		//使用泛型
		
		List<String> list2 = new ArrayList<>();
		
		list2.add("john");
//		list2.add(100);
		
		
		System.out.println(list.getClass()==list2.getClass());
	}
	
	@Test
	public void test2() throws Exception {
		List<String> list2 = new ArrayList<>();
		
		//使用反射的方式调用list2的add方法
		
		Class c = list2.getClass();
		
		Method method = c.getMethod("add", Object.class);
		
		method.invoke(list2, "john");
	}

}

class Sub implements A<Integer>{

	@Override
	public void method(Integer t) {
		// TODO Auto-generated method stub
		
	}
	
}
interface A<T>{
	void method(T t);
}
