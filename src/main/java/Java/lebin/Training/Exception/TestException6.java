package Java.lebin.Training.Exception;
/**
 * 此类用于演示子类重写父类方法时对异常类型的要求
 * @author liyuting
 * 
 * 要求：子类方法抛出的异常类型要么相同，要么为子类类型
 *
 */
public class TestException6 {

}


class Son extends Father{

	@Override
	public void method() throws NullPointerException {
		super.method();
	}
	
}
class Father{
	
	public void method() throws RuntimeException{
		
	}
}
