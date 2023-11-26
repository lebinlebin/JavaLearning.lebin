package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.bean;
/**
 * 此类用于演示重写Object类的equals方法和toString方法
 * @author liulebin
 *
 */
public class Person {
	/**
	 * 功能：返回对象的属性信息
	 */
	@Override
	public String toString(){
		return name+"\t"+age;
	}
//	
	
	public String getInfo(){
		return name+"\t"+age;
	}
	
	/**
	 * 功能：判断两个Person对象的内容是否相等，如果两个Person对象的name和age属性值完全一样，则返回true，反之，返回false
	 */
	@Override
	public boolean equals(Object obj){//this：person1  obj:person4
		//步骤1：两个对象的地址一样（提高效率）
		if(this == obj)
			return true;
		//步骤2：判断对象的类型
		if(!(obj instanceof Person)){//如果传入的obj不是Person类型，则直接返回
			return false;
		}
		//步骤3：对象的向下转型
		Person p = (Person) obj;//向下转型
		//步骤4：判断内容是否相等
		return this.name.equals(p.name)&&this.age==p.age;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 构造函数
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(){
	}
}
