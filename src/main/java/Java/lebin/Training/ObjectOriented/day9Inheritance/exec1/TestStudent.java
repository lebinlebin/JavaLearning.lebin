package Java.lebin.Training.ObjectOriented.day9Inheritance.exec1;
/**
 * 综合练习：
 * (1)定义Student类,有4个属性：String name; int age; String school;  
      String major
(2)定义Student类的3个构造器:
第一个构造器Student(String n, int a)设置类的name和age属性；
第二个构造器Student(String n, int a, String s)设置类的name, age 和school属性；
第三个构造器Student(String n, int a, String s, String m)设置类的name, age ,school和major属性；
(3)在main方法中分别调用不同的构造器创建的对象，并输出其属性值
 * @author liyuting
 *
 */
public class TestStudent {
	
	public static void main(String[] args) {
		Student s1 = new Student("柳岩",20);
		System.out.println(s1.getInfo());
		
		Student s2 = new Student("刘亦菲",20,"尚硅谷大学");
		System.out.println(s2.getInfo());
		
		Student s3 = new Student("章子怡",39,"尚硅谷小学","大数据");
		System.out.println(s3.getInfo());
	}

}

class Student{
	
	private String name;
	private int age;
	private String school;
	private String major;
	
	public String getInfo(){
		return name+"\t"+age+"\t"+school+"\t"+major;
	}
	
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public Student(String name,int age,String school){
		this(name,age);
		this.school=school;
	}
	public Student(String name,int age,String school,String major){
		this(name,age,school);
		this.major=major;
		
	}
	
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}