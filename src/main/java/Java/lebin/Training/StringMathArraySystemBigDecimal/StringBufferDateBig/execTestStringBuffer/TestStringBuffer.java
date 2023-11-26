package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.execTestStringBuffer;

import java.util.Scanner;

/**
 * 输入商品名称和商品价格（double类型），要求打印效果示例：
商品名	商品价格
网球拍	123,564.59

要求：价格的小数点前面每三位用逗号隔开

 * @author liulebin
 *
 */
public class TestStringBuffer {
	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("请输入商品名称：");
		String name = input.next();
		System.out.println("请输入商品价格：");
		double price  = input.nextDouble();
		
		//将double——>StringBuffer
		//①将double——>String
		String s = String.valueOf(price);
		//②将String——>StringBuffer
		StringBuffer buffer = new StringBuffer(s);
		//123,564.59
		
		int index =buffer.indexOf(".");
		for(int i=index-3;i>0;i-=3){
			buffer.insert(i, ",");
		}
		
		System.out.println(name+"\t"+buffer);

		
	}

}
