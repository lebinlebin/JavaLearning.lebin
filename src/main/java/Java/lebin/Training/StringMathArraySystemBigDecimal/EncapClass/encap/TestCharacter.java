package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.encap;
/**
 * 此类用于演示Character类的常见方法
 * @author liulebin
 *
 */
public class TestCharacter {
	
	public static void main(String[] args) {
		
		//判断是否是数字
		
		System.out.println(Character.isDigit('a'));
		
		//判断是否为大写
		System.out.println(Character.isUpperCase('a'));
		
		//判断是否为小写
		System.out.println(Character.isLowerCase('a'));
		
		//判断是否为字母
		System.out.println(Character.isLetter('a'));
		
		//判断是否为空格
		System.out.println(Character.isWhitespace('a'));
		
		//转换成大写
		
		System.out.println(Character.toUpperCase('a'));
		//转换成小写
		System.out.println(Character.toLowerCase('a'));
		
	}

}
