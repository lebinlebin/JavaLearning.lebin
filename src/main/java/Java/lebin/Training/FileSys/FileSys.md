##IO流相关概念和体系图
### 一、IO流分类
1.按传输单位不同       
*	字节流：按字节传输。当读写的是二进制文件时        
*   字符流：按字符传输。当读写的是纯文本文件时           

2.按流向不同
* 输入流：节点——>程序，读取
* 输出流：程序——>节点，写入

3.按角色不同        
*	节点流：读写
*	处理流：套接在节点流基础上，实现更强大的功能

### 二、体系图
InputStream
*	FileInputStream
*	BufferedInputStream
*	ObjectInputStream

OutputStream
*	FileOutputStream
*	BufferedOutputStream
*	ObjectOutputStream

Reader
*	FileReader
*	BufferedReader

Writer
*	FileWriter
*	BufferedWriter


## 节点流

### 一、FileInputStream
使用步骤：
1、创建流对象          
* FileInputStream fis = new FileInputStream(String pathName);
* FileInputStream fis = new FileInputStream(File pathName);

2、调用读取方法         
    int len;        
    byte[] b = new byte[长度];          
    while((len=fis.read(b))!=-1){          
    	System.out.print(new String(b,0,len));          
    }       
3、关闭流
fis.close();


### 二、FileOutputStream       
1.创建流对象           
FileOutputStream fos = new FileOutputStream(String pathName);
FileOutputStream fos = new FileOutputStream(File pathName);
FileOutputStream fos = new FileOutputStream(String pathName,true);
FileOutputStream fos = new FileOutputStream(File pathName,true);

2、写入           
fos.write(int);//写入单个字节   
fos.write(byte[]);//写入整个byte[]          
fos.write(byte[],off,len);//写入byte[]的指定部分           

3、关闭   
fos.close();            


三、FileReader        
1、创建流对象           
FileReader fis = new FileReader(String pathName);        
FileReader fis = new FileReader(File pathName);               
        
2、调用读取方法       
int len;           
char[] b = new char[长度];        
while((len=fis.read(b))!=-1){          
	System.out.print(new String(b,0,len));           
}         
3、关闭流       
fis.close();       

四、FileWriter
1.创建流对象
FileWriter fos = new FileWriter(String pathName);
FileWriter fos = new FileWriter(File pathName);
FileWriter fos = new FileWriter(String pathName,true);
FileWriter fos = new FileWriter(File pathName,true);

2、写入
fos.write(int);//写入单个字符
fos.write(char[]);//写入整个char[]
fos.write(char[],off,len);//写入char[]的指定部分
fos.write(String);//写入整个的String
fos.write(String,off,len);//写入String的指定部分

3、关闭
fos.close();

====================================
## 处理流
一、缓冲流
功能：提高效率
分类：
	BufferedInputStream
	BufferedOutputStream
	BufferedWriter
		newLine方法
	BufferedReader
		readLine方法
使用：
	1、必须套接在节点流基础上
	2、关闭时，只需要关闭最外层流



二、对象流
功能：实现序列化和反序列化
分类：
	ObjectInputStream
	ObjectOutputStream

使用：
	1、必须套接在节点流基础上
	2、关闭时，只需要关闭最外层流
特点：★
	1、序列化和反序列化的概念
	序列化：将内存中的对象持久化到本地或网络
	反序列化：将持久化到本地或网络中的对象还原到内存中

	实现序列化的类和方法：ObjectOutputStream使用的方法主要是writeObject
	实现反序列化的类和方法：ObjectInputStream使用的方法主要是readObject

	2、要求实现序列化的对象必须可序列化。
	也就是该对象的类型 必须实现Serializable或Externalizable接口之一

	3、读写顺序要一致
	4、序列化的对象的成员也默认都序列化，除了transient或static修饰的成员
	5、序列化的对象的成员的类型也必须实现了序列化
	6、实现序列化时，建议添加serialversionUID,为了提高版本的兼容性
	7、如果父类已经实现了序列化，则其子类默认实现序列化
====================================================
## 其他小流
一、标准的输入输出流

		类型		默认设备			重定向
System.in	InputStream	键盘			System.setIn(InputStream);
System.out	PrintStream	显示器			System.setOut(PrintStream);
System.err	PrintStream	显示器			System.setErr(PrintStream);




二、转换流

分类：
	InputStreamReader:InputStream——>Reader
	OutputStreamWriter:OutputStream——>Writer

好处：
	如果读写的数据都为字符，则使用字符流更高效，而且处理中文问题比较方便



三、打印流的分类和特点


分类：
	PrintStream
	PrintWriter

特点：
	①只有输出，没有输入
	②打印流提供了一系列非常方便的打印方法，如printf、println、print等，可以直接打印任意类型数据的toString形式

	③打印流的写和打印方法不用自己捕获异常，除了构造器会抛异常  System.out.println();
	④打印流可以在创建对象时，通过指定一个boolean的参数，设置自动刷新
		要求：PrintStream必须调用println或写入结束后+\n
		      PrintWriter必须调用println或printf或format方法中的一个

	⑤打印流在创建对象时，可以指定字符编码


===========================================
## Properties类
一、说明
Properties类用于读写配置文件的，提供了一系列比较方便获取或设置键值对信息的方法

Map
	HashMap
	Hashtable
		Properties

二、配置文件的特点
1、写法
键=值
键=值
2、键和值的类型都是String类型
3、配置文件默认编码格式：ISO8859-1

三、使用步骤
1、读取配置文件
步骤1：创建Properties对象
Properties  info = new Properties();

步骤2：加载配置文件到集合（文件——>内存）
info.load(new FileInputStream(文件));

步骤3：根据键获取值 ★
String value=info.getProperty(键);


info.list(System.out);
2、写入配置文件
步骤1：创建Properties集合对象
Properties info  = new Properties();

步骤2：设置键值对
info.setProperty(键，值);

步骤3：写入到配置文件（内存——>文件）
info.store(new FileOutputStream(文件),备注);






==============================================
## File类
一、说明
File类代表了一组表示文件或目录的对象，里面提供了一系列 对文件操作的方法，如创建、删除等

二、构造器
注意：路径可以是绝对路径或相对路径

new File(string):根据文件的全路径名，构建一个指向该文件的File对象
new File(File parent,subname)：根据文件的父目录和子路径，构建一个指向该文件的File对象
new File(String parent,subname)：根据文件的父目录和子路径，构建一个指向该文件的File对象
new File(URL url):根据url对象，构建一个指向具体资源文件的File对象
	http://www.atguigu.com/index.jsp

三、常见字段
E:/demo/a/b/c/n.txt
"E:"+File.seperator+"demo"+File.seperator

seperator:文件路径分隔符 ，windows下为\\，unix下为/
seperatorChar:同上，只是类型：char

pathSeperator:路径分隔符，windows下为; ,unix下为:
pathSeperatorChar:同上，只是类型:char





四、常见方法
exists 判断文件或目录是否存在
delete 删除文件或空目录	，返回类型boolean， 调用时立即删除
deleteOnExit 删除文件或空目录，返回类型 void，调用时不一定删除，当程序退出时才删除
createNewFile 创建新文件
mkdir创建一层目录
mkdirs创建多层目录
isHidden判断是否隐藏
isFile判断是否是文件
isDirectory判断是否是目录
length获取文件大小
