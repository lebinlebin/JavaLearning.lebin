package Java.lebin.Training.StringMathArraySystemBigDecimal.StringBufferDateBig.homework;

import java.util.Arrays;

/*
 * 4.获取一个字符串在另一个字符串中出现的次数。
      比如：获取“ ab”在 “abkkcadkabkebfkabkskab”    
      中出现的次数


5.获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
   提示：将短的那个串进行长度依次递减的子串与较长  
   的串比较。

6.对字符串中字符进行自然顺序排序。
提示：
1）字符串变成字符数组。
2）对数组排序，选择，冒泡，Arrays.sort();
3）将排序后的数组变成字符串。
 * 
 * 
 */
public class StringUtils {
	
	public static void main(String[] args) {
//		System.out.println(getSubCount("abkkcadkabkebfkabkskab", "ab"));
		
//		System.out.println("abcdabmmmab".indexOf("ab",5));
		
//		printSubIndex("abkkcadkabkebfkabkskab", "ab");
		
//		System.out.println(getMaxSub("abcwerthelloyuiodef", "cvhellobnm"));
		
		System.out.println(sortString("children"));
		
	}
	
	/**
	 * 功能：排序字符串
	 * @param s
	 * @return
	 */
	public static String sortString(String s){
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i]);
		}
		return builder.toString();
		
		
	}
	
	/**
	 * 功能：返回两个字符串的最大相同子串
	 * @param s1
	 * @param s2
	 * @return 最大相同子串
	 */
	public static String getMaxSub(String s1,String s2){
//		 str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
		/*
		 * 轮数		长度					内容												i		j
		 * 1		str2.length()		str2.substring(0,str2.length())					0		0
		 * 2		str2.length()-1		str2.substring(0,str2.length()-1)				1		0
		 * 								str2.substring(1,str2.length())							1
		 * 
		 * 3		str2.length()-2		str2.substring(0,str2.length()-2)	
		 * 								str2.substring(1,str2.length()-1)
		 * 								str2.substring(2,str2.length())
		 * 
		 * ....							x-j= min.length-i
		 * 
		 * str2.length 1				str2.substring(0,1)
		 * 								str2.substring(1,2)
		 * 								...
		 * 								str2.substring(str2.length()-1,str2.length())
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		String max = s1.length()>=s2.length()?s1:s2;
		String min = s1.length()<s2.length()?s1:s2;
		
		for(int i=0;i<min.length();i++){//外层循环控制轮数，i代表第几轮
			for(int j=0;j<i+1;j++){//内层循环控制比较的次数，j代表第几次
				if (max.contains(min.substring(j, min.length()-i+j))) {
					return min.substring(j, min.length()-i+j);
					
				}
			}
			
		}
		return null;
		
		
	}
	
	
	
	/**
	 * 功能：返回子串在字符串中出现的次数
	 * @param string 
	 * @param sub
	 * @return 次数
	 */
	public static int getSubCount(String string,String sub){
		
		//"ab”在 “abkkcadkabkebfkabkskab”  
		
		int count=0;
		int  index;
		while((index = string.indexOf(sub))!=-1){
			string = string.substring(index+sub.length());
			count++;
		}
		return count;
		
		
	}
	/**
	 * 功能：获取子串出现的索引
	 * @param string
	 * @param sub
	 */
	public static void printSubIndex(String string,String sub){
		
		//"ab”在 “abkkcadkabkebfkabkskab”  
		
		int  index;
		int i=0;
		while((index = string.indexOf(sub, i))!=-1){
			
			i=sub.length()+index;
			System.out.println(index);
			
		}
		
		
	}
	
	
	
	

}
