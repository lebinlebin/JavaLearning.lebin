##本单元目标

	1、异常的概念
	2、异常体系图★
	3、常见的异常
	4、异常处理的概念
	5、异常处理的分类 ★
	6、自定义异常【了解】
	7、throw和throws的对比【面试题】


##异常的概念

##异常的体系图

##常见的运行异常介绍
	NullPointerException 空指针异常
		当试图使用null对象的属性或方法时
	ArrayIndexOutOfBoundsException 数组下标越界异常
		当试图使用数组的索引超过范围：0——length-1
	ClassCastException 类型转换异常
		当试图将不是该类型的实例强转成该类型

	ArithmeticException 数学运算异常
		除数为0时
	NumberFormatException 数字格式不正确
		当试图将字符串转换成数值时，如果该字符串不是有效的数值格式




##异常处理的概念

	处理程序中发生的不正常现象，称为异常处理

##异常处理的分类 ★

	方式一：自己处理
	try{

		需要检测的代码块
	}catch(异常类型 名){

		处理的语句
	}


	方式二：抛给他人处理
	语法：throws




	
	

	

