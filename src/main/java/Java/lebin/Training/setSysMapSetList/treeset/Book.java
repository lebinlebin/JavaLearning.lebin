package Java.lebin.Training.setSysMapSetList.treeset;

public class Book implements Comparable{
	
	private String name;
	private double price;
	private String author;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(String name, double price, String author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}
	
	@Override
	public String toString(){
		/*
		 * %s：字符串
		 * %c：字符
		 * %f：浮点
		 * %d：整数
		 */
		return String.format("名称：%s	价格：%.2f	作者：%s",name,price,author);

	}

	@Override
	public int compareTo(Object o) {
		Book b = (Book) o;
		return Double.compare(this.price, b.price);
	}

}
