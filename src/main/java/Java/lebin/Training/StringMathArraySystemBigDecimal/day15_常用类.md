##常用类

	1、包装类  √
	2、String类 ★
	3、StringBuffer和StringBuilder类  ★
	4、Math类
	5、System类
	6、Arrays类 ★
	7、BigInteger类和BigDecimal类
	8、Date日期类、Calendar日历类以及新的日期


##包装类

###理解

	
回顾：
	数据类型
		基本数据类型
		引用数据类型
			数组
			用class定义的
			用interface定义的


	
需求：
	① 获取int类型的最大值
	② 将某个整数转换成十六进制形式
	

概念：为八大基本数据类型对应的提供了引用数据类型，则这些引用数据类型称为包装类
int i=10;

Integer i2=new Integer(i);


###分类 ★

	byte————————————Byte
	short———————————Short
	int—————————————Integer
	long————————————Long
	float—————————— Float
	double——————————Double
	char————————————Character
	boolean—————————Boolean
	

###基本类型和包装类型之间的转换  ★
	jdk5.0之前：
	手动装箱：
	方式一：Integer i = new Integer(10);
	方式二：Integer i2 = Integer.valueOf(10);

	手动拆箱：
	int j = i.intValue();


	jdk5.0之后：

	自动装箱：
	Integer i = 10;

	自动拆箱：
	int j = i;



###包装类型和String类型之间的转换

包装类型————>String类型

		Integer i = 10;
		//方式1：
		String s1= i.toString();
		
		//方式2：
		String s2 = String.valueOf(i);
		
		//方式3：
		String s3 = i+"";
		
		System.out.println(s3);
		
String————>包装类
		
		//方式1：
		Integer j = new Integer(s1);
		
		//方式2：
		Integer j2 = Integer.valueOf(s2);

###基本类型和String类型之间的转换

基本类型————>String类型
		
		int i = 10;
		//方式1：
		String s=i+"";
		//方式2：
		String s2 = String.valueOf(i);
		
String————>基本类型（除了char类型）
		
		int j = Integer.parseInt(s);
		
		char c = s.charAt(0);

	
###包装类型中的常见API

	通用的方法：
	
		valueOf：将String类型或基本类型转换成对应的包装类型
		parseXX:将String类型转换成对应的基本类型
		xxValue:将包装类型转换成对应的基本类型

	
	Character类的常见方法：
		toUpperCase
		toLowerCase
		isUpperCase
		isLowerCase
		isDigit
		isLetter
		isWhiteSpace

	
	


##String类


###理解

	String类用于保存一组字符串序列的
	"john"、""都相当于字符串常量对象
	


###创建对象

	方式1：直接赋值
	
	String s  = "hello";
	
	
	方式2：通过调用构造器
	
	String s = new String("hello");




	
【面试题】两种创建对象方式的区别

方式一：先去常量池查看是否有“hello”字符序列，如果没有，则创建，如果有直接引用该地址
		s指向的是常量池的对象

方式二：需要在堆中创建对象，该对象维护了一个value属性，value指向常量池的“hello”，如果常量池中没有“hello”，则创建，再指向；如果已经有了，则直接用value指向
		s指向的是堆中的对象




###String类的常见方法
	length 获取字符个数
	charAt 获取指定索引处的字符
	toUpperCase转大写
	toLowerCase转小写
	indexOf获取字符或字符串第一次出现的索引，如果找不到返回-1
	lastIndexOf获取字符或字符串最后一次出现的索引，如果找不到返回-1
	startsWith判断是否以xx开头
	endsWith判断是否以XX结尾
	regionMatches判断是否某范围内的子串一致
	contains 判断子串是否存在，返回true|false
	compareTo 比较两个字符串大小
	equals/equalsIgnoreCase判断字符串内容是否相等
	
	substring截取子串
	replace/replaceAll替换
	trim去前后空格
	split拆分
	concat拼接字符串
	
	toCharArray转换成字符数组
	
	
	


##StringBuffer类

###String类和StringBuffer的对比

相同点：都用于保存字符串，都可以对字符串进行一些增删或其他处理的操作

不同点：
		String类用于保存字符串常量
		StringBuffer类用于保存字符串变量

###StringBuffer类创建对象
只能通过调用构造器创建对象！

	new StringBuffer（）; 构造一个初始容量为16的char数组
	new StringBuffer(string);构造一个初始容量为string.length+16的数组，并初始化值为string
	new StringBuffer(capacity)；构造一个初始容量为capacity的char数组

###StringBuffer类和String类之间的转换
一、StringBuffer——>String

		StringBuffer buffer = new StringBuffer("john");
		
		//方式一：
		String s1 = buffer.toString();
		
		//方式二：
		
		String s2 = new String(buffer);
		
二、String————>StringBuffer
		
		String s = "鸠摩智";
		//方式一：
		StringBuffer b1 = new StringBuffer(s);
		
		//方式二：
		StringBuffer b2 = new StringBuffer();
		b2.append(s);


###StringBuffer类的方法
	  增 append
	  删 delete
	  改 replace
	  查 indexOf/lastIndexOf
	  插入 insert
	  反转 reverse
	  长度 length



###StringBuffer和StringBuilder的对比
					共同点					版本		线程安全（同步）		效率
	
	StringBuffer	保存可变字符串			老		安全					较低
	
	
	StringBuilder	保存可变字符串			新		不安全				较高
	
	
	
	StringBuilder>StringBuffer>String	


##Math类
	里面包含一系列的用于数学运算的静态方法。

###常见方法：

	sqrt 求开方
	pow 求幂
	ceil 向上取整
	floor 向下取整
	round 四舍五入，返回整型
	abs 绝对值
	random随机数
	max最大值
	min最小值
	


##Arrays类
	里面包含一系列用于数组管理和操作的方法
###常见方法：
	sort(T[]) :对数组的元素进行自然排序，要求元素必须实现了Comparable
	sort(T[],Comparator):对数组的元素进行定制排序，元素本身可以不实现Comparable
	binarySearch(T[],key):对数组通过二分搜索法进行查找，如果key找到了，返回索引，否则返回负数。要求：要查找的数组必须提前排好序！

	copyOf(T[],length):复制数组的元素
	equals(T[],T[]):判断两个数组的内容是否相等
	fill(T[],key):填充数组的各元素值为key
	toString():将数组各元素进行拼接，返回String



##System类

###常见方法

	arrayCopy 复制数组元素，一般使用Arrays.copyOf代替
	exit：退出程序
	currentTimeMillens:获取当前时间距离1970-1-1的毫秒数。
	gc:运行垃圾回收器

##BigDecimal和BigInteger类

###常见方法

	add 加法
	substract减法
	multiply乘法
	divide除法，注意：可以添加参数2设置四舍五入模式
	

##日期类

###第一代日期

	java.util.Date类	
	java.text.SimpleDateFormat类


###第二代日期
	java.util.Calendar类


###第三代日期(jdk8新特性)
	LocalDate|LocalTime|LocalDateTime类：类似于Calendar
	Instant：类似于Date
	DateTimeFormatter：类似于SimpleDateFormat
