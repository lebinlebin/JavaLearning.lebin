package Java.lebin.Training.Exception.exec2;
/*
 * 编写应用程序EcmDef.java，接收命令行的两个参数，计算两数相除。
	对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException、两个数不能是负数
  	除0(ArithmeticException) 进行异常处理。
提示： 
	(1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。
	(2)在main()方法中使用异常处理语句进行异常处理。
	
	(3)运行时接受参数 java EcmDef 20 10   
		//args[0]=“20” args[1]=“10”
	(4)Interger类的static方法parseInt(String s)将s转换成对应的int值。如int a=Interger.parseInt(“314”);	//a=314;

 */
public class TestException3 {
	
	
	public static void main(String[] args) {
		try {
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			if(a<0||b<0){
				//手动生成异常对象
				throw new NegativeException("参数不能是负数！");
			}
			double ecm = ecm(a,b);
			
			
			System.out.println(ecm);
		} catch (NumberFormatException e) {
			System.out.println("参数必须为有效的 数值型！");
		}catch(ArithmeticException e){
			System.out.println("第二个参数不能是0！");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("必须传入至少两个参数！");
		}catch(NegativeException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static double ecm(double a,double b){
		return a/b;
	}

}

class NegativeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NegativeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}