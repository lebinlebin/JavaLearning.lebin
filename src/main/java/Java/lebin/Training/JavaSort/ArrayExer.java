package Java.lebin.Training.JavaSort;

//面试题目：创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
public class ArrayExer {
	public static void main(String[] args) {
		//方式一：
//		int[] arr = new int[6];
//		for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
//			arr[i] = (int) (Math.random() * 30) + 1;
//
//			boolean flag = false;
//			while (true) {
//				for (int j = 0; j < i; j++) {
//					if (arr[i] == arr[j]) {
//						flag = true;
//						break;
//					}
//				}
//				if (flag) {
//					arr[i] = (int) (Math.random() * 30) + 1;
//					flag = false;
//					continue;
//				}
//				break;
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		//方式二：
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
			arr[i] = (int) (Math.random() * 30) + 1;
			
				for (int j = 0; j < i; j++) {
					if (arr[i] == arr[j]) {
						i--;
						break;
					}
				}
			}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
