package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.TestStringBuffer;
/**
 * 此类用于演示StringBuffer类和String类之间的转换
 * @author liulebin
 *
 */
public class TestStringBuffer {
	
	public static void main(String[] args) {
		
//		StringBuffer——>String
		StringBuffer buffer = new StringBuffer("john");
		
		//方式一：
		String s1 = buffer.toString();
		
		//方式二：
		
		String s2 = new String(buffer);
		
//		String————>StringBuffer
		
		String s = "鸠摩智";
		//方式一：
		StringBuffer b1 = new StringBuffer(s);
		
		//方式二：
		StringBuffer b2 = new StringBuffer();
		b2.append(s);
	}

}
