package Java.lebin.Training.ObjectOriented.day7ClassAndMethod;

import java.util.Arrays;

public class Review {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4, 5 };

//		// ①创建新数组，长度=arr.length+1
//		int[] newArr = new int[arr.length];
//
//		// ②循环赋值
//		for (int i = 0; i < arr.length; i++) {
//
//			newArr[i] = arr[i];
//		}
		
		int[] newArr =Arrays.copyOf(arr, arr.length);
		
		
		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}
		
		
		

	}

}
