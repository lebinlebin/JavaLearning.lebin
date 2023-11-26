package Java.lebin.Training.Array;

/*
此类用于演示二维数组的动态初始化：不固定列数

*/

class TwoDimensionArray2
{
	public static void main(String[] args)
	{
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


/*

1
1 1
1 2 1
1 3 3  1
1 4 6  4  1
1 5 10 10 5 1

1.第一列和最后一列 是1
2.nums[i][j]= nums[i-1][j]+nums[i-1][j-1]


*/

class Exec1
{
	public static void main(String[] args)
	{

		//1.声明并开辟空间
		int[][] nums = new int[10][];

		//2.赋值

		for(int i=0;i<nums.length;i++){//i:每一行
			//①为每个一维数组开辟空间
			nums[i] = new int[i+1];

			//②循环为每一个一维数组的元素赋值

			for(int j=0;j<nums[i].length;j++){
				if(j==0||j==nums[i].length-1)
					nums[i][j]=1;
				else
					nums[i][j] = nums[i-1][j]+nums[i-1][j-1];
			}

		}

		//3.打印
		for(int i=0;i<nums.length;i++){//i:每一行

			for(int j=0;j<nums[i].length;j++){
				System.out.print(nums[i][j]+"\t");
			}
			System.out.println();
		}

	}
}