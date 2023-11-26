package Java.lebin.Training.ObjectOriented.day7ClassAndMethod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一、已知有个排序好（升序）的数组，要求插入一个元素，最后打印该数组，顺序依然是升序
 * @author liyuting
 *
 */
public class Homework1 {
	
	
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		int[] arr = {1,3,5,7};
		
		System.out.print("请输入要插入的元素：");
		int add = input.nextInt();
		//--------------插入-----------------
		
		
		//①扩容：创建新数组，长度=arr.length+1+循环为数组赋值
		
		int[] newArr = Arrays.copyOf(arr, arr.length+1);
		
		
		//②查找要插入的索引（位置）
		int index = newArr.length-1;//默认索引在最后一个位置
		
		for (int i = 0; i < arr.length; i++) {
			if(add<arr[i]){
				index=i;
				break;
				
			}
		}
		
		//③循环后移
		
		for(int i=newArr.length-1;i>index;i--){
			newArr[i]=newArr[i-1];
		}
		
		//④将新元素插入到指定的index上
		newArr[index] = add;
		
		//⑤将newArr赋值给arr
		arr=newArr;
		
		System.out.println("插入成功");
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		
		
		
		
		
		
		
	}

}
