package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * (1)北京奥运是什么时间开幕的？
   A.2008-08-08  B. 2008-08-01 
C.2008-10-01 D. 2008-07-08
输入选择的答案（A、B、C、D）：A
(2)下列哪个国家不属于亚洲？
   A.沙特  B.印度 C.巴西  D.越南
输入选择的答案（A、B、C、D）：

 * @author liulebin
 *
 */
public class TestHomework3 {
	
	public static void main(String[] args) throws IOException {
		
		char[] rightAnswers={'A','C','D','D'};
		Scanner input  = new Scanner(System.in);
		//步骤1
		BufferedReader reader  = new BufferedReader(new FileReader("src\\questions.txt"));
				
		//步骤2
		String line ;
		int i=0;//题目的索引
		double result = 0;//成绩
		while((line=reader.readLine())!=null){
			if(line.contains("*")){
				//接受键盘输入
				System.out.print("输入选择的答案（A、B、C、D）：");
				char key = input.next().toUpperCase().charAt(0);
				if(key==rightAnswers[i++])
					result+=100.0/rightAnswers.length;
				
				continue;
			}
			System.out.println(line);
		}
		
		System.out.println("您的最终成绩为："+result);
		 
		
	}

}
