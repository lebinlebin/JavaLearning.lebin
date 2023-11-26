package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.TestDate;

import java.util.Calendar;

/**
 * 此类用于演示第二代日期类
 * Calendar类
 *
 */
public class TestDateSecond {
	
	public static void main(String[] args) {
		
		//1.获取Calendar对象
		Calendar c = Calendar.getInstance();
		System.out.println(c);

		
		//2.通过调用方法获取各个日历字段
		System.out.println("年："+c.get(Calendar.YEAR));
		System.out.println("月："+c.get(Calendar.MONTH));
		System.out.println("日："+c.get(Calendar.DAY_OF_MONTH));
		System.out.println("小时："+c.get(Calendar.HOUR));
		System.out.println("分钟："+c.get(Calendar.MINUTE));
		System.out.println("秒："+c.get(Calendar.SECOND));
		
		System.out.println("星期："+c.get(Calendar.DAY_OF_WEEK));
		
	}

}
