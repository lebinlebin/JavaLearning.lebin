package Java.lebin.Training.generic.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import Java.lebin.Training.FileSys.review.Person;

/**
 * 此类用于综合练习：泛型
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。

分别创建以下方法：
public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
public T get(String id)：从 map 中获取 id 对应的对象
public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
public List<T> list()：返回 map 中存放的所有 T 对象
public void delete(String id)：删除指定 id 对象


定义一个 User 类：
该类包含：private成员变量（int类型） id，age；（String 类型）name。


创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
使用 Junit 单元测试类进行测试。

 * @author liulebin
 *
 */
public class TestGeneric {
	
	@Test
	public void test2() {
		
		DAO<Person> dao = new DAO<>();
		
//		dao.save(id, entity);
		
		

	}
	
	@Test
	public void test1() {
		
		DAO<User> dao = new DAO<>();
		dao.save("001", new User(1,12,"john"));
		dao.save("002", new User(2,12,"lucy"));
		dao.save("003", new User(3,12,"jack"));
		dao.save("004", new User(3,12,"rose"));
		
		List<User> list = dao.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		System.out.println("---------------------");
		System.out.println(dao.get("003"));
		System.out.println("---------------------");
		dao.update("003", new User(100,29,"令狐冲"));
		List<User> list2 = dao.list();
		for (User user : list2) {
			System.out.println(user);
		}

		System.out.println("---------------------");
		
		dao.delete("001");
		List<User> list3 = dao.list();
		for (User user : list3) {
			System.out.println(user);
		}
		
	}

}
class User{
	private int id;
	private int age;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
}
class DAO<T>{
	Map<String,T> map = new HashMap<>();
	/**
	 * 功能:用于添加指定的键值对
	 * @param id
	 * @param entity
	 */
	public void save(String id,T entity){
		map.put(id, entity);
		
	}
	/**
	 * 功能：根据指定的键返回值
	 * @param id
	 * @return
	 */
	public T get(String id){
		return map.get(id);
	}
	/**
	 * 功能：修改指定id的对象
	 * @param id
	 * @param entity
	 */
	public void update(String id,T entity){
		map.put(id, entity);
		
	}
	/**
	 * 功能：根据键删除
	 * @param id
	 */
	public void delete(String id){
		map.remove(id);
	}
	/**
	 * 功能：返回所有的值
	 * @return
	 */
	public List<T> list(){
		
		Collection<T> values = map.values();
		List<T> list = new ArrayList<>();
		list.addAll(values);
		return list;
		
	}
}
