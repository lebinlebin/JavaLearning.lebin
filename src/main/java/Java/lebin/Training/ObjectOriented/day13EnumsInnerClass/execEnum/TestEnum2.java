package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.execEnum;
/*
 * 
 * 声明Week枚举类，其中包含星期一至星期日的定义；
在TestWeek类中声明方法中printWeek(Week week)，根据参数值打印相应的中文星期字符串。
在main方法中接受一个命令行参数，代表星期一至星期日，打印该值对应的枚举值，然后以此枚举值调用printWeek方法，输出中文星期。

 */
public class TestEnum2 {
	
	public static void main(String[] args) {
		//将传入的参数转换成枚举类型
		String s =args[0];
		Week week = Week.valueOf(s);
		printWeek(week);
		
	}
	
	public static void printWeek(Week week){
		switch(week){//switch中判断的变量的类型：int、char、byte、short、String、枚举
		case MONDAY:System.out.println("星期一");break;
		case TUESDAY:System.out.println("星期二");break;
		case WEDNESDAY:System.out.println("星期三");break;
		case THURSDAY:System.out.println("星期四");break;
		case FRIDAY:System.out.println("星期五");break;
		case SATURDAY:System.out.println("星期六");break;
		case SUNDAY:System.out.println("星期日");break;
		}
	}

}
enum Week{
	/**/
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	private int value;

	private Week(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}