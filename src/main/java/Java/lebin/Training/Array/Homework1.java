package Java.lebin.Training.Array;/*

------------------------------小小计算器-------------------------

1.加法
2.减法
3.乘法
4.除法
0.退出
请选择：1
10+5=15



*/
import java.util.Scanner;

class Homework1
{
    public static void main(String[] args)
    {
        Scanner input  = new Scanner(System.in);
        int a= 10;
        int b = 5;
        char key;
        boolean flag = true;
        do{
            System.out.println("------------------------------小小计算器-------------------------");
            System.out.print("1.加法 \n2.减法 \n3.乘法 \n4.除法 \n0.退出\n请选择：");
            key = input.next().charAt(0);
            switch(key){
                case '1':System.out.println(a+"+"+b+"="+(a+b));break;
                case '2':System.out.println(a+"-"+b+"="+(a-b));break;
                case '3':System.out.println(a+"*"+b+"="+(a*b));break;
                case '4':System.out.println(a+"/"+b+"="+(a/b));break;
                case '0':System.out.println("程序退出");flag =false;break;

            }


        }while(flag);

    }
}
//4.输入年月日，判断该日是当年的第几天

/*

2018-3-14
1：天数
2：天数
3:14



2018-9—18
1
2
3
4

8
9:18

方式一：循环



方式二：switch


*/
class Homework2
{

    public static void main(String[] args)
    {
        Scanner input  = new Scanner(System.in);

        System.out.print("please input year:");
        int year= input.nextInt();
        System.out.print("please input month:");
        int month= input.nextInt();
        System.out.print("please input day:");
        int day= input.nextInt();
		/*
		int sum=0;//保存天数和
		for(int i=1;i<month;i++){//i:代表每一个月
			switch(i){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:sum+=31;break;
				case 2:
					if(year%4==0&&year%100!=0||year%400==0){
						sum+=29;
					}else{
						sum+=28;
					}
					break;
				default:
					sum+=30;break;
			}
		}
		System.out.println("这是该年的第"+(sum+day)+"天");

		*/
        int sum=0;//保存天数和
        switch(month-1){
            case 12:sum+=31;
            case 11:sum+=30;
            case 10:sum+=31;
            case 9:sum+=30;
            case 8:sum+=31;
            case 7:sum+=31;
            case 6:sum+=30;
            case 5:sum+=31;
            case 4:sum+=30;
            case 3:sum+=31;
            case 2:
                if(year%4==0&&year%100!=0||year%400==0){
                    sum+=29;
                }else{
                    sum+=28;
                }
            case 1:sum+=31;

        }
        System.out.println(sum+day);




    }

}


/*

随机猜数游戏

*/

class Homework3
{

    public static void main(String[] args)
    {
        Scanner input  = new Scanner(System.in);

        int rand = (int)(Math.random()*100+1);//随机数
        System.out.println(rand);

        boolean flag = false;
        int i=1;
        for(;i<=10;i++){//i：猜的次数
            System.out.print("请猜：");
            int num = input.nextInt();

            if(num==rand){
                if(i==1){
                    System.out.println("你是个天才");
                }else if(i<=3){
                    System.out.println("你很聪明，赶上我了");

                }else if(i<=9){
                    System.out.println("一般般");

                }else{
                    System.out.println("可算猜对了");
                }
                flag = true;
                break;
            }else if(num>rand){
                System.out.println("再小点");
            }else{
                System.out.println("再大点");
            }


        }

        if(!flag){//一次没猜对
            System.out.println("你太笨了！");

        }




    }


}