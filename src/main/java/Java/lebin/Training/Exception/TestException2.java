package Java.lebin.Training.Exception;
/**
 * 此类用于演示常见的运行异常
 * @author liulebin
 *
 */
public class TestException2 {
	
	public static void main(String[] args) {
		
		//1.空指针异常
		//示例1：
//		Boy b = new Boy();
//		System.out.println(b);
		
		//示例2：
//		Boy[] boys = new Boy[3];
//		for(int i=0;i<boys.length;i++){
//			boys[i]=new Boy();
//			boys[i].g=new Girl("柳岩");
//		}
//		System.out.println(boys[0]);
//		System.out.println(boys[0].g);
//		System.out.println(boys[0].g.name);
//		System.out.println(boys[0].g.name.length());
		
		
		//2.数组下标越界
//		System.out.println(args[0]);
		
		
		//3.类型转换异常
//		Animal a = new Duck();
//		Cat c = (Cat)a;
		
		//4.数学运算异常
//		int i=1/0;
		
		//5.数字格式不正确异常
		
		int a=Integer.parseInt(args[0]);
		
		
		
		
		
	}

}
class Duck extends Animal{
	
}
class Cat extends Animal{
	
}
class Animal{
	
}
class Boy{
	Girl g;
	
//	public String toString(){
//		return g.name;
//	}
	
	
}
class Girl{
	
	String name;
	public Girl(String name){
		this.name=name;
	}
}