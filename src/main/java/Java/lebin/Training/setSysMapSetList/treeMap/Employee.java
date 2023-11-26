package Java.lebin.Training.setSysMapSetList.treeMap;

public class Employee implements Comparable{

	
	private String name;
	private double salary;
	private int id;
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String name, double salary, int id) {
		super();
		this.name = name;
		this.salary = salary;
		this.id = id;
	}

	/**compareTo方法，在treeMap中可以直接按照 顺序打印元素
	 * 实现了
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		Employee e=(Employee) o;
		if (this.id>e.id) {
			return 1;
		}else if(this.id<e.id)
			return -1;
		return Double.compare(this.salary, e.salary);
	}
	
	
}
