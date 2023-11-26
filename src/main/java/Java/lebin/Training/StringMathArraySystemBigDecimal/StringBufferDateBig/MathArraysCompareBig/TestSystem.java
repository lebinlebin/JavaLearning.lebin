package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.MathArraysCompareBig;
/**
 * 此类用于演示System类的特点和常见方法
 * @author liulebin
 *
 */
public class TestSystem {

	public static void main(String[] args) {
		//方法1：arrayCopy复制
		int[] src = {2,3,1,4,5};
		int[] dest = new int[src.length];
		System.arraycopy(src, 1, dest, 0, src.length-2);
		
		printArr(dest);
		
		
		//方法2：exit退出
		
//		System.exit(0);
		
		method();
		System.out.println("嘿嘿");
		
	}
	
	public static void method(){
		for(int i=1;i<=100;i++){
			if(i==5){
//				return;
				System.exit(0);
			}
		}
		System.out.println("哈哈");
	}
	
	//打印数组的各元素
	public static void printArr(int[] a){
		System.out.println("-----------------------------------");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}
