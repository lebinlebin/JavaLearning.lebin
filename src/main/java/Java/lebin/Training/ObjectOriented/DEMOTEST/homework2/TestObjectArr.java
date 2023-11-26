package Java.lebin.Training.ObjectOriented.DEMOTEST.homework2;
/**
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 *  创建20个学生对象，学号为1到20，年级和成绩都由随机数确定，打印出3年级(state值为3）的学生信息。 
 *  
 * @author liulebin
 *
 */
public class TestObjectArr {
	
	public static void main(String[] args) {
		System.out.print("幸运组为："+((int)(Math.random()*6+1)));
		//1.声明并开辟空间
		Student[] stus = new Student[20];
		//2.循环赋值
		for (int i = 0; i < stus.length; i++) {
			stus[i]=new Student(i+1,(int)(Math.random()*3+1),(int)(Math.random()*101));
		}

		//3.使用
		for (int i = 0; i < stus.length; i++) {
			if(stus[i].getState()==3)
				System.out.println(stus[i].getInfo());
		}
	}

}
class Student{
	
	private int number,state,score;
	public String getInfo(){
		return number+"\t"+state+"\t"+score;
	}
	public Student(int number,int state,int score){
		this.number=number;
		this.state=state;
		this.score=score;
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}