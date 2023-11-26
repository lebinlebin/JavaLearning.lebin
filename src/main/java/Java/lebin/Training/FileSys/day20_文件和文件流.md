##本单元目标
	1、IO流的引入和概念
	2、IO流的体系图 ★

	3、基础流（节点流）  ★
		FileInputStream
		FileOutputStream
		FileReader
		FileWriter
	4、包装流（处理流）
		BufferedInputStream
		BufferedOutputStream
		BufferedReader
		BufferedWriter

		ObjectInputStream
		ObjectOutputStream

	5、其他小流【了解】

		打印流
		标准输入输出流
		等
	6、File类的特点和使用


##IO流的引入和概念

将数据持久化：
	文件
	数据库
	网络


###概念

	IO：I/O (Input/Output) 输入输出
	IO流：数据就水流一样，可以实现从一个节点流向另外一个节点
	其中一个节点是程序
	另外一个节点可以是文件或网络或内存等
	
	也就是说IO流就是指一种用于传输数据的技术


###分类

按流向不同分类：

	输入流：从其他节点流向程序 （节点可以是：文件或网络或内存或键盘）
	输出流：从程序流向其他节点（节点可以是：文件或网络或内存或显示器）


按传输单位不同分类：

	字节流：按一个字节一个字节的传输，效率较低而且容易出现问题乱码，但可以读写任意类型的数据


	字符流：按一个字符一个字符的传输，效率较高而且底层使用默认的字符编码格式进行了包装，所以不太容易出现中文乱码问题，但只能读写纯文本的数据


按功能不同分类：

	节点流（基础流）：用于读写数据

	处理流（包装流）：可以在节点流的基础上增强一些其他功能，比如提高效率等



##文件流的体系图

	字节输入流InputStream
		FileInputStream 文件字节输入流：数据从文件读到程序
		BufferedInputStream 缓冲字节输入流：为了提高效率
		ObjectInputStream 对象字节输入流：为了反序列化
		
	
	
	字节输出流
		FileOutputStream 文件字节输处流：数据从程序写入到文件
		BufferedOutputStream 缓冲字节输出流：为了提高效率
		ObjectOutputStream 对象字节输出流：为了序列化
	
	
	字符输入流Reader 
		FileReader 文件字符读取流：数据从文件读取到程序
		BufferedReader 缓冲字符读取流：为了提高效率
	
	
	字符输出流Writer
	
		FileWriter 文件字符写入流：数据从程序写入到文件
		BufferedWriter 缓冲字符写入流：为了提高效率



##节点流

###FileInputStream
使用步骤：

1、创建流对象打开一个连接指向一个具体的文件
	
	FileInputStream fis = new FileInputStream("文件全路径名");
	
	注意：该文件必须存在！如果不存在，则报java.io.FileNotFoundException

2、调用读取方法
	
	byte[] b = new byte[容量];
	
	int len;
	while((len=fis.read(b))!=-1){
		syso(new String(b,0,len));
	}


3、关闭

	fis.close();



###FileOutputStream
使用步骤：

1、创建流对象打开一个连接指向一个具体的文件

	FileOutputStream fis = new FileOutputStream("文件全路径名");//覆盖
	FileOutputStream fis = new FileOutputStream("文件全路径名",true);//追加
	
	注意：如果文件不存在，则创建并指向；如果文件存在，则直接指向



2、调用写入方法

	fos.write(int i);//写入单个字节
	fos.write(byte[]);//写入字节数组
	fos.write(byte[],off,len);//写入字节数组的指定部分
	

3、关闭

	fos.close();


###FileReader

使用步骤：

1、创建流对象打开一个连接指向一个具体的文件
	
	FileReader reader = new FileReader("文件全路径名");
	
	注意：该文件必须存在！如果不存在，则报java.io.FileNotFoundException

2、调用读取方法
	
	char[] b = new char[容量];
	
	int len;
	while((len=reader.read(b))!=-1){
		syso(new String(b,0,len));
	}


3、关闭

	reader.close();


###FileWriter

使用步骤：

