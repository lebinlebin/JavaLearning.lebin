package Java.lebin.Training.DSA._05_BinarySearchTree1;

public class Person implements Comparable<Person> {
	private int age;
	private String name;

	//age和name为私有类型，私有类型不能被直接访问，需要通过get和set方法
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(int age) {
		this.age = age;
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person e) {
//		if (age > e.age) return 1;
//		if (age < e.age) return -1;
//		return 0;
		return age - e.age;
	}

	@Override
	public String toString() {
		return age + "_" + name;
	}
	
}
