package Java.lebin.Training.FileSys.ioSerializable;

import java.io.Serializable;
class Computer implements Serializable{
	String name;
	public Computer(String name) {
		super();
		this.name = name;
	}
}

class Student extends Person{
	public Student(String name, int age, double weight) {
		super(name, age, weight);
	}
}
public class Person implements Serializable{
	
	/**
	 * 具体的序列化过程是这样的：序列化操作的时候系统会把当前类的serialVersionUID写入到序列化文件中，当反序列化时系统会去检测文件中的serialVersionUID，
	 * 判断它是否与当前类的serialVersionUID一致，如果一致就说明序列化类的版本与当前类版本是一样的，可以反序列化成功，否则失败。
	 */
	private static final long serialVersionUID = -95883481082677658L;
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private static double weight;
	
	Computer com;
	
	private transient String nation;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Person(String name, int age, double weight, String nation,Computer com) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.nation = nation;
		this.com=com;
	}
	public Person(String name, int age, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
//	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", nation=" + nation + "]";
	}
	

	
}
