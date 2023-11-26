package Java.lebin.Training.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * 此类用于演示通过反射获取类中的 三大主要成员：属性、方法、构造器
 * @author liulebin
 * Class类
 * 		getFields()
 * 		getDeclaredFields()
 * 		getMethods()
 * 		getDeclaredMethods()
 * 		getDeclaredConstructors()
 * 
 * 		getName()
 * 		getSimpleName()
 * 
 * Field类
 * 		getModifiers():以int形式返回修饰符
 * 		getType():获取Class类型的属性类型
 * 		getName():获取属性名
 * 
 * Method类
 * 		getModifiers():以int形式返回修饰符
 * 		getReturnType():获取Class类型的方法返回类型
 * 		getName():获取方法名
 * 		getParameterTypes():获取参数数组，类型Class[]
 * 
 * 
 * Constructor类
 * 		getModifiers():以int形式返回修饰符
 * 		getName():获取构造器的全类名
 * 		getParameterTypes():获取参数数组，类型Class[]
 *
 */
public class ReflectUtils {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("Java.lebin.Training.reflect.Student");
		
//		printFields(c);
		printMethods(c);
//		printConstructors(c);
	}
	
	/**
	 * 功能：通过反射打印对应类中的所有属性
	 * @param c Class类的对象
	 */
	public static void printFields(Class c){
		
//		Field[] fields = c.getFields();//只能获取所有public修饰的属性，包含从父类继承来和自身定义，不限于直接父类
		Field[] fields = c.getDeclaredFields();//可以获取本类中定义的所有属性，不问修饰符
		
		for (Field field : fields) {
			//①修饰符
			int mod = field.getModifiers();
			
			String modifier = Modifier.toString(mod);
			
			//②属性类型
			
			String typeName = field.getType().getSimpleName();
			
			//③属性名
			String name = field.getName();
			
			System.out.println(modifier+"\t"+typeName+"\t"+name);
		}
		
		
		
	}
	
	/**
	 * 功能：通过反射打印所有 的构造器
	 * @param c
	 */
	public static void printConstructors(Class c){
		
		Constructor[] constructors = c.getDeclaredConstructors();
		
		for (Constructor constructor : constructors) {
			//①修饰符
			String modifier = Modifier.toString(constructor.getModifiers());
			//②方法名
//			String name = constructor.getName();//全类名
			String name = c.getSimpleName();//简单类名&构造器名
			//③参数列表
			
			Class[] parameterTypes = constructor.getParameterTypes();
			StringBuilder builder = new StringBuilder("(");
			for(int i=0;i<parameterTypes.length;i++){
				String simpleName = parameterTypes[i].getSimpleName();
				builder.append(simpleName);
				if(i==parameterTypes.length-1)
					continue;
				builder.append(',');
				
			}
			builder.append(")");
			
			System.out.println(modifier+"\t"+name+builder);
			
		}
		
		
	}
	
	/**
	 * 功能：通过反射打印所有的方法
	 * @param c
	 */
	public static void printMethods(Class c){
		//步骤1：获取所有方法
//		Method[] methods = c.getMethods();//只能获取所有public修饰的方法，包含从父类继承来的和自身定义的，不限于直接父类
		Method[] methods = c.getDeclaredMethods();//可以获取本类中定义的所有方法，不问修饰符
		
		//步骤2：遍历每个方法，打印每个方法签名的四要素
		for (Method method : methods) {
//			public void setAge(int,String) 
			//①修饰符
			String modifier = Modifier.toString(method.getModifiers());
			//②返回类型
			String returnTypeName = method.getReturnType().getSimpleName();
			//③方法名
			String name = method.getName();
			//④参数列表
			
			Class[] parameterTypes = method.getParameterTypes();
			StringBuilder builder = new StringBuilder("(");
			for(int i=0; i<parameterTypes.length; i++){
				String simpleName = parameterTypes[i].getSimpleName();
				builder.append(simpleName);
				if(i == parameterTypes.length-1)
					continue;
				builder.append(',');
				
			}
			builder.append(")");
			
			
			System.out.println(modifier+"\t"+returnTypeName+"\t"+name+builder);
		}
		
	}
}