package Java.lebin.Training.Array;

//求一个班级10名同学的平均分

import java.util.Scanner;
class ArrayGetTheAveScore
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //1.声明并开辟空间
        double[] scores = new double[10];

        //2.手动赋值
        for(int i=0;i<scores.length;i++){
            System.out.print("请输入第"+(i+1)+"名同学的成绩：");
            scores[i] = input.nextDouble();

        }
        //3.使用
        //求和
        double sum = 0;//定义sum初始化为0
        for(int i=0;i<scores.length;i++){

            sum+=scores[i];//sum累加
        }

        System.out.println("平均分："+sum/scores.length);


    }
}
/*
练习一
创建一个char类型的26个元素的数组，分别 放置'A'-'Z‘。
使用for循环访问所有元素并打印出来。
提示：char类型数据运算 'A'+1 -> 'B'，'0'+1 -> '1‘

*/

class ArrayStoreA2Z
{
    public static void main(String[] args)
    {

        //1.声明并开辟长度
        char[] chs = new char[26];

        //2.手动赋值
        for(int i=0;i<chs.length;i++){
            chs[i] = (char)('A'+i);
        }

        //3.打印
        for(int i=0;i<chs.length;i++){
            System.out.println(chs[i]);
        }
    }

}
/*	练习二
//创建一个char类型的36个元素的数组，前26个元素放置'A'-'Z‘,   后10个元素放置'0'-'9‘。
//使用for循环访问所有元素并打印出来。
*/
class ArrayStoreA2Zand0_9
{
    public static void main(String[] args)
    {

        //1.声明并开辟空间
        char[] chs = new char[36];
        //2.赋值
        //前26个
        for(int i=0;i<26;i++){
            chs[i] = (char)('A'+i);
        }
        //后10个
		/*
		i	字符值
		26	'0'   48
		27	'1'
		28  '2'
		...

		*/
        for(int i=26;i<chs.length;i++){
            chs[i] =(char)('0'+(i-26));
        }

        //3.打印
        for(int i=0;i<chs.length;i++){
            System.out.println(chs[i]);
        }
    }
}