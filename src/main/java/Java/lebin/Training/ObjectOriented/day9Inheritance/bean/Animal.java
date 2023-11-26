package Java.lebin.Training.ObjectOriented.day9Inheritance.bean;

public class Animal {

	
	private String name;
	 String color;
	protected int age;
	public double weight;
	
	public void show(){
		System.out.println(name+"\t"+color+"\t"+age+"\t"+weight);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	
	
	
}
