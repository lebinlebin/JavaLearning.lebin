package Java.lebin.Training.setSysMapSetList.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class setTest {
	public static void main(String[] args) {		
	Set set=new HashSet();
	set.add(new Student("小明","2018.4.2"));
	set.add(new Student("小红","2018.4.4"));
	set.add(new Student("小李","2018.4.4"));
	Iterator iterator=set.iterator();
	while(iterator.hasNext())	{
		System.out.println(iterator.next());
	}

	}	
}
class Student{
	private String name;
	private String birthday;
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name + "\t" + birthday ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Student(String name, String birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}