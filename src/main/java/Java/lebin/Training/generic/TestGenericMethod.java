package Java.lebin.Training.generic;
/**
 * 此类用于演示自定义泛型方法
 * @author liyuting
 * 可以定义在普通类和接口中，也可以定义在泛型类或泛型接口中
 * 语法：
 * 修饰符 <T>返回类型 方法名(参数列表){}
 * 
 * 使用：
 * 当调用该泛型方法时，传递具体的参数值时，隐含着指定了泛型的类型，也就是参数值的类型就是具体的确定类型！
 * 
 * 
 * 注意：
 * 
 * 泛型方法如果设计在泛型类或泛型接口中，最好不要和泛型类|接口中的泛型符号一致，因为容易混淆！
 */
public class TestGenericMethod {
	
	public static void main(String[] args) {
//		A a = new A();
//		a.method("hello",100);
//		a.method(100,1.5);
		
		
		G<String> g = new G<>();
		g.setName("john");
		g.method(1.5);
		
	}

}
class G<T>{
	T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
	public <E> void method(E t){
		System.out.println("------------------");
		System.out.println("传过来的值t："+t);
		System.out.println("传过来的类型T:"+t.getClass().getSimpleName());//获取类名
	}
	
}

class A{
	
	public <T,U> void method(T t,U u){
		System.out.println("------------------");
		System.out.println("传过来的值t："+t);
		System.out.println("传过来的类型T:"+t.getClass().getSimpleName());//获取类名
		
		System.out.println("传过来的值u："+u);
		System.out.println("传过来的类型U:"+u.getClass().getSimpleName());//获取类名
		
	}
}