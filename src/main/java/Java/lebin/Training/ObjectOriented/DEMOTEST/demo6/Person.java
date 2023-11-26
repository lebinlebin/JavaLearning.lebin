package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;

public class Person {
	
	private String name;
	private int age;
	public String getInfo(){
		return name+"\t"+age;
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
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void work(){
		System.out.println("好好工作，不许偷懒哈哈");
	}

}
