package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.TestStringBuffer;
/**
 * 此类用于演示StringBuffer的常见方法
 * @author liulebin
 * 增 append
 * 删 delete
 * 改 replace
 * 查 indexOf/lastIndexOf
 * 插入 insert
 * 反转 reverse
 * 长度 length
 * 
 */
public class TestStringBuffer2 {
	
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("张无忌");
		//增
		s.append("赵敏");
		s.append(true).append("周芷若").append(',').append(100);
		System.out.println(s);
		
		//删
		//张无忌赵敏true周芷若,100
		s.delete(5, 9);
		System.out.println(s);
		
		//改
//		张无忌赵敏周芷若,100
		
		s.replace(9, 12, "小昭");
		System.out.println(s);
		
		//查
		int lastIndexOf = s.lastIndexOf(",");
		System.out.println(lastIndexOf);
		
		//插入
//		张无忌赵敏周芷若,小昭
		
		s.insert(5,"宋青书");
		System.out.println(s);
		
		//反转
		s.reverse();
		System.out.println(s);
		
		//长度
		System.out.println(s.length());
		
		

	}

}
