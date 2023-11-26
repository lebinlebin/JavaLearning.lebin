package Java.lebin.Training.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestException1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		/**
		 * Exception in thread "main" java.util.InputMismatchException
		 */
		int  i=input.nextInt();
		System.out.println(i);


		/**
		 * Exception in thread "main" java.io.FileNotFoundException: src\student.txt (No such file or directory)
		 * 	public static void main(String[] args) throws FileNotFoundException {}
		 */
		FileInputStream fis = new FileInputStream("src\\student.txt");
	}

}
