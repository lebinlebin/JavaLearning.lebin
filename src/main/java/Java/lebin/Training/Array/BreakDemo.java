package Java.lebin.Training.Array;

/**

 此类用于演示break的特点和使用


 */


class BreakDemo
{
	public static void main(String[] args)
	{

		//方式一：不推荐
		/*
		label:for(int i=1;i<=10;i++){
			for(int j=1;j<=5;j++){
				if(j==3){
					break label;
				}
				System.out.println("哈哈"+j);
			}
			System.out.println("嘻嘻-------------"+i);


		}*/
		//方式二：推荐
		boolean flag = true;
		for(int i=1;flag&&i<=10;i++){
			for(int j=1;j<=5;j++){
				if(j==3){
					flag=false;
					break;
				}
				System.out.println("哈哈"+j);
			}

			System.out.println("嘻嘻-------------"+i);


		}
	}
}
