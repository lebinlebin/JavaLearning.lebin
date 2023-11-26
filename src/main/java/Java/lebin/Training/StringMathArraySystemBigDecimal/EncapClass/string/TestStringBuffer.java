package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.string;
/**
 * 此类用于演示StringBuffer的构造器
 * @author liulebin
 *
 */
public class TestStringBuffer {
	
	public static void main(String[] args) {
		
		StringBuffer s1 = new StringBuffer();//初始化了char[],容量为16
		
		StringBuffer s2 = new StringBuffer(200);//初始化了char[],容量为指定的容量20
		
		
		StringBuffer s3 = new StringBuffer("hello");//初始化了char[],容量为str.length+16,初始值：str
		
		
//		StringBuffer s = "hello";
	}

}
