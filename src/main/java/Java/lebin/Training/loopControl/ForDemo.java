package  Java.lebin.Training.loopControl;

/*

此类用于演示for循环结构的 特点和使用

*/
import java.util.Scanner;

//题型一：案例：打印1——100
// 死循环

class ForDemo
{
	public static void main(String[] args)
	{
		int i=1;

		for(;;){

			System.out.println(i);
			i++;

		}


	}
}
//题型二：案例：不断输入姓名，直到输入q
class ForExec1
{
	public static void main(String[] args)
	{

		Scanner input  = new Scanner(System.in);
		for(String name="";!name.equals("q");name=input.next()){
			System.out.print("请输入姓名：");


		}
	}
}
class ForExec2
{
	public static void main(String[] args)
	{
		Scanner input  = new Scanner(System.in);
		System.out.print("请输入一个整数：");
		int num = input.nextInt();

		for(int i=0,j=num;i<num+1;i++,j--){
			System.out.println(i+"+"+j+"="+num);



		}



	}


}
/*.输出所有的水仙花数，所谓水仙花数是指一个3
   位数，其各个位上数字立方和等于其本身。
    例如： 153 = 1*1*1 + 3*3*3 + 5*5*5
*/

class ForExec3
{
	public static void main(String[] args)
	{

		for(int i=100;i<=999;i++){
			//循环操作
			int ge = i%10;
			int shi = i/10%10;
			int bai = i/100;

			//①先判断水仙花数是否满足

			if( i == Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3))
				//②打印
				System.out.println(i);

		}


	}


}