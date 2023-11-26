package Java.lebin.Training.Array;/*
/*
此类用于演示数组的静态初始化

应用场景：声明时便知道要赋的值是谁
*/


class ArraySum
{
    public static void main(String[] args)
    {
        //步骤1：声明并初始化
        //语法：数据类型[] 数组名 = new 数据类型[]{值，值，值};
        //或    数据类型[] 数组名 = {值，值，值};

        int[] arr = {3,4,5,6,100};
        //int[] arr2 = new int[] {3,4,5,6,100};


        //步骤2：使用

        //1.打印
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //2.求和
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
