package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo1;
/**
 * 编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
类中声明一个say方法，方法显示所有属性值
 * @author liyuting
 *
 */
public class Student {
	String name;
	String gender;
	int age;
	int id;
	double score;
	
	public void say(){
		System.out.println(name+"\t"+age+"\t"+gender+"\t"+id+"\t"+score);
		
		
	}
	
	

}
