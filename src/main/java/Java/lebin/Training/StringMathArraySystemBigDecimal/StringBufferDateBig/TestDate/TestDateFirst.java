package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.TestDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 此类用于演示第一代日期类
 * Date
 * SimpleDateFormat
 *
 */
public class TestDateFirst {
	//测试Date类
	@Test
	public void testDate(){
		//创建Date对象
		//方式一：调用无参构造器(获取系统当前时间)
		Date d1 = new Date();
		System.out.println(d1);
		
		//方式二：调用有参构造器(获取距离基准时间指定毫秒数的日期对象)  不建议使用！
		Date d2 = new Date(92345678);
		System.out.println(d2);
		
		
		//调用常见方法：getTime
		System.out.println("d1:"+d1.getTime());
		System.out.println("d2:"+d2.getTime());
		
	}
		//测试使用默认格式的SimpleDateFormat类
		@Test
		public void testDateFormat1() throws ParseException{
			//创建日期对象：Fri Mar 30 15:16:41 CST 2018
			Date d = new Date();
			//根据默认格式创建SimpleDateFormat对象
			SimpleDateFormat sdf = new SimpleDateFormat();
			
			//---------------------方法----------------
			
			//格式日期：Date————>String 
			String format = sdf.format(d);
			
			System.out.println(format);
			
			
			//解析日期：String————>Date
			String  s = "18-12-10 下午3:22";
			Date parse = sdf.parse(s);
			
			System.out.println(parse);
			
			
		}
		
		//测试使用自定义格式的SimpleDateFormat类
		@Test
		public void testDateFormat2() throws ParseException{
			//创建日期对象：Fri Mar 30 15:16:41 CST 2018
			Date d = new Date();
			//根据指定格式创建SimpleDateFormat对象
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 a hh小时mm分钟ss秒  E");
			
			//---------------------方法----------------
			
			//格式日期：Date————>String 
			String format = sdf.format(d);
			
			System.out.println(format);
			
			
			//解析日期：String————>Date
//			String  s = "2008年12月30日 01小时26分钟36秒";
//			Date parse = sdf.parse(s);
//			
//			System.out.println(parse);
			
			
		}

}
