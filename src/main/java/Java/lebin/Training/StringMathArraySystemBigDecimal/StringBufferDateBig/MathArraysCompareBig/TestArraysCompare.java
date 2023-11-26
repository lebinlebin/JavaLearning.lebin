package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.MathArraysCompareBig;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 此类用于演示Arrays类的特点和常见方法
 * @author liulebin
 *
 */
public class TestArraysCompare {
	//方法1：sort 自然排序 .
	/*
	 * 要求：数组的元素类型必须是Comparable接口的实现类，并实现了compareTo方法
	 */
	@Test
	public void test1() {
//		int[] a = {3,2,1,5,6};
//		String[] a = {"john","lucy","jack"};
		
		Star[] a = {new Star("高云翔",70000),new Star("董璇",80000),new Star("关悦",60000)};
		//a中的元素必须实现comparable方法
		Arrays.sort(a);//排序
		for(Star i:a){
			System.out.println(i);
		}
	}

	
	//方法2：sort(object[],Comparator)定制排序
	@Test
	public void test2() {
		//演示简单类型：String[]
		String[] a={"john","lucy","jack"};

		//定制排序，传递一个Comparator，是一个接口。
		//内部类+抽象方法实现
		Arrays.sort(a, new Comparator(){
			//比较规则
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				//正序和逆序
				return -s1.compareTo(s2);
			}
		});
		//演示复杂类型 ：Star[]

		Star[] aa = {new Star("高云翔",70000),new Star("董璇",80000),new Star("关悦",60000)};
		//实现
		Arrays.sort(aa, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Star s1 = (Star) o1;
				Star s2 = (Star) o2;
				return Double.compare(s2.getPrice(), s1.getPrice());
			}
		});
		printArr(a);
	}
	
	
	//方法3：binarySearch 通过二分搜索法查找元素是否存在，如果存在返回索引，如果不存在，直接返回负数
	@Test
	public void test3() {
		//演示简单类型：int[]
//		int[] a = {3,2,1,5,6};
		//演示复杂类型:Star[] 要求必须排好序而且实现Comparable接口
		Star[] a = {new Star("高云翔",70000),new Star("董璇",80000),new Star("关悦",60000)};
		Arrays.sort(a);
		int index = Arrays.binarySearch(a, new Star("关悦",60000));
//		1 2 3 5 6
		System.out.println(index);
	}
	
	
	//方法4：copyOf 数组的元素复制
	
	@Test
	public void test4() {
		Integer[] a = {3,2,1,5,6};
		Integer[] b = Arrays.copyOf(a, a.length+2);
		
		printArr(b);
		/*
		 * Object[]的值可以是Integer[]类型，但不可以是int[]
		 * Object的值可以是int，也可以是Integer
		 * 
		 * 
		 */
	}
	//方法5：equals 用于判断两个数组的元素内容是否相等 
	@Test
	public void test5() {
		int[] a = {3,2,1,5,6};
		int[] b = {3,2,1,5,6};
		//这里是判断数组的地址是否相等
		System.out.println(a==b);
		//判断数组的内容是否相等.要求长度，内容都一样
		boolean equals = Arrays.equals(a, b);
		System.out.println(equals);

	}
	
	//方法6：fill 填充某个指定的值
	@Test
	public void test6() {
		Integer[] a=new Integer[5];
		Arrays.fill(a, 100);
		printArr(a);
	}
	//方法7：toString 
	@Test
	public void test7() {
		int [] a = {3,2,1,5,6};
		String string = Arrays.toString(a);
		//逗号分隔
		System.out.println(string);
	}
	
	
	public void printArr(Object[] a){
		System.out.println("-----------------------------------");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}

class Star implements Comparable{
	
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Star(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Star [name=" + name + ", price=" + price + "]";
	}
	
	//比较规则
	@Override
	public int compareTo(Object o) {
		Star s = (Star) o;
		if(this.price>s.price)
			return 1;
		else if(this.price<s.price)
			return -1;
		return 0;
	}
	
	
	
}