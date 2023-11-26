package Java.lebin.Training.DSA._12_PriorityQueue;

public class Person implements Comparable<Person> {
	private String name;
	private int boneBreak;
	public Person(String name, int boneBreak) {
		this.name = name;
		this.boneBreak = boneBreak;
	}
	
	@Override
	public int compareTo(Person person) {
		return this.boneBreak - person.boneBreak;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", boneBreak=" + boneBreak + "]";
	}
}
