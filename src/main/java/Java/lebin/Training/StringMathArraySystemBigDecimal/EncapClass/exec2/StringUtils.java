package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.exec2;

public class StringUtils {

	public static void main(String[] args) {
		
		System.out.println(myTrim("ab cd eff").length());
		
		System.out.println(reverseString("abcdefg", 2, 6));
	}
	/**
	 * 功能模拟一个trim方法，去除字符串两端的空格。
	 * @param s 待去空格的字符串
	 * @return 去掉前后空格字符串
	 *                a   bc d            
	 */
	public static String myTrim(String s){
		
		int beginIndex=0;//起始索引
		for(int i=0;i<s.length();i++){
			if(!Character.isWhitespace(s.charAt(i))){
				beginIndex = i;
				break;
			}
		}
		
		int endIndex = s.length()-1;
		for(int i=s.length()-1;i>=0;i--){
			if(!Character.isWhitespace(s.charAt(i))){
				endIndex = i;
				break;
			}
		}
		return s.substring(beginIndex, endIndex+1);
	}
	
	

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 */
	
	public static String reverseString(String oldStr,int beginIndex,int endIndex){
		
		//①提取指定索引范围内的子串
		String first = oldStr.substring(0, beginIndex);//起始
		String substring = oldStr.substring(beginIndex, endIndex);
		String last = oldStr.substring(endIndex);//末尾
		//②逆序子串
		
		for(int i=substring.length()-1;i>=0;i--){
			first+=substring.charAt(i);
		}
		return first+last;
	}

}
