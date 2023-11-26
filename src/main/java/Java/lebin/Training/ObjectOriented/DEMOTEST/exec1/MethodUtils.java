package Java.lebin.Training.ObjectOriented.DEMOTEST.exec1;
/*
 * 
 * 1.打印某字符串型数组中的所有元素
2.定义一个方法，实现判断Animal对象的颜色，如果为white，则提示白色，如果为yellow，则提示黄色，否则提示other

 */
public class MethodUtils {

	/**
	 * 功能：打印字符串型数组
	 * @param arr
	 */
	public void printArr(String[] arr){
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
	}
	/**
	 * 功能：判断Animal的颜色，给出相应的提示
	 * @param animal
	 */
	
	public void judgeColor(Animal animal){
		if(animal.color.equals("white")){
			System.out.println("白色");
		}else if(animal.color.equals("yellow")){
			System.out.println("黄色");
		}else{
			System.out.println("other");
		}
		
	}

}

class Animal{
	String color;
	
}
