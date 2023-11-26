package Java.lebin.Training.setSysMapSetList.hashset;

public class Book{
	
	private String name;
	private double price;
	private String author;
	
	/**
	 * 原则：
	 * 1、和属性值相关
	 * 2、属性一样的话，要求哈希值肯定一样
	 *   属性不一样的，尽最大的限度让哈希值不一样！
	 */
//	@Override
//	public int hashCode() {
//		return name.hashCode()+(int)price+author.hashCode()*31;
//	}
	
	
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println(this.name+" pk "+((Book)obj).name);
//		
//		if(this==obj)
//			return true;
//		if(!(obj instanceof Book))
//			return false;
//		Book b = (Book) obj;
//		
//		
//		return this.name.equals(b.name)&&this.price==b.price&&this.author.equals(b.author);
//	}
	public String getName() {
		return name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
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

}
