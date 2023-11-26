package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.TestDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

/**
 * 此类用于演示第三代日期
 * @author liulebin
 * 
 * LocalDate/LocalTime/LocalDateTime
 * Instant
 * DateTimeFormatter
 * 
 *
 */
public class TestDateThird {
	
	//Instant
	@Test
	public void testInstant() {
		//1.获取Instant对象
		Instant instant = Instant.now();
		//2.Instant和Date之间的转换
		//①Instant——>Date
		Date date = Date.from(instant);
		
		
		//②Date——>Instant
		Instant instant2 = date.toInstant();
		
		System.out.println(instant2);
		
		
	
	}
	
	//LocalDate/LocalTime/LocalDateTime
	@Test
	public void test1() {
		
		//1.获取LocalDateTime对象
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now);
		
		
		//2.获取各个日历字段
		System.out.println(now.getYear());
		System.out.println(now.getMonthValue());
		System.out.println(now.getMonth());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		System.out.println(now.getDayOfWeek());
		
		

	}
	//测试DateTimeFormatter
	@Test
	public void test2() {
		
		LocalDateTime now  = LocalDateTime.now();
		//1.根据指定的格式创建DateTimeFormatter对象
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
		
		//2.--------------调用方法-----------------------
		
		//格式日期：Date——>String
		String format = dtf.format(now);
		
		System.out.println(format);
		
		//解析日期：String——>Date
		
		LocalDateTime parse = LocalDateTime.parse("2018年03月30日 16小时02分钟06秒",dtf);
		System.out.println(parse);
		
		
		
		

	}

}
