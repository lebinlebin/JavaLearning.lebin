package Java.lebin.Training.reflect;

class Person<T>{
	public String nation;
	private double height;
	public void method(){
	}
}

interface Fly<T>{

}

interface Swim<T,U>{}

interface Run{}
@SuppressWarnings("unused")
@Deprecated
public class Student extends Person<Character> implements Fly<String>,Swim<Integer,Double>,Run{

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + ", id=" + id + "]";
	}
	private String name;
	int age;
	protected double score;
	public int id;
	public static final  String SCHOOL="尚硅谷大学";
	public static   String SCHOOL2="尚硅谷大学";

	public String getName() {
		int  i;
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	protected static int getAge() {
		return 100;
	}
	public void setAge(int age) {
		System.out.println("哈哈哈，我是setAge方法");
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private static String getSchool() {
		return SCHOOL;
	}
	protected Student(String name, int age, double score, int id) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.id = id;
	}
	Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	private Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}






}

