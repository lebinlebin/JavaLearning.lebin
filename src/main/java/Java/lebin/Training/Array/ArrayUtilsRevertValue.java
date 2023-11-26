package Java.lebin.Training.Array;

/*


此类用于演示数组的复杂使用：反转
随机生成五个数，并将其反转打印

1 3 5 2 4     1   length/2-1
4 2 5 3 1

12345678      3   length/2-1
87654321


交换两个数

arr[0]——arr[length-1]     length-1-i
arr[1]——arr[length-2]     length-1
...
arr[length/2-1]




*/

//方式一：找规律
class ArrayUtilsRevert
{
	public static void main(String[] args)
	{
		//1.声明并开辟空间
		int[] arr = new int[5];

		//2.赋值
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100+1);
		}

		System.out.println("反转前");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();
		//3.使用

		for(int i=0;i<arr.length/2;i++){
			//交换两个数   i vs arr.length-1-i
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;

		}
		System.out.println("反转后");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();





	}
}

//方式二：数组的赋值
class ArrayUtilsReVert
{
	public static void main(String[] args)
	{
		//1.声明并开辟空间
		int[] arr = new int[5];

		//2.赋值
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100+1);
		}

		System.out.println("反转前");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();
		//3.使用

		//①创建一个新数组，长度=arr.length
		int[] newArr = new int[arr.length];
		//②逆序赋值
		/*
		i
		0	arr.length-1
		1	arr.length-2

		*/
		for(int i=0,j=arr.length-1;i<arr.length;i++,j--){
			newArr[j]=arr[i];

		}
		//③将新数组的地址赋值给arr
		arr=newArr;

		System.out.println("反转后");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");

		}
		System.out.println();



	}

}