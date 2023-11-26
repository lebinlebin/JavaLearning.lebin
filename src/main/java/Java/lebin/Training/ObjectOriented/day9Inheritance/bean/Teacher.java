package Java.lebin.Training.ObjectOriented.day9Inheritance.bean;

public class Teacher {
	private String name;
	private Computer computer;
	
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setComputer(Computer c){
		computer=c;
	}
	
	public Computer getComputer(){
		return computer;
	}
	
	public String getInfo(){
		return name+"\t"+computer.show();
	}

}
