package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.enums;
/**
 * 此类用于演示使用传统的方式创建枚举
 * @author liulebin
 * 步骤
 *	1、构造器私有化	
	2、本类内部创建一组对象，添加public static final修饰符，直接暴露对象
 */
public class TestEnum1 {
	public static void main(String[] args) {
		//引用枚举类的对象
//		Gender g = new Gender();//错误 'Gender()' has private access in
		Gender g1 = Gender.BOY;
		System.out.println(g1);
//		g1=new Gender();
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
	}

}


//简单示例2：提供有参构造
class Season{
	private String name;//季节名称
	private String description;//季节描述
	//2.本类内部创建一组对象，添加public static修饰符，直接暴露对象
	public static final Season SPRING = new Season("春天","春风又绿江大南");
	public static final Season SUMMER = new Season("夏天","接天莲叶无穷碧");
	public static final Season AUTUMN = new Season("秋天","霜叶红于二月花");
	public static final Season WINTER = new Season("冬天","千树万树梨花开");

	
	//1、构造器私有化	
	private Season(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "Season [name=" + name + ", description=" + description + "]";
	}
}
//简单示例1： 提供无参构造

class Gender{
	//1、构造器私有化	
	private Gender(){}
	//2.本类内部创建一组对象，添加public static修饰符，直接暴露对象
	public static final Gender BOY = new Gender();
	public static final Gender GIRL = new Gender();

	public void print(){
	}
	@Override
	public String toString(){
		return "这是一个性别";
	}
	
}