package Java.lebin.Training.ObjectOriented.DEMOTEST.demo1;

/*
 * 此类用于演示方法的参数或返回类型为引用类型的语法和使用。
 * 
 * 一、方法的参数类型为：引用类型
 * 	①数组类型
 * 	②对象类型
 * 
 * 二、方法的返回类型为：引用类型
 * 	①数组类型
 * 	②对象类型
 * 案例：
 * 二、定义方法，实现求某个double数组的最大值，并返回
三、定义方法，实现查找某字符串数组中的元素查找，并返回索引，如果找不到，返回-1
四、定义方法，实现更改某本书的价格，具体：如果价格>150,则更改为150，如果价格>100,更改为100，否则不变
【需要提前定义好Book书类，并提供价格属性以及显示价格的方法】
五、打印某字符串型数组中的所有元素 
六.求整型数组的和 
七.实现数组的复制功能，根据旧数组，返回一个新数组，元素和旧数组一样
 * 
 */

public class TestMethod {
	public static void main(String[] args) {
		MyUtils mu = new MyUtils();
		//调用数组类型做参数的方法
		double[] arr={100,2,5.8,980.5,89};
		double max = mu.getMax(arr);
		System.out.println(max);
		
		
		//调用对象类型做参数的方法
		Book book = new Book();
		book.price=900;
		book.name="葵花宝典";
		mu.setBookPrice(book);
		System.out.println(book.name+"\t"+book.price);
		
		
		//调用数组类型做返回的方法
		int[] src={2,3,4};
		int[] dest = mu.arrayCopy(src,src.length-1);
		for (int i = 0; i < dest.length; i++) {
			System.out.println(dest[i]);
		}
		
		//调用对象类型做返回的方法
		Book copyBook = mu.copyBook(book);
		System.out.println(copyBook.name+"\t"+copyBook.price);
	}

}

class MyUtils{
	
	//返回类型：对象类型
	//场景：实现Book对象的复制，新Book的书名和旧Book一样，价格为旧Book的2倍
	
	public Book copyBook(Book book){
		Book newBook = new Book();
		newBook.name=book.name;
		newBook.price=book.price*2;
		return newBook;
	}
	
	
	
	//返回类型：数组类型
//	场景：实现数组的复制功能，根据旧数组和指定长度，返回一个新数组，元素和旧数组一样
	public int[] arrayCopy(int[] src,int len){
		int[] dest = new int[len];
		int length = len<src.length?len:src.length;
		for (int i = 0; i < length; i++) {
			dest[i]=src[i];
		}
		return dest;
		
	}
	
	//参数类型：数组类型
	public double getMax(double[] arr){
		double max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max<arr[i])
				max=arr[i];
		}
		return max;
	}
	
	//参数类型：对象类型
	
	public void setBookPrice(Book book){
		
		if(book.price>150){
			book.price=150;
		}else if(book.price>100){
			book.price=100;
		}
		
	}
	
	
}

class Book{
	String name;
	double price;
}








