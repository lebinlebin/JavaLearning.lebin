package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.execinner;
/**
 * 有一个铃声接口类Bell，里面有个ring方法。
有一个手机类Cellphone，具有闹钟功能alarmclock，参数是Bell类型，
测试手机类的闹钟功能，通过匿名内部类作为参数，打印：懒猪起床了。
 */
public class TestInner2 {
	public static void main(String[] args) {
		CellPhone cp = new CellPhone();
		//调用并实现接口
		cp.arlarmClock(new Bell(){
			@Override
			public void ring() {
				System.out.println("懒猪起床了！");
				
			}
			
		});
	}

}
class CellPhone{
	void arlarmClock(Bell b){
		b.ring();
	}
}

interface Bell{
	void ring();
}