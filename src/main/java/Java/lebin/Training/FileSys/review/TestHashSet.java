package Java.lebin.Training.FileSys.review;

import java.util.HashSet;

public class TestHashSet {
	
	public static void main(String[] args) {
		HashSet set = new HashSet();
		Person p1 = new Person(1001,"AA");//1000  1
		Person p2 = new Person(1002,"BB");

		set.add(p1);
		set.add(p2);

		p1.name = "CC";
		System.out.println(set.remove(p1));//先将待删除的元素的哈希值（p1:1001 CC的哈希值2000  2）

		System.out.println(set); //1001 CC   1002 BB
		set.add(new Person(1001,"CC"));//将待添加的元素1001 CC的哈希值获取，并判断处索引
		System.out.println(set);//1001 CC  1002 BB  1001 CC
		set.add(new Person(1001,"AA"));//1001 CC  1002 BB  1001 CC  1001 AA
		System.out.println(set);//1001 CC  1002 BB  1001 AA
	}

}
