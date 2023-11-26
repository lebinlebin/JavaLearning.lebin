package Java.lebin.Training.Array;

/*

此类用于演示数组的基本使用：最值、查找、排序

*/
import java.util.Scanner;

//1.求最值
class ArrayUtilsMax
{
    public static void main(String[] args)
    {

        //1.声明并初始化
        int[] arr = new int[]{5,4,3,6,7,1};

        //2.使用：求最大值

        //①定义一个max，初始化为第一个元素
        int max = arr[0];
        int maxIndex = 0;//记录最大值的下标
        //②车轮战术，进行和max的pk

        for(int i=1;i<arr.length;i++){
            if(arr[i]>=max){
                max=arr[i];
                maxIndex = i;

            }

        }

        //③获取max
        System.out.println("最大值："+max+"，下标："+maxIndex);

    }
}
/*
 有一个数列：白眉鹰王、金毛狮王、紫衫龙王、青仪斧王
	猜数游戏：从键盘中任意输入一个名称，判断数列中是否包含此名称  【查找】


*/
//2.查找
class ArrayUtilsFindValue
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //1.声明并初始化
        String[] names = {"白眉鹰王","青易斧王","金毛狮王","紫衫龙王"};

        //2.查找

        System.out.println("请输入你要查找的名:");
        String search = input.next();

        //----------------核心的查找------------

		/*
			查找：线性查找、二分查找
			线性查找：依次将数组中的元素提取出来和要查找进行匹配
			二分查找：要求待查找的数组已经排好序，查找效率较高


		*/
        boolean flag = false;
        for(int i=0;i<names.length;i++){
            if(names[i].equals(search)){//找到了
                System.out.println("找到了，下标是："+i);
                flag = true;
                break;
            }

        }
        if(!flag){

            System.out.println("没找到");

        }
    }


}
//3.冒泡排序
class ArrayUtilsSort
{
    public static void main(String[] args)
    {

        int[] arr = {2,3,4,1,5};
        //排序
		/*
			i	j
			0	0		arr[0] vs arr[1]
				1		arr[1] vs arr[2]
				2		arr[2] vs arr[3]
				3		arr[3] vs arr[4]

		*/

        for(int i=0;i<arr.length-1;i++){//外层循环。 i:控制轮数
            //循环操作：每一轮发生的事情
            for(int j=0;j<arr.length-1-i;j++){//内层循环。j:控制比较的次数
                //循环操作：每一次发生的事情（比较）

                if(arr[j]<arr[j+1]){
                    //交换两个相邻元素
                    int temp = arr[j];
                    arr[j]  = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }

        //打印
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");

        }
        System.out.println();


    }

}

/*
   小明要去买一部手机，他询问了4家店的价格，分别是2800元，2900元，2750元和3100元，显示输出最低价
*/

class ArrayFindMinPrice
{
    public static void main(String[] args)
    {

        //1.声明并初始化
        double[] prices = {2800,2900,2750,3100};

        //2.求最值

        double max ,min;
        max=min= prices[0];
        int maxIndex,minIndex;
        maxIndex=minIndex=0;

        for(int i=1;i<prices.length;i++){
            if(max<prices[i]){
                max=prices[i];
                maxIndex = i;
            }
            if(min>prices[i]){
                min=prices[i];
                minIndex = i;
            }

        }
        System.out.println(max+"的下标是："+maxIndex);
        System.out.println(min+"的下标是："+minIndex);





    }

}