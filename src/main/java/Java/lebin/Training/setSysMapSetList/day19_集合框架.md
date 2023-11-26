##本单元目标

	1.集合的理解和好处
	2.集合的框架体系图 ★
	3、Collection接口的特点和使用 ★
	4、List和Set接口的特点和使用★
	5、List接口的实现类学习★
	6、Set接口的实现类学习★
	7、Map接口的特点和使用★
	8、Map接口的实现类学习★
	9、Collections工具类的使用★
	10、泛型的使用★


##集合的学习思路

层面1：应用层面  √

	可以掌握重点的集合类的使用步骤

层面2：理解层面【面试前掌握】

	理解ArrayList的源码//动态数组
	理解HashMap的源码
	
	Collection和Map的对比
	List和Set的对比
	ArrayList和Vector的对比
	ArrayList和LinkedList的对比
	
	HashMap和Hashtable的对比
	Collections和Collection的对比
	

##一、集合的理解和好处	
###理解
	集合：就是一种容器，都是用于保存一组元素
	
	集合和数组的对比：
###好处

数组的不足：

	1、数组的长度必须提前指定，而且一旦指定不能更改
	2、数组只能保存相同类型的元素

集合：

	1、集合在使用时，长度不用指定，而且可以实现自动扩容或截断

	2、集合没有指定泛型之前，默认保存的是任意类型的元素（Object类型）
       指定泛型之后，可以保存对应类型 的元素

示例代码：

	使用数组--------------------
		Animal[] animals = new Animal[3];
		animals[0] = new Animal();	
		animals[1] = new Animal();	
		animals[2] = new Animal();	
	
		Animal[] newAni = new Animal[animals.length+1];
		//复制数组
		//添加新元素
		animals=newAni;
	
	使用集合--------------------
		List list= new ArrayList();
	
		list.add(new Animal());
总结：

	数组：比较适合保存 基本类型的元素
	集合：比较适合保存 引用类型的元素（对象）



##集合的框架体系图 ★
	 略，见图
	

##Collection接口的特点和使用

###Collection的特点

	里面没有提供直接的实现类，而是提供了子接口，子接口中有具体的实现类

	该接口中提供了一系列常见的集合操作的方法：增加、删除、查找


###常见方法 ★

	 * add/addAll
	 * remove/removeAll
	 * contains/containsAll
	 * clear
	 * size
	 * isEmpty

###遍历方式 ★

迭代器工作特点：★

	1、每次只能下移一位
	2、只能下移不能上移！
注意： ★

	 * ①使用迭代器过程，不适合做增删，容易报异常ConCurrentModificationException
	 * ②使用迭代器过程，可以做修改，但如果修改地址，没有效果！
	 * ③使用迭代器过程，如果非要做删除，可以使用迭代器本身的remove方法！
	

方式1：使用迭代器

	/*
		迭代器的使用步骤：
		①获取迭代器对象，指针默认在最上方
		②通过调用hasNext判断下一个是否有元素
		③通过调用next下移一位并获取当前元素


	*/

	@Test
	public void test1(){
		//3.遍历集合
		//①获取迭代器
		Iterator iterator = col.iterator();
		
		//②判断,如果返回true，则进行下一步
		while(iterator.hasNext()){
				//③下移一位，并获取对应元素
				System.out.println(iterator.next());
		}
	}
	
方式二：为了简化Iterator的语法，jdk5.0出现了增强for

	/*
	 * 增强for的本质就是Iterator，只是语法简化了！
	 * 
	 * 语法：
	 * for(元素类型 元素名:集合或数组名){
	 * 		//访问元素即可
	 * }
	 * 
	 */
	
	@Test
	public void test2() {
		//3.遍历集合
		for(Object o: col){
			System.out.println(o);
		}
	}
	

	

##List接口的特点和使用
	
###List接口的特点

	1、有序（插入和取出的顺序一致的），原因：有一个整数索引记录了插入的位置
	2、允许重复

###List接口的特有方法
	 * add(object)增
	 * remove(index)按指定索引删
	 * set(index,object)改
	 * indexOf(object)查
	 * add(index,object)插入
	 * get(index)获取
###List接口的遍历方式

	//方式1：使用iterator
	@Test
	public void test1() {
		//3.遍历
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()){
			Object book = iterator.next();
			System.out.println(book);
		}
	}
	//方式2：使用增强for
	@Test
	public void test2() {
		//3.遍历
		for (Object object : list) {
			System.out.println(object);
		}
	}

	//方式3：使用普通for
	@Test
	public void test3() {
		for(int i=0;i<list.size();i++){
			Object object = list.get(i);
			System.out.println(object);
		}
	}

