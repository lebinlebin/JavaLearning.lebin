package Java.lebin.Training.FileSys.ioSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;


/**
 * 此类用于演示对象流使用的细节特点：
 * @author liulebin
 * 1、读写的顺序要求一致
 * 2、serialVersionUID 的作用是为了新老版本的兼容性！推荐使用！
 * 3、对象序列化时，默认将所有属性进行序列化，除了static和transient修饰的属性
 * 4、要求实现序列化的对象的属性类型也必须都可序列化（也就是实现Serializable接口）
 * 5、如果父类已经实现了序列化，则默认子类也实现了序列化（也就是子类不用手动实现序列化功能）
 * 
 *
 */

public class TestObjectIO2 {
	//测试序列化
	@Test
	public void test1() throws IOException {

		Person p1 = new Person("花无缺", 18, 180,"中国",new Computer("联想"));
		Person p2 = new Person("小鱼儿", 18, 160,"日本",new Computer("戴尔"));
		Person p3 = new Person("燕南天", 40, 170,"美国",new Computer("苹果"));
		
		Student s = new Student("john", 12, 100);

		// 1.创建序列化流对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\person.dat"));

		// 2.序列化对象
		
		
//		oos.writeInt(100);;
//		oos.writeDouble(1.5);
//		oos.writeObject(p1);
//		oos.writeObject(p2);
//		oos.writeObject(p3);
		
		oos.writeObject(s);

		// 3.关闭
		oos.close();

	}

	//测试反序列化
	@Test
	public void test2() throws ClassNotFoundException, IOException {
		// 1.创建反序列化流对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\person.dat"));

		// 2.反序列化对象
		
//		System.out.println(ois.readInt());
//		System.out.println(ois.readDouble());
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());
		System.out.println(ois.readObject());

		// 3.关闭
		ois.close();
	}

}
