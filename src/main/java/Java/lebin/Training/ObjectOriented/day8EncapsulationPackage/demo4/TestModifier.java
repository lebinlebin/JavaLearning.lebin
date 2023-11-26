package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.demo4;
/**
 * 此类用于演示修饰符的特点和使用
 * @author liyuting
 *
 */
public class TestModifier {
	
	public static void main(String[] args) {
		Person per=new Person();
//		per.name="john";//私有的
//		per.study();//私有的
		
		
		per.age=10;//缺省
		
		per.weight=100;//protected
		
		per.hobby="";//公共的
	}

}
