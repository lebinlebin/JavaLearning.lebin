package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo1EqualsFinalizeToString;

import Java.lebin.Training.ObjectOriented.day11staticAndSingleton.bean.Person;

/**
 * 此类用于演示Object类的常见方法：equals
 * @author liulebin
 * 
 * 【面试题】==和equals的对比
 * 
 * == 可以判断基本类型或引用类型，不管判断什么类型的元素，都要求 左右两边的类型一致或兼容，否则编译报错
 * 		如果判断的是基本类型，则判断的是值是否相等。示例：100==‘d’ true	  1.0==1 true
 * 		如果判断的是引用类型，则判断的是地址是否相等。示例：person1==person2    string1 == string2
 *
 *
 * equals 只能判断引用类型,可以判断任何引用类型，编译不会报错
 * 		Object类的equals：判断的就是地址是否相等！往往子类需要重写equals方法，实现判断内容是否相等。比如：String、Integer类等都重写了equals方法
 * 
 * 		public boolean equals(Object obj){
 * 			return this == obj;
 * 		}
 *
 */
public class TestEquals1 {
	
	public static void main(String[] args) {
		//测试==
		Person person1 = new Person("john", 12);
		Person person2 = new Person("john", 12);
		Person person3 = new Person("john", 2);
		
		Person person4 = person1;//将person1的地址赋值给person4.person1和person4都指向了同一个对象
		
		System.out.println(person1==person4);
		
		
		//测试equals
		System.out.println(person1.equals(person4));
//		System.out.println(person1.equals(person3));
//		System.out.println(person1.equals("john"));
		
		
		
	}

}