###List接口的实现类：ArrayList

底层结构：可变数组

jdk8：ArrayList中维护了Object[] elementData，初始容量为0.
第一次添加时，将初始elementData的容量为10
再次添加时，如果容量足够，则不用扩容直接将新元素赋值到第一个空位上
如果容量不够，会扩容1.5倍


jdk7:ArrayList中维护了Object[] elementData，初始容量为10.
添加时，如果容量足够，则不用扩容直接将新元素赋值到第一个空位上
如果容量不够，会扩容1.5倍


jdk7和jdk8：
	区别：jdk7 相当于饿汉式，创建对象时，则初始容量为10
		  jdk8 相当于懒汉式，创建对象时，并没有初始容量为10，而在添加时才去初始容量为10
	


###List接口的实现类：Vector

底层结构：可变数组，和ArrayList很像

###List接口的实现类：LinkedList


底层结构：双向链表
	
	LinkedList中维护了两个重要的属性 first和last，分别指向首节点和尾节点。
	每个节点（Node类型）里面又维护了三个属性item、next、prev，分别指向当前元素、下一个、上一个元素。最终实现手拉手的链表结构！



###总结：实现类对比


一、ArrayList和Vector的对比
			底层结构		版本		线程安全（同步）		效率			扩容的倍数
ArrayList	可变数组		新		不安全（不同步）		较高			1.5倍

Vector		可变数组		老		安全（同步）			较低			2倍




	
二、ArrayList和LinkedList的对比
				底层结构		增删的效率					改查的效率

ArrayList		可变数组		前面和中间的增删,较低			较高


LinkedList		双向链表		前面和中间的增删，较高			较低



总结：

	如果考虑线程安全问题：Vector
	不考虑线程安全问题：
						查找较多：ArrayList
						增删较多：LinkedList



##Set接口的 特点和使用


###Set接口的特点

	1.不允许重复，至多一个null
	2.无序（插入和取出的顺序不一致），没有索引

###Set接口的特有方法
	没有特有方法，都是从Collection继承来的

	

###Set接口的遍历方式

	和Collection的遍历方式同



###Set接口的实现类：HashSet
	底层结构：维护了一个HashMap对象，也就是和HashMap的底层一样，基于哈希表结构的

	如何实现去重：

		底层通过调用hashCode方法和equals方法实现去重
		先调用hashCode，如果不相等，则直接可以添加
						如果相等，则继续判断equals，如果不相等，则可以添加，否则返回false

	

	应用：通过HashSet添加元素时，如果认为内容相等的为重复元素，则需要重写该元素的hashCode和equals方法

	



###Set接口的实现类：TreeSet


	特点：

	1、不允许重复，里面不允许null
	2、可以实现对里面元素进行排序
			自然排序
			定制排序


	底层结构：底层维护了一个TreeMap，而TreeMap底层是红黑树结构，可以实现对元素进行排序
	
	应用：

	方式一：自然排序
	要求：必须让添加元素的类型实现Comparable接口，实现里面的compareTo方法
	

	方式二：定制排序
	要求：创建TreeSet对象时，传入一个Comparator接口的对象，并实现里面的compare方法
			
		
	如何实现去重：
			通过比较方法的返回值是否为0来判断是否重复

	

##Map接口的特点和使用

###Map接口的特点

	用于保存一组键值对映射关系的
	其中键不可以重复，值可以重复。而且一个键只能映射一个值


###Map接口的常见方法

	put 添加
	remove删除
	containsKey查找键
	containsValue查找值
	get根据键获取值
	size获取键值对的个数
	isEmpty判断元素是否为空
	clear清除

	entrySet 获取所有的关系
	keySet获取所有的键
	values获取所有的值

	



###Map接口的遍历方式

