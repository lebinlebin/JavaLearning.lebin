package Java.lebin.Training.netWork.homework;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**2、利用反射和File完成以下功能
获取File类中的所有方法和构造器
利用Class类的forName方法得到File类（）
通过newInstance的方法创建File对象，并创建D：\mynew.txt文件 
*/
public class TestReflect {
	
	/*
	 * 利用Class类的forName方法得到File类（）
通过newInstance的方法创建File对象，并创建D：\mynew.txt文件 
	 */
	
	@Test
	public void test3 ()throws Exception {
		Class<?> c = Class.forName("java.io.File");
//		Object newInstance = c.newInstance();
		Constructor con = c.getConstructor(String.class);
		
		Object object = con.newInstance("E:\\mynew.txt");
		
		Method method = c.getMethod("createNewFile");
		
		method.setAccessible(true);
		
		Object returnValue = method.invoke(object);

		System.out.println(returnValue);
		
		
		
		
	}
	// 获取File类中的所有方法
	@Test
	public void test1() throws ClassNotFoundException {
		
		Class c = Class.forName("java.io.File");
		
		Method[] methods = c.getDeclaredMethods();
		
		for (Method method : methods) {
			
			String methodName = method.getName();
			StringBuilder builder  = new StringBuilder("(");
			Class<?>[] parameterTypes = method.getParameterTypes();
			
			for (int i = 0; i < parameterTypes.length; i++) {
				builder.append(parameterTypes[i].getSimpleName());
				if(i==parameterTypes.length-1)
					continue;
				builder.append(",");
			}
			builder.append(")");
			System.out.println(methodName+builder);
		}
		

	}

	// 获取File类中的所有构造器
	@Test
	public void test2() throws ClassNotFoundException {
		Class c = Class.forName("java.io.File");
		
		Constructor[] constructors = c.getDeclaredConstructors();
		
		for (Constructor con : constructors) {
			
			String methodName =c.getSimpleName();
			StringBuilder builder  = new StringBuilder("(");
			Class<?>[] parameterTypes = con.getParameterTypes();
			
			for (int i = 0; i < parameterTypes.length; i++) {
				builder.append(parameterTypes[i].getSimpleName());
				if(i==parameterTypes.length-1)
					continue;
				builder.append(",");
			}
			builder.append(")");
			System.out.println(methodName+builder);
		}
		

	}

}
