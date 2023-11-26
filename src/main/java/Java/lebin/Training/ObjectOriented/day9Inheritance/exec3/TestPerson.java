package Java.lebin.Training.ObjectOriented.day9Inheritance.exec3;
/**
 * 
 * 综合练习
 * 编写一个Person类，包括属性（name、age），构造器、方法say(返回自我介绍的字符串）。
编写一个Student类，继承Person类，增加ID、Score属性，以及构造器，定义say方法。
编写Test类，分别创建Person和Student对象，调用say方法输出自我介绍。

 * @author liyuting
 *
 */
public class TestPerson {
	public static void main(String[] args) {
		Student stu = new Student("john",2, "s001", 98.5);
		System.out.println(stu.say());
	}

}

class Student extends Person{
	/**
	 * 功能：重写say方法
	 */
	public String say(){
		return super.say()+"\t"+ID+"\t"+score;
		
		
	}
	
	
	/**
	 * 功能：有参构造器
	 * @param name
	 * @param age
	 * @param ID
	 * @param score
	 */
	public Student(String name,int age,String ID,double score){
		super(name,age);
		this.ID=ID;
		this.score=score;
		
		
	}
	private String ID;
	private double score;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
class Person{
	
	private String name;
	private int age;
	/**
	 * 功能：返回个人信息
	 * @return 个人信息
	 */
	public String say(){
		return name+"\t"+age;
	}
	/**
	 * 有参构造器
	 * @param name
	 * @param age
	 */
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}