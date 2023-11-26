package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo3;
/**
 * 
 * 此类用于演示方法的声明
 * @author liyuting
 * 形式：
 * 1.无返回无参
	2.有返回无参
	3.无返回有参
	4.有返回有参



 *
 */

class MethodDemo{
	//1.无返回无参
	public void print(){
		System.out.println("****");
		System.out.println("****");
		System.out.println("****");
		
	}
	
	//2.有返回无参
	
	public double getArea(){
		
		System.out.println("我是getArea方法");
		int hang = 10;
		int lie = 8;
		return hang*lie;
	}
	
	
	//3.无返回有参
	//案例：根据指定的行数和列数，打印矩形
	public void  printRect(int hang,int lie,String str){
		for(int i=1;i<=hang;i++){
			
			for(int j=1;j<=lie;j++){
				
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	//4.有返回有参数
	//案例：根据行和列的值，返回面积
	public double getArea2(int hang,int lie){
		return hang*lie;
	}
	//案例：判断一个数是奇数还是偶数
	public boolean isOdd(int num){
//		if(num%2==0)
//			return true;
//		else 
//			return false;
		return num%2==0;
	}
	
	
	
}
public class TestMethod {

	public static void main(String[] args) {
		
		//创建方法所属的类的对象
		MethodDemo md = new MethodDemo();
		
		//1.调用无返回无参
//		md.print();
		
		//2.调用有返回无参
//		double result = md.getArea();
//		System.out.println("返回值："+result);
		
		//3.调用无返回有参
//		md.printRect(10, 8, "好");
		
		
		//4.调用有返回有参
		double area2 = md.getArea2(5, 9);
		System.out.println(area2);
		
		
		
		

	}

}
