package Java.lebin.Training.Annotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 此类用于演示自定义注解
 * @author liulebin
 * 
 * 1、定义注解的关键字@interface
 * 2、注解类体中的成员是：
 * 	参数类型 方法名();
 *  注意：
 *  ①参数类型只能是 八大基本类型、String、枚举类、Class类型或上述类型的数组类型
 *  ②方法名遵循标识符的命名规则和规范，但建议使用value.因为使用时，可以省略方法名
 *  ③可以在定义方法时，指定默认值，语法：
 *  参数类型 方法名() default 默认值;
 *  
 *  
 *  使用注解：
 *  在被修饰的数据上方，添加注解即可。语法：
 *  @注解类型(方法名=值)
 *  
 */
public class TestAnn2 {
	@MyAnn1(name="yy")
	public static void main(String[] args) {
		
	}

}
enum Gender{
	
}
@Retention(RetentionPolicy.SOURCE)
@interface MyAnn1{
	String name() default "xx";
	
}

class Person{
	
}