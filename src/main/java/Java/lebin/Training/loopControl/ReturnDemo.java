package Java.lebin.Training.loopControl;

class ReturnDemo
{
	public static void main(String[] args)
	{
		for(int i=1;i<=10;i++){
			if(i==3){
				return;
//				break;
			}

			System.out.println("呵呵"+i);
		}

		System.out.println("嘎嘎");
	}
}
