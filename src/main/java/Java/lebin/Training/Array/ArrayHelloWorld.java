package Java.lebin.Training.Array;

/*
此类用于演示数组的声明和使用步骤 ★
应用场景：声明时并不知道要赋的值是什么
*/


class ArrayDemo1 {


    public static void main(String[] args)
    {


        //步骤1：声明(仅仅告诉jvm要开辟房间保存多个元素)
        //语法：数据类型[] 数组名;或 数据类型 数组名[];
        int[] arr;

        //步骤2：开辟空间(在堆中开辟指定长度的空间,并且系统自动为每个成员赋予初始值)

        //语法：数组名 = new 数据类型[长度];

		/*
			int 0
			double 0.0
			char \u0000
			boolean false
			String null

		*/
        arr = new int[5];



        Double[] WeightRange = new Double[2];
        Double a =  WeightRange[0];
        System.out.println(">>>>>>>>:   "+WeightRange.length);
        System.out.println(a);
        String dim1Attr1 = "brandall";
        String userTopKey = dim1Attr1.substring(0, dim1Attr1.length() - 1);
        System.out.println("userTopKey>>>>>>>>>>>>>>>      "+userTopKey);


        //可以合二为一
        int[] arr2 = new int[5];

        //步骤3：手动赋值
        arr[0] = 100;//为数组中的第一个成员赋值
        arr[1] = 300;//为数组中的第二个成员赋值
        arr[2] = 900;//为数组中的第三个成员赋值


        //arr[5] = 10000; ArrayIndexOutOfBoundsException

        //arr={1,2,3};
        //步骤4：使用
//        System.out.println(arr);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[1]);

    }
}

//此类用于演示数组的动态初始化——赋的值有规律
class ArrayDemo
{


    public static void main(String[] args)
    {
        //1.声明并开辟空间
        int[]  arr = new int[5];


        //2.赋值
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random())*100+1;

        }
        //3.使用
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);

        }


    }

}