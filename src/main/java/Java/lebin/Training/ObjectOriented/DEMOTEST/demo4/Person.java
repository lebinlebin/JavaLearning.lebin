package Java.lebin.Training.ObjectOriented.DEMOTEST.demo4;

public class Person {
	private String name;
	int age;
	protected double weight;
	public String hobby;
	
	private void study(){
		System.out.println("study");
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);
	}
	 void show(){
		System.out.println("show");
	}
	protected void play(){
		System.out.println("play");
	}
	public void eat(){
		System.out.println("eat");
	}
	

}
