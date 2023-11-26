package Java.lebin.Training.Array;

/*

此类用于演示二维数组的动态初始化：列数固定

步骤：
1、声明
2、开辟空间
3、赋值
4、使用

前两步可以合二为一

*/
import java.util.Scanner;

class TwoDimensionArray1
{
	public static void main(String[] args)
	{
		//1.声明
		int[][] nums;
		//或
		//int[] nums1[];

		//或
		//int nums2[][];


		//2.开辟空间（指定长度）
		/*
			第一个长度：二维数组的长度&里面保存的一维数组的个数&行数
			第二个长度：每个一维数组的长度&列数

		*/
		nums = new int[3][2];


		//3.赋值
		nums[1][1] = 100;



		//4.使用
		System.out.println(nums);
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[1][1]);
	}
}
//测试二维数组的动态初始化：如果值有规律，可以搭配for循环
/*
场景：定义二维数组，用于保存三个班，每个班五名同学成绩，打印出来

并求出每个班级平均分、以及所有班级平均分
*/
class TwoDimensionArray1_2
{
	public static void main(String[] args)
	{
		Scanner input  = new Scanner(System.in);
		//1.声明并开辟空间

		double[][] scores = new double[3][2];
		//2.赋值
		for(int i=0;i<scores.length;i++){//外层循环控制行数，i：行下标
			System.out.println("第"+(i+1)+"个班的成绩：");
			for(int j=0;j<scores[i].length;j++){//内层循环控制列数,j:列下标
				System.out.print("请输入第"+(j+1)+"名童鞋成绩：");
				scores[i][j]=input.nextDouble();
			}
		}
		//3.使用
		//①打印
		System.out.println("成绩如下：");
		for(int i=0;i<scores.length;i++){

			for(int j=0;j<scores[i].length;j++){

				System.out.print(scores[i][j]+"\t");
			}
			System.out.println();
		}
		//②求平均值
		double result = 0;

		for(int i=0;i<scores.length;i++){//i:班级

			double sum = 0;
			for(int j=0;j<scores[i].length;j++){//j:同学
				sum+=scores[i][j];

			}
			System.out.println("第"+(i+1)+"个班的平均分："+sum/scores[i].length);

			result+=sum;

		}
		System.out.println("总平均分："+result/(scores.length*scores[0].length));

	}

}