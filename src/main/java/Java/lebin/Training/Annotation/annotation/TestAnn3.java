package Java.lebin.Training.Annotation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author liulebin
	Retention:用于指明被修饰的注解可以保留多长
	RententionPolicy:SOURCE  CLASS  RUNTIME
	Target：用于指明被修饰的注解可以用于修饰哪些数据
	ElementType:TYPE LOCAL_VARIABLE FIELD METHOD等
	Documented：能否在生成的帮助文档中显示
	Inherited：注解是否具备继承性
 *
 *
 */
@MyAnn3
public class TestAnn3 {
	@MyAnn3
	String color;
	@MyAnn3
	public static void main(String[] args) {
		
	}

}

@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnn3{
	
	
}