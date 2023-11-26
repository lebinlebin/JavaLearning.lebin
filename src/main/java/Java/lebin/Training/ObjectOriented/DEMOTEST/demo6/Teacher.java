package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;

public class Teacher extends Person {
	
	public Teacher(String name, int age,double salary) {
		super(name, age);
		this.salary=salary;
	}
	public void teach(){
		System.out.println("好好教学，天天向上");
	}
	@Override
	public String getInfo() {
		return super.getInfo()+"\t"+salary;
	}



	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
