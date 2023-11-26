package Java.lebin.Training.Annotation.exec1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
 * 
 * 1.编写一个Person类，使用Override注解它的toString方法

2.自定义一个名为“MyTiger”的注解类型，它只可以使用在方法上，带一个String类型的value方法，然后在第1题中的Person类上正确使用
 */
public class TestAnn {

}

@Target(ElementType.METHOD)
@interface MyTiger{
	String value() default "";
	
	
}



class Person{
	@MyTiger
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
//	@Override
//	public String toString(){
//		return "我是一个好人！";
//	}
	
	
	
}