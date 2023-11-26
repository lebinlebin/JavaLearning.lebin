package Java.lebin.Training.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 此类用于演示泛型的通配符
 * @author liulebin
 * 
 *注意：泛型不具备继承性
 *需求：设计一个方法，可以实现遍历泛型为任意类型的集合
 *
 *	?:代表任意类型的泛型，但使用该通配符做泛型的集合只能读取，不能添加，除了null
 *  ? extends A:代表A类或A类的子类的泛型，确定了泛型的上限，但使用该通配符做泛型的集合只能读取，不能添加，除了null
 *  ? super A:代表A类或A类的父类的泛型，确定了泛型的下限，但使用该通配符做泛型的集合只能读取，不能添加，除了null和A本身类型的对象
 *  
 */
public class TestGeneric {
	
	public static void main(String[] args) {
		Collection<Object> col1 = new ArrayList<>();
		Collection<String> col2 = new ArrayList<String>();
		Collection<Person> col3 = new ArrayList<>();
		Collection<Student> col4 = new ArrayList<>();
		Collection<Teacher> col5 = new ArrayList<>();
		
		printCollection3(col1);
//		printCollection3(col2);
		
		printCollection3(col3);
		printCollection3(col4);
//		printCollection3(col5);
		
		
		
		//泛型不具备继承性
		
//		Collection<Object> col = new ArrayList<String>();
		
		
	}
	//解决方式：
		public static void printCollection3(Collection<? super Student> col){
			
			//更新
				col.add(new Student());
			col.add(null);
			
			//遍历
			
			Iterator<?> iterator = col.iterator();
			
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				
				System.out.println(object);
			}
		}
		
	//解决方式：
	public static void printCollection2(Collection<? extends Person> col){
		
		//更新
//			col.add(new Person());
		col.add(null);
		
		//遍历
		
		Iterator<?> iterator = col.iterator();
		
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			
			System.out.println(object);
		}
	}
	
	//解决方式：
	public static void printCollection1(Collection<?> col){//Collection<Object> col=new ArrayList<String>();
		
		//更新
//		col.add("");
		col.add(null);
		
		//遍历
		
		Iterator<?> iterator = col.iterator();
		
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			
			System.out.println(object);
		}
	}
	
	public static void printCollection(Collection<Object> col){//Collection<Object> col=new ArrayList<String>();
		
	}

}
class Person{}
class Student extends Person{}
class Teacher extends Person{}
