package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.execEnum;
/*
 * 创建一个Color枚举类，
1)有 RED,BLUE,BLACK,YELLOW,GREEN这个五个枚举值；
2)Color有三个属性redValue，greenValue，blueValue，
3)创建构造方法，参数包括这三个属性，
4)每个枚举值都要给这三个属性赋值，三个属性对应的值分别是red：255,0,0  blue:0,0,255  black:0,0,0  yellow:255,255,0  green:0,255,0

 */
public class TestEnum {
	
	public static void main(String[] args) {
		System.out.println(Color.RED);
	}

}


enum Color{
	/**/
	RED(255,0,0),
	BLUE(0,0,255),
	BLACK(0,0,0),
	YELLOW(255,255,0),
	GREEN(0,255,0);
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
	/*构造器私有*/
	private Color(int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
	}
	
	
	
	
}