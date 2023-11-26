package Java.lebin.Training.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 此类用于演示获取类中的其他结构：包、父类、接口、泛型、注解
 * @author liulebin
 * 
 * 相关API：
 * Class类
 * 		getPackage():获取包对象
 * 		getSuperClass():获取Class类型的父类类型
 * 		getInterfaces():获取Class[] 类型的接口
 * 		getGenericSuperClass():获取父类的泛型
 * 		getGenericInterfaces():获取接口的泛型
 * 		getAnnotations():获取注解
 *
 * Thread类的包、父类、接口、注解
 */
public class ReflectUtils2 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("Java.lebin.Training.reflect.Student");
//		printPackage(c);
//		printSuperClass(c);
		printAnnotation(c);
	}
	//获取包
	public static void printPackage(Class c){
		System.out.println(c.getPackage().getName());
	}
	//获取直接父类
	public static void printSuperClass(Class c){
		System.out.println(c.getSuperclass().getSimpleName());
	}
	//获取实现的所有接口
	public static void printInterfaces(Class c){
		Class[] interfaces = c.getInterfaces();
		for (Class inter : interfaces) {
			System.out.println(inter.getSimpleName());
		}
	}
	
	
	//获取注解
	public static void printAnnotation(Class c){
		
		Annotation[] annotations = c.getAnnotations();
		
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getSimpleName());
		}
		
	}
	
	//获取父类的泛型
	public static void printGenericSuperClass(Class c){
		Type genericSuperclass = c.getGenericSuperclass();//父类类型+泛型类型   Person+Character
		
		if(!(genericSuperclass instanceof ParameterizedType))
			return;
		ParameterizedType pt = (ParameterizedType) genericSuperclass;
		
		Type[] genericTypes = pt.getActualTypeArguments();
		Class  genericT = (Class) genericTypes[0];
		
		System.out.println(genericT.getSimpleName());
		
	}
	//获取接口的泛型 todo:测试
		public static void printGenericInterfaces(Class c){
			Type[] genericInterfaces = c.getGenericInterfaces();
			
		}

}













