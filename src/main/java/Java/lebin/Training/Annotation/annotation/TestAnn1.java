package Java.lebin.Training.Annotation.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 此类用于 演示三种基本注解的使用
 * @author liulebin
 * @Override：只能用于修饰方法，检测被修饰的方法是否为有效的重写，如果不是，则报编译错误！ 
 * @Deparecated:用于表明被修饰的数据已经过时，不建议使用，为了新老版本的兼容，没有贸然的废弃，只是提醒！：
 * 				类或接口、属性、方法、构造、局部变量、包、参数
 * 可以用于修饰
 * @Suppresswarnings:用于抑制程序中的编译警告，可以用于修饰类或接口、属性、方法、构造、局部变量、参数
 * 
 */
public class TestAnn1 {
	@SuppressWarnings(value={ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		Father3 f = new Father3();
		f.show();
		int i;
		List list = new ArrayList();
		
		list.add("john");
		list.add("john");
		
		list.add("john");
		list.add("john");
		list.add("john");
		list.add("john");
		
		
		Collections.sort(list, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
	}

}

class Father3{
	@Deprecated
	public void show(){
		System.out.println("哈哈哈，今天天气好好呀");
		
	}
	public void ol(){
		System.out.println("Father method");
	}
}
class Son extends Father3{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
	}
	String name;
	@Override
	public void ol(){
		System.out.println("Father method");
	}
}