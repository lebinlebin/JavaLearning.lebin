package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.string;
/**
 * 此类用于演示StringBuffer类的常见方法
 * @author liulebin
 * 增
 * 删
 * 改
 * 查
 * 
 * 插
 * 反转
 * 获取长度
 *
 */
public class TestStringBufferMethod {
	
	
	public static void main(String[] args) {
		
		StringBuffer buffer = new StringBuffer("段誉");
		
		//增
		
//		buffer.append(true);
//		buffer.append('男');
//		buffer.append(100);
//		buffer.append(1.5);
//		buffer.append("钟灵");
		
		buffer.append(true).append(1.5).append("木婉清");
		System.out.println(buffer);
		
		
		//改
		//段誉true1.5木婉清

		buffer.replace(2, 6, "false");
		System.out.println(buffer);
		
		//查
		int indexOf = buffer.indexOf("虚竹");
		System.out.println(indexOf);
		
		//删 
		//段誉false1.5木婉清
		buffer.delete(7, 10);
		
		System.out.println(buffer);
		
	}
	
	

}
