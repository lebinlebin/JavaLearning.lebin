package Java.lebin.Training.ObjectOriented.DEMOTEST.homework;

import java.util.Scanner;

public class TestStudent {
	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		double sum = 0;
		double max = 0;
		for(int i=1;i<=10;i++){
			Student s = new Student();
			System.out.println("请输入学生的姓名和成绩");
			s.name=input.next();
			s.score=input.nextDouble();
			
			sum+=s.score;
			if(max<s.score){
				max=s.score;
			}
			
		}
		System.out.println("总成绩："+sum);
		System.out.println("最大成绩："+max);
		
	}

}
