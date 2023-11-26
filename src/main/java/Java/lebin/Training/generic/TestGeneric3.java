package Java.lebin.Training.generic;

import org.junit.Test;

/**
 * 此类用于演示自定义泛型
 * @author liulebin
 *
 */
public class TestGeneric3 {
	
	//测试：泛型类的使用
	@Test
	public void test1() {
		MyGenericClass<String,Object,Object,Object> mc = new MyGenericClass<>();
		mc.name="john";
		mc.setName("");
		System.out.println(mc.getName());
	}

}
class MySub implements Sub<String,Integer,Double>{

	@Override
	public void method1(String t, Integer u, Double m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer method3(String t1, String t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double method4(String t, Integer u) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

interface Sub<T,U,M> extends MyGenericInter<T,U,M>{
	
}

class MyGenericImpl<T,U,M> implements MyGenericInter<T,U,M>{

	@Override
	public void method1(T t, U u, M m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public M method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public U method3(T t1, T t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public M method4(T t, U u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
//自定义泛型接口
interface MyGenericInter<T,U,M>{
	
	void method1(T t, U u, M m);
	M method2();
	U method3(T t1, T t2);
	M method4(T t, U u);
	
}

//自定义泛型类
class MyGenericClass<A,B,C,D>{
	A name;
	int age;
	
//	A[] arr = new A[100];//①不允许
//	public static void method(A a){//② 不允许
//		System.out.println("static method");
//	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(A name){
		this.name=name;
	}
	
	public A getName(){
		return name;
	}
	
	
	
	
}