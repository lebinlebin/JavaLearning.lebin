package Java.lebin.Training.Array;

/*
此类用于演示二维数组的静态初始化

使用步骤：

1、声明并初始化
	数据类型[][] 数组名 = {{值，值},{值，值，值},{值}};
	或
	数据类型[][] 数组名 = new 数据类型[][]{{值，值},{值，值，值},{值}};
2、使用
*/



class TwoDimensionArrayInitial
{
	public static void main(String[] args)
	{
		//1.声明并初始化
		int[][] nums = new int[][]{{1,8},{2,4,7},{3,5,6,9}};

		//2.使用
		for(int i=0;i<nums.length;i++){

			int max = nums[i][0];//保存每一行的最大值
			for(int j=0;j<nums[i].length;j++){
				System.out.print(nums[i][j]+"\t");
				if(nums[i][j]>max)
					max = nums[i][j];

			}
			System.out.println("\n最大值："+max);

		}
	}
}
