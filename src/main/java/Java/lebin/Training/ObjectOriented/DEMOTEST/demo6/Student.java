package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;

public class Student extends Person {
	@Override
	public String getInfo(){
		return super.getInfo()+"\t"+score;
	}
	
	public Student(String name, int age,double score) {
		super(name, age);
		this.score=score;
	}

	private double score;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public void study(){
		System.out.println("好好学习，天天向上");
	}

}
