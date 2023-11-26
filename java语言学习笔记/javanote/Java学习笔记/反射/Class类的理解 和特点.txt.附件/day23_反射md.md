##本单元目标

	1.反射的理解和好处
	2.Class类的理解和特点
	3.通过反射获取类中的成员【了解】
	4.通过反射创建对象【掌握】
	5.通过反射调用类中的成员【掌握】
	6.通过反射观察泛型的本质



##1.反射的理解和好处


###反射的理解

	正常的程序：
		类——>对象——>调用里面的成员


	反射：

		对象——>类——>调用里面的成员



###反射的好处


案例1：

	张三和李四共同完成一个项目

	张三：设计类：Music类（√）、Word类（×）

	李四：创建对象，并调用里面的方法

	public void method(){
		Music m = new Music();
		m.work();

		Word w = new Word();//编译错误
		w.work();


	}


	//使用反射

	public void method(Object o){
		
		Object obj = o.getClass().newInstance();
		
		o.getClass().getMethod("work").invoke();
	}




静态加载：编译期加载，也就是说编译时加载所有类，如果该类不存在，则直接报编译错误，所以依赖性太强。


动态加载：运行期加载，也就是说运行时加载用到的类，降低了依赖性


案例2：
	method("john");
	public<T> void method(T t){

		t.getClass();
		

	}





	


##Class类的理解和特点 ★


###理解

问：自定义的类，是一个对象吗？

答：是


问：自定义的类，是哪个类型的对象？

答：java.lang.Class类


	There is a class named Class;
	
	
	
	class Person{
		String name;
		public void method(){}
	
	}
	
	class Student{
	
	
	}
	
	class Book{
	
	
	}
	
	class MyClass{
	
		String className;
		public String getName(){}
		Field[] fields;
		Method[] methods;
	}



问：Class类的对象如何创建

答：不是new出来的，而是系统自动创建的，我们可以通过一定的方式获取对象的引用



###特点
	1.Class本身也是一个类
	2.Class 对象只能由系统建立对象
	3.一个类在 JVM 中只会有一个Class实例 
	4.一个Class对象对应的是一个加载到JVM中的一个.class文件
	5.每个类的实例都会记得自己是由哪个 Class 实例所生成
	6.通过Class可以完整地得到一个类中的完整结构 
