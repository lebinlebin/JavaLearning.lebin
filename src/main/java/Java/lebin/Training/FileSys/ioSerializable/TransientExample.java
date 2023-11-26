package Java.lebin.Training.FileSys.ioSerializable;

import org.junit.Test;

import java.io.*;


/**
 * transient关键字
 * 其实这个关键字的作用很好理解，就是简单的一句话：将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化。
 *输出如下：
 * NameStore{firstName='Steve', middleName='null', lastName='Jobs'}
 * middleName 变量被申明为 transient，因此没有被序列化。
 */

class NameStore implements Serializable {
	private String firstName;
	private transient String middleName;
	private String lastName;

	public NameStore (String fName, String mName, String lName){
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
	}

	@Override
	public String toString() {
		return "NameStore{" +
				"firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}

public class TransientExample {
	public static void main(String[] args) throws Exception {
		NameStore nameStore = new NameStore("Steve", "Middle","Jobs");
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/nameStore.dat"));
		// writing to object
		o.writeObject(nameStore);
		o.close();

		// reading from object
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/nameStore.dat"));
		NameStore nameStore1 = (NameStore)in.readObject();
		System.out.println(nameStore1);

	}
}