方式1：通过调用entrySet

	@Test
	public void test1() {
		//步骤1 ：获取所有的关系
		Set entrys = map.entrySet();
		//步骤2：遍历所有的关系
		
		Iterator iterator = entrys.iterator();
		while(iterator.hasNext()){
			//获取每一对关系
			Map.Entry entry = (Entry) iterator.next();
			//根据关系，获取对应的键
			//根据关系，获取对应的值
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

方式2：通过调用keySet
		@Test
		public void test2() {
			//步骤1：获取所有的键
			Set keys = map.keySet();
			//步骤2：遍历所有的键
			for (Object key : keys) {
				System.out.println(key+":"+map.get(key));
			}
		}


###Map接口的实现类：HashMap


	底层结构：哈希表
		jdk7:数组+链表
		jdk8:数组+链表+红黑树
	
	源码分析：
		jdk8： HashMap中维护了Node类型的数组table，当HashMap创建对象时，只是对loadFactor初始化为0.75；table还是保持默认值null
	
		当第一次添加时，将初始table容量为16，临界值为12
		每次添加调用putVal方法：
			①先获取key的二次哈希值并进行取与运算，得出存放的位置
			②判断该存放位置上是否有元素，如果没有直接存放
	 	     如果该存放位置上已有元素，则进行继续判断：
									如果和当前元素直接相等，则覆盖
									如果不相等，则继续判断是否是链表结构还是树状结构，按照对应结构的判断方式判断相等
	
			③将size更新，判断是否超过了临界值，如果超过了，则需要重新resize()进行2倍扩容，并打乱原来的顺序，重新排列

			④当一个桶中的链表的节点数>=8 &&  桶的总个数（table的容量）>=64时，会将链表结构变成红黑树结构


		jdk7和jdk8的区别
		1.jdk7:创建HashMap对象时，则初始table容量为16
		  jdk8:创建HashMap对象时，没有初始table，仅仅只是初始加载因子。只有当第一次添加时才会初始table容量为16.

		2.jdk7:table的类型为Entry
          jdk8:table的类型为Node

		3.jdk7:哈希表为数组+链表，不管链表的总结点数是多少都不会变成树结构
          jdk8：哈希表为数组+链表+红黑树，当链表的节点数>=8 &&  桶的总个数（table的容量）>=64时，会将链表结构变成红黑树结构
		
	应用层面：

			要求添加元素的key重写hashCode和equals方法
			
	
		
	

###Map接口的实现类:Hashtable

底层结构：哈希表 ，同HashMap


###Map接口的实现类:TreeMap

底层结构：红黑树，可以实现对添加元素的key进行排序
应用：
	自然排序:要求key的元素类型实现Comparable，并实现里面的compareTo方法

	定制排序：要求创建TreeMap对象时，传入Comparator比较器对象，并实现里面的compare方法



###Map接口的实现类的对比


一、HashMap和Hashtable的对比

				底层结构		版本			线程安全（同步）		允许null键null值
	
	HashMap		哈希表		1.2			不安全				允许
	
	Hashtable	哈希表		1.0			安全					不允许




##Collections工具类的学习


###常见方法
	reverse反转
	sort排序
	swap两各索引处元素的交换
	shuffle随机打乱顺序
	max获取最大值
	min获取最小值
	frequency 查找指定元素出现的次数
	replaceAll替换旧值为新值
	copy 复制，注意：新集合的size>旧集合的size




##泛型

###泛型的理解和好处

###理解
泛型：jdk5.0出现的新特性；参数化的类型。可以将某个类型当做参数传递给类、接口或方法中


联想：

	A a = new A();
	
	class A<T>{
		T t;
		
	
	}
	
	
	
	method("john");
	public void method(String s){
		//访问s
	
	}

区别：


	方法的参数：传递的是值，必须传参,只能用在方法中
	泛型：传递的是类型，可以不用传参，默认为Object，可以用在方法、类、接口中




###好处

	1、编译时检查待添加的元素类型，提高了类型的安全性
	2、减少了类型转换的次数，提高了效率
	
	没有使用泛型：
		String——>Object——>String
	
	使用泛型：
	
		String——>String——>String
	
	3、减少了编译警告




###泛型的语法和使用 ★

语法： 类型<指定的泛型> 名 = new 类型<>();
表示形式如下：

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<>();//jdk7.0 类型推断
		Set<Integer> set3 = new HashSet();//为了新老版本兼容性，不推荐使用
		Set set4 = new HashSet<Integer>();//为了新老版本兼容性，不推荐使用


注意：
	①泛型的类型只支持引用类型
	②编译类型和运行类型的泛型必须一致

###自定义泛型类、泛型方法、泛型接口【了解】
一、自定义泛型类

定义语法：
	class MyClass<T>{
		T name;
		publci void setName(T t){}
		

	}
	注意：里面可以定义使用泛型的属性、方法也可以定义不使用泛型的普通属性和普通方法
		但不能定义使用泛型的静态方法和使用泛型的数组初始化！

什么时候确定泛型类的具体类型？
	答：创建对象时

	语法：MyClass<String> m = new MyClass<>();
	


二、自定义泛型接口

定义语法：
	interface MyInter<T,U>{
		U method(T t);
	}

什么时候确定泛型接口的具体类型？
	答：被继承或实现时，可以确定，如果不确定，则默认是Object类型。如果想延续泛型，则需要将子接口或实现类设计成泛型形式！



###泛型中的通配符的使用【了解】




	