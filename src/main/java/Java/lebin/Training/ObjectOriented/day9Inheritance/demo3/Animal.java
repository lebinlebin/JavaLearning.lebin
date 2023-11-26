package Java.lebin.Training.ObjectOriented.day9Inheritance.demo3;

public class Animal{
	private String name;
	int age;
	protected String color;
	public double weight;
//	public Animal(){
//		System.out.println("我是父类的无参构造器");
//		
//	}
	
	public Animal(String name,int age,String color,double weight){
		this.name=name;
		this.color=color;
		this.age=age;
		this.weight=weight;
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
	public void eat(){
		System.out.println("吃");
	}
	public void run(){
		
	}
}

