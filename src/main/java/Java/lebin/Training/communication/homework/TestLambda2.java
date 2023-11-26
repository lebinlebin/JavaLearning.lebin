package Java.lebin.Training.communication.homework;

import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * 二、①声明一个带两个泛型的接口，泛型类型为<T,R> : T 为参数，R 为返回值。
②接口中声明对应抽象方法
③在LambdaTest类中声明方法，使用接口作为参数，调用接口的抽象方法，打印返回值

实现1：计算两个long型参数的和。
实现2：再计算两个long型参数的乘积

 * @author liyuting
 *
 */


interface B<T,R>{
	R method(T t1, T t2);
	
}
public class TestLambda2 {
	
	
	public Long fun(B<Long,Long> b,long l1,long l2){
		return b.method(l1, l2);
	}
	
	//实现1：计算两个long型参数的和。
	@Test
	public void test1() {
		
//		fun(new B<Long,Long>(){
//
//			@Override
//			public Long method(Long t1, Long t2) {
//				return t1+t2;
//			}
//			
//			
//		},100l,200l);
//		
		
		System.out.println(fun((t1,t2)->t1+t2,100l,200l));;

	}
	
	//再计算两个long型参数的乘积
	@Test
	public void test2() {
		System.out.println(fun((t1,t2)->t1*t2,100l,200l));;
		

	}

}

