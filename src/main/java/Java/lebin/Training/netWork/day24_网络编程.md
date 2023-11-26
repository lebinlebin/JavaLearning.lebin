##本单元目标

	1、网络的相关概念
	2、InetAddress类的介绍
	3、基于TCP协议的网络通信
	4、基于UDP协议的网络通信
	5、基于URL的网络通信



###一、网络的相关概念

1.网络通信

 概念：	多台设备之间通过网络进行数据传输
  对于程序员讲，我们要做的 就是 通过一定的方法，将数据从一台设备传输到另一台设备或
接受另一台设备传输过来的数据

 java.net包中提供了一系列用于网络中数据传输的方法



2、网络

	概念：多台设备之间通过一定的物理设备连接起来就构成了网络

	分类：按覆盖范围不同
		局域网：覆盖范围最小

		城域网:覆盖范围居中

		广域网：覆盖范围最大
			典型的代表：万维网


3、IP地址

	概念：网络中每台计算机的唯一标识号
	表示形式：点分十进制
			xx.xx.xx.xx
	每一个十进制的范围：0~255

	组成：网络地址+主机地址

	分类：
			第一个十进制数		网络地址		主机地址	

	A		0~126				第一位		后三位
	B		128~191				前两位		后两位
	C		192~223				前三位		后一位

	D		科研、测试

	E		保留


4、域名

	概念：为了方便记忆对方设备的地址，将ip地址一一对应成域名

	手机电话簿中：
	联系人姓名————联系人电话
	域名		————ip

	www.atguigu.com


5、端口号

	概念：某台设备中的指定网络程序的标识号
	表示形式：0~65535之间的整数
	其中0~1024已经被占用

	常见的端口号：
	tomcat:8080
	oracle:1521
	mysql:3306


6、传输协议

基于TCP的传输：

	1、面向连接的，安全可靠
		“三次握手”

		第一次握手：确保 发送和接受设备没问题
		第二次握手：确保 接收端可以正常接受数据
		第三次握手：确保 发送端可以正常发送数据


	2、传输的速率较低

	3、传输的数据没有字节限制

	4、必须释放连接资源

	



基于UDP的传输:

	1、面向无连接，不安全可靠

	2、传输的速率较高
	3、传输的数据有字节限制 64k
	4、不需要释放连接资源
	
##二、InetAddress类的特点和使用
###特点

	代表一个IP地址对象，有两个子类Inet4Address和Inet6Address

###常见方法

		getLocalHost()获取本机IP地址对象
	    getByName(主机名或ip地址)：根据指定主机名获取ip地址对象
	    getHostName()：获取主机名
	    getHostAddress()：获取ip地址
##三、基于TCP协议的网络通信


	基于客户端/服务端 c/s架构模型
	
	
	1.客户端向服务端发送链接请求（服务端接受链接请求）
	2.客户端向服务端发送数据
	3.服务端接受客户端的数据


##四、基于UDP协议的网络通信

	基于发送端/接收端的架构模型

	1.发送端向接收端发送数据
	2.接收端接受数据，并向发送端回应数据
	3.发送端接受回应过来的数据
	

	

##五、基于URL的网络通信
###URL的理解

		//1.创建URL对象
		URL url = new URL("http://192.168.26.60:8080/cang.jpg?name=john");
		
		//2.调用方法，获取url的各部分
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());


###基于URL的网络通信
	//测试基于URL的网络通信——下载url指定的资源
	@Test
	public void test2() throws IOException {
		
		//1.创建url对象
		URL url = new URL("http://192.168.26.60:8080/cang.jpg");
		
		//2.打开连接
		URLConnection connection = url.openConnection();
		
		//3.读数据（下载）
		
		InputStream inputStream = connection.getInputStream();
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\cang.jpg"));
		//边读边写
		bos.write(StreamUtils.streamToByteArray(inputStream));
		
		
		//4.关闭
		bos.close();
		inputStream.close();
		
		
		

	}




