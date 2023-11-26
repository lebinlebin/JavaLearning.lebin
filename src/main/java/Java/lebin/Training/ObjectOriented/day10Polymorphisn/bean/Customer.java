package Java.lebin.Training.ObjectOriented.day10Polymorphisn.bean;
/**
 * 功能：编写实体类Customer
 * @author liulebin
 *
 */
public class Customer {
	private int id;
	private String name;

	private char gender;
	private int age;
	private String phone;
	private String email;
	/**
	 * 功能：返回客户对象的各属性信息
	 * @return
	 */
	public String getInfo(){
		return id+"\t"+name+"\t"+gender+"\t"+age+"\t"+phone+"\t"+email;
	}
	/**
	 * 功能：有参构造器，实现初始化各属性
	 * @param id
	 * @param name
	 * @param gender
	 * @param age
	 * @param phone
	 * @param email
	 */
	public Customer(int id, String name, char gender, int age, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
