package Java.lebin.Training.ObjectOriented.day9Inheritance.exec2;

public class TestPerson {
	
	public static void main(String[] args) {
		Student s = new Student("john",12);
		System.out.println(s.getInfo());
		
	}

}
class Student extends Person{

	public Student(String name, int age) {
		super(name, age);
	}
	
}
class Person{
	
	private String name;
	private int age;
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
	public String getInfo(){
		return name+"\t"+age;
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
}