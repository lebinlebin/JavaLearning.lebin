﻿##本单元目标

	1、内部类
	2、枚举
	3、注解


##一、内部类
	
###理解：
		一个类中又完整的嵌套了另一个类结构，被嵌套的类称为内部类。外面的类称为外部类,
	和内部类无关的外部类称为外部其他类。



	class A{
		String name;
		public void method(){

			for(){
				int i;
				class B{
					String anme;
	
			
				}

			}
			

		}
		
	}
	class Other{

	}

###好处：
	
	可以直接访问外部类中的所有成员，包含私有的！！！


###分类：
	定义在成员位置上:
			成员内部类（没有使用static修饰）   √
			静态内部类（使用static修饰）

	定义在局部位置上：

			局部内部类（有类名）
			匿名内部类(没有类名)             √
			
	
	


##枚举

###枚举的理解

	枚举其实就是一个类，枚举类的实例是一组限定的对象


###传统的方式创建枚举 【了解】

对比：单例类
	1、构造器私有化
	2、本类内部创建对象
	3、通过public static方法，对外暴露该对象


枚举类
	1、构造器私有化	
	2、本类内部创建一组对象，添加public static修饰符，直接暴露对象

	


###使用enum关键字定义枚举【掌握】

引入：jdk5.0出现的新特性
特点：

  		1、使用enum关键字代替class关键字
  		2、对象（常量）的创建必须放在枚举类中的第一句
  		语法：
  		对象名(实参列表),对象名(实参列表);
  
  		3、如果是无参构造，则无参构造的定义和实参列表都可以省略

###介绍枚举类的常见方法【了解】

	toString:Enum类已经重写过了，返回的是当前对象的常量名。自定义的枚举类可以继续重写该方法
	name:Enum类中的name方法返回的是当前对象的常量名（同toString），但自定义的枚举类不可以继续重写该方法
 	values:一个静态方法，用于返回指定的枚举类中的所有枚举常量
	
	valueOf:一个静态方法，将一个有效的字符串转换成枚举对象

###枚举类如何实现接口【掌握】

特点：
  	1.和普通类实现接口一样，只是允许枚举常量也有自己对抽象方法的特有实现！
  	2.enum类不能再继承其他类，因为已经隐式的直接继承了Enum类
语法：
 	enum A implements 接口1，接口2{
 	 		常量1(参数){
 	 			//抽象方法的实现
 	 
 	 		},常量2(参数){
 	 
	  			//抽象方法的实现
 	 		}
 	 		//类对抽象方法的实现
 	 
 	 }
##注解

###注解的理解
	
定义：用于修饰java中的数据（属性、方法、构造器、类等），相当于程序中的补充文字。不改变程序的逻辑，但可以被编译器或运行时解析，并做相应处理


	

###内置的三种基本注解【掌握】


###四种元注解【了解】


###自定义注解【了解】



























