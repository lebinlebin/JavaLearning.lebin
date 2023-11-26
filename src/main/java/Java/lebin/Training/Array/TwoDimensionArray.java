package Java.lebin.Training.Array;
/*
此类用于演示二维数组的动态初始化：不固定列数

*/

class TwoDimensionArray
{
	public static void main(String[] args) {
		//1.声明

		int[][] arr;

		//2.开辟空间
		arr = new int[3][];

		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		//3.赋值

		for(int i=0;i<arr.length;i++){
			//①为每一个一维数组开辟空间 ★
			arr[i]=new int[i+1];

			//②为每一个元素赋值
			for(int j=0;j<arr[i].length;j++){
				arr[i][j] = i+1;

			}

		}



		//4.使用

		for(int i=0;i<arr.length;i++){
			int sum=0;
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
				sum+=arr[i][j];
			}
			System.out.println();
			System.out.println("和："+sum);
		}




	}
}