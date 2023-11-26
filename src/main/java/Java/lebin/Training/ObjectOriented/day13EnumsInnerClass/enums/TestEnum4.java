package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.enums;
/**
 * 此类用于演示枚举类实现接口
 * @author liulebin
 * 
 * 特点：
 * 	1.和普通类实现接口一样，只是允许枚举常量也有自己对抽象方法的特有实现！
 * 	2.enum类不能再继承其他类，因为已经隐式的直接继承了Enum类
 * 语法：
 * enum A implements 接口1，接口2{
 * 		常量1(参数){
 * 			//抽象方法的实现
 * 
 * 		},常量2(参数){
 * 
 * 			//抽象方法的实现
 * 		}
 * 		//类对抽象方法的实现
 * 
 * }
 *
 */
public class TestEnum4 {
	
	public static void main(String[] args) {
		Show s = Color4.RED;
		s.display();
		
		Color4.BLACK.display();
	}

}

class Super{
	
	
}
//interface Fly{
//	void fly();
//}
interface Show{
	void display();
}
enum Color4 implements Show{
	/**/
	RED(255,0,0){
		@Override
		public void display(){
			System.out.println("我是红色");
		}
	},
	BLUE(0,0,255){
		@Override
		public void display(){
			System.out.println("我是蓝色");
		}
	},
	BLACK(0,0,0){
		@Override
		public void display(){
			System.out.println("我是黑色");
		}
	},
	YELLOW(255,255,0){
		@Override
		public void display(){
			System.out.println("我是黄色");
		}
	},
	GREEN(0,255,0){
		@Override
		public void display(){
			System.out.println("我是蓝色");
		}
	};
	private int redValue;
	public int getRedValue() {
		return redValue;
	}
	public int getGreenValue() {
		return greenValue;
	}
	public int getBlueValue() {
		return blueValue;
	}
	private int greenValue;
	private int blueValue;
	private Color4(int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
	}
//	@Override
//	public void display() {
//		System.out.println("我是一个颜色：三原色："+redValue+","+greenValue+","+blueValue);
//		
//	}
//	@Override
//	public void fly() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	public String toString(){
//		return redValue+"\t"+greenValue+"\t"+blueValue;
//	}
}