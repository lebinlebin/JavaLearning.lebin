package Java.lebin.Training.Array;/*
/*
此类用于演示数组的高级使用：增加和插入

*/
import java.util.Scanner;
//演示增加
class ArrayUtilsAddElement
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//声明并初始化
		int[] arr = {2,3,1,4,6};

		//打印
		System.out.println("原始数组的元素如下");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();

		do{
			//-----------------增加---------------------
			System.out.print("请输入要添加的元素：");
			int add = input.nextInt();

			//----------------具体的添加业务----------
			//①新建一个数组，长度=arr.length+1
			int[] newArr = new int[arr.length+1];

			//②依次为新数组的元素赋值
			for(int i=0;i<arr.length;i++){
				newArr[i] = arr[i];
			}
			//③将add赋值到新数组的空位上
			newArr[newArr.length-1] = add;

			//④将newArr的地址赋值给arr
			arr = newArr;
			System.out.println("添加成功！");
			System.out.println("是否继续添加？Y/N");
			char key = input.next().toUpperCase().charAt(0);//将字符串转换成大写，然后再提取第一个字符
			if(key=='N')
				break;

		}while(true);

		//打印
		System.out.println("添加后的元素如下");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();






	}
}
//演示插入
class ArrayUtilsAddElement2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//声明并初始化
		int[] arr = {2,3,1,4,6};

		//打印
		System.out.println("原始数组的元素如下");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();
		do{

			//----------------------插入--------------------

			System.out.print("请输入要插入的元素：");
			int add = input.nextInt();

			System.out.print("请输入要插入的位置：");
			int index = input.nextInt();

			//----------------------具体的插入业务-----------

			//①创建新数组，长度=arr.length+1
			int[] newArr = new int[arr.length+1];

			//②循环赋值
			for(int i=0;i<arr.length;i++){
				newArr[i] = arr[i];

			}

			//③循环后移
			for(int i=newArr.length-1;i>index;i--){
				newArr[i]=newArr[i-1];

			}

			//④将新元素赋值到index位置上
			newArr[index] = add;

			//⑤将newArr的地址赋值给arr
			arr = newArr;
			System.out.println("插入成功！");
			System.out.println("是否继续添加？Y/N");
			char key = input.next().toUpperCase().charAt(0);//将字符串转换成大写，然后再提取第一个字符
			if(key=='N')
				break;

		}while(true);
		System.out.println("插入后的元素如下：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();



	}

}