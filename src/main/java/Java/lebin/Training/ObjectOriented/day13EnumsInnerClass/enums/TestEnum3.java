
package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.enums;

/**
 * 此类用于演示枚举类的常见方法
 * @author liulebin
 * 
 * toString:Enum类已经重写过了，返回的是当前对象的常量名。自定义的枚举类可以继续重写该方法
 * name:Enum类中的name方法返回的是当前对象的常量名（同toString），但自定义的枚举类不可以继续重写该方法
 * values:一个静态方法，用于返回指定的枚举类中的所有枚举常量
 * 
 * valueOf:一个静态方法，将一个有效的字符串转换成枚举对象
 */

public class TestEnum3 {
	
	public static void main(String[] args) {
		System.out.println(Color2.RED.toString());
		System.out.println(Color2.RED.name());
		//返回Color2中所有的枚举常量
		Color2[] values = Color2.values();
		for(int i=0;i<values.length;i++){
			System.out.println(values[i].name());
		}
		
		Color2 c = Color2.valueOf("RED");
		System.out.println(c.name());
	}

}
enum Color2{
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
	private Color2(int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
	}
	
	@Override
	public String toString(){
		return redValue+"\t"+greenValue+"\t"+blueValue;
	}
}