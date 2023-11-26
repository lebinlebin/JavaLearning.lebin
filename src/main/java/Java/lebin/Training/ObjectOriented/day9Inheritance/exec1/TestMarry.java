package Java.lebin.Training.ObjectOriented.day9Inheritance.exec1;
/**
 * 综合练习：男孩和女孩结婚
 * 知识点：this关键字、构造器、封装
 * @author liyuting
 *  this:谁调用则this就代表谁
 *  
 */
public class TestMarry {
	
	public static void main(String[] args) {
		Girl a = new Girl("李小璐",20);
//		Boy b = new Boy("贾乃亮",20);
//		b.marry(g);
		
		Girl b = new Girl("范冰冰",32);
		
		int compare = a.compare(b);
		System.out.println(compare);
	
		
		
	}

}
class Girl{
	private String name;
	private int age;
	public void marry(Boy b){//pgOne
		//打印男孩和女孩的名称
		System.out.println(this.name+"和"+b.getName()+"愉快的在一起了！哈哈");
	}
	/**
	 * 功能：比较两个女孩的年龄大小
	 * @param g代表要比较的女孩
	 * @return 1，代表当前大。0，两者相等，-1 ，当前当前女孩小
	 */
	public int compare(Girl g){//this:a  g:b
		if(this.age>g.age)
			return 1;
		else if(this.age==g.age)
			return 0;
		else
			return -1;
		
		
	}
	public Girl(String name,int age){
		this.name=name;
		this.age=age;
	}
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
	
}
class Boy{
	
	private String name;
	private int age;
	public void marry(Girl g){//g:李小璐
//		this//贾乃亮
		//调用g的marry方法
//		Boy b=new Boy("Pgone",40);
		g.marry(this);//b:Pgone
	}
	public Boy(String name,int age){
		this.name=name;
		this.age=age;
	}
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
	
	
}
