package Java.lebin.Training.BasicDataTypesIntCharDouble;

/*

此类用于演示 ：基本数据类型之间的转换

注意：boolean类型不参与转换

char
byte short int long
float double


一、自动类型转换

转换的过程自动发生
规则：小——>大

byte->short—>int->long ->float->double
char



二、强制类型转换
转换的过程强制发生

规则：大——>小

语法：类型 变量名=（类型）值;


特点：

1、遵循自动提升原则，表达式的结果类型 遵循操作数中最大的类型
2、强转符号只针对于最近的操作数有效，往往需要通过小括号提升优先级

3、byte、short运算时充当int类型
4、char类型只能直接存储int的常量值不是变量值

*/

class TypeConvertDemo1
{
	public static void main(String[] args)
	{
		//自动类型转换
		double i = 10;

		//System.out.println(i);

		//int j = 10;
		//short s =j;


		float f = 1.5f;


		double d = 1.5f;



		//强制类型转换

		int j = (int)1.5;

		//System.out.println(j);


		//案例1：
		//int m = 12.5*8+2.5*4;
		//System.out.println(m);
		//案例2：
		//int m2 = (int)(12.5*8+2.5*4);
		//System.out.println(m2);


		//案例3：byte、short运算时当做int类型处理

		//short s = 5;

		//byte b = 2;
		//s=s-b;
		//System.out.println(s);


		//案例4：char类型可以直接存储整型常量值，但不能直接存储整型变量，需要强转

		char c = 100;

		int  n = 100;
		char c2 = (char)n;

		System.out.println(c2);

	}
}
