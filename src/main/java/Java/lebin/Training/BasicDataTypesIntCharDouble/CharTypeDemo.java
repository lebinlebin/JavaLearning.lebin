package Java.lebin.Training.BasicDataTypesIntCharDouble;

/**
 此类用于演示字符型的特点和使用


 补充：
 为了将字符存储到计算机中，
 需要引入一个字符编码集，将字符先通过字符编码集解析成对应的二进制，然后进行存储

 常见的字符编码：

 ASCII码：只能包含128个字符
 unicode码：可以包含世界上所有的字符，但固定长度的编码表，所以有点浪费空间
 utf-8:可以包含世界上所有的字符，可变长度的编码表
 一个字母占1个字节
 一个汉字占3个字节

 一、分类
 意义		所占空间	使用的字符编码
 char	字符型		2个字节		unicode


 二、特点
 1、底层存储是以二进制形式（整数形式）
 2、char类型的常量值可以是：
 字符
 整型
 十六进制的码值


 */


class CharTypeDemo
{
	public static void main(String[] args)
	{
		char c = 'a';


		System.out.println(c);

		char c2 = 100;

		System.out.println(c2);


		char c3 = '\u0009';//unicode码值

		System.out.println(c3);


	}
}