1、创建流对象打开一个连接指向一个具体的文件

	FileWriter writer = new FileWriter("文件全路径名");//覆盖
	FileWriter writer = new FileWriter("文件全路径名",true);//追加
	
	注意：如果文件不存在，则创建并指向；如果文件存在，则直接指向



2、调用写入方法

	writer.write(int i);//写入单个字符
	writer.write(char[]);//写入字符数组
	writer.write(char[],off,len);//写入字符数组的指定部分
	writer.write(string);//写入整个字符串
	writer.write(string,off,len);//写入字符串的指定部分
	

3、关闭

	writer.close();


##缓冲流


功能：提高效率，同时还多了一些便利的方法

分类：

	BufferedInputStream
	BufferedOutputStream
	BufferedReader
	BufferedWriter

使用步骤：
	同节点流！只是创建对象时，需要指定的不是文件路径而是被包装的流对象



示例：

		步骤1.创建流对象
		BufferedInputStream bis =
				new BufferedInputStream(new FileInputStream("E:\\beauty\\2.jpg"));
		BufferedOutputStream bos =
				new BufferedOutputStream(new FileOutputStream("copy.jpg"));
		
		
		步骤2.读写
		
		int len;
		byte[] b=new byte[1024];
		while((len=bis.read(b))!=-1){
			bos.write(b, 0, len);
		}
		
		步骤3.关闭
		bos.close();
		bis.close();


注意：

	 BufferedReader类多了readLine方法
	 BufferedWriter类多了newLine方法

##其他小流
###标准输入输出流

		 						类型				默认设备
	  System.in 标准输入		InputStream		键盘
	  
	  System.out 标准输出	PrintStream		显示器
  
  
  可以重定向标准输入输出设备:

	  System.setIn(InputStream);
	
	  System.setOut(PrintStream);

###转换流

	分类：
  
	  InputStreamReader:Reader的子类，实现InputStream——>Reader
	  
	  OutputStreamWriter:Writer的子类，实现OutputStream——>Writer
 	好处：

  	1.当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转换成字符流
   2.可以在使用时指定编码格式

###打印流
	 特点：
	 * 	1、只有输出没有输入
	 * 	2、打印流提供了一系列非常方便的打印方法，比如
	 * 	println、print、printf
	 * 
	 *  3、除了调用构造器时，会有编译异常（FileNotFoundException），在调用打印方法时，都不需要捕获异常
	 *  4、打印流可以通过传入构造器一个boolean类型的值（true）实现自动刷新功能
	 *  5、打印流可以指定字符格式
##Properties类的特点和使用

###说明

Properties属于集合中Hashtable的子类，所以遵循Hashtable的特点。

特点：

	1、保存键值对，键不能重复，值可以重复
	2、不允许null键null值



功能：
用于读写配置文件

配置文件的特点：

	① 写法：
	键=值 
	键=值
	②键和值的默认类型都是String


###常见方法 【掌握】

	setProperty(String key,String value);
	getProperty(String key):根据键获取值
	load(InputStream|Reader )加载配置文件的键值对到Properties对象
	store(OutputStream|Writer)：将Properties中的键值对存储到指定输出流中
	list(PrintStream):将Properties中的键值对列出到指定设备	



##File类的特点和使用

###说明

	File类代表了一组对象，也就是用于描述磁盘中的文件或目录的对象
	
	功能：用于操作文件或目录的，比如创建、删除、重命名、获取信息等，但不能读写文件的内容（文件流）



###常见方法

	exists判断文件或目录是否存在
	delete 删除文件或 空目录
	createNewFile 创建文件
	mkdir创建一层目录
	mkdirs创建多层目录
	isHidden 判断是否为隐藏
	isDirectory判断是否是目录
	isFile判断是否为文件
	getName获取文件或目录名
	length获取文件大小
	getParent获取父目录，返回String
	getParentFile获取父目录，返回File
	getAbsolutePath获取绝对路径
	toString返回File的字符串形式
	list获取子级,返回String[]
	listFiles获取子级，返回File[]
	

