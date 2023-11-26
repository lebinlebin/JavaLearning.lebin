package Java.lebin.Training.StringMathArraySystemBigDecimal.EncapClass.string;

import java.util.Arrays;

import org.junit.Test;

/**
 * 此类用于演示String类的常见方法
 * @author liulebin
 * 
 * public int length()
public char charAt(int index)
public boolean equals(Object anObject)
public int compareTo(String anotherString)
public int indexOf(String s)
public int indexOf(String s ,int startpoint)
public int lastIndexOf(String s)
public int lastIndexOf(String s ,int startpoint)
public boolean startsWith(String prefix)
public boolean endsWith(String suffix)
public boolean regionMatches(int firstStart,String other,int otherStart ,int length)
public String substring(int startpoint)
public String substring(int start,int end)
pubic String replace(char oldChar,char newChar)
public String replaceAll(String old,String new)
public String trim()
public String concat(String str)
public boolean contains(CharSequence s)
public String[] split(String regex)

 *
 */
public class TestStringMethod1 {
	
	@Test
	public void test2() {
		
		String s = "E:.!!!JAVASE上课资料.课件";
		//方法10：
		//①substring 截取指定索引处之后(包含指定索引处的字符)的所有字符  >=startIndex
		String substring = s.substring(4);
		System.out.println(substring);
		//②substring
		String substring2 = s.substring(0, 3);
		System.out.println(substring2);
		
		
		//方法11：replace/replaceAll替换
//		s.replace(oldChar, newChar)
		String replaceAll = s.replaceAll("慕容复", "段誉");
		System.out.println(replaceAll);
		s=s.replace('王', '李');
		System.out.println(s);
		
		//方法12：trim 去掉前后空格
		String trim = s.trim();
		System.out.println(trim+"哈哈");
		
		
		//方法13：concat 拼接字符串
		
		String concat = s.concat("木婉清");
		System.out.println(concat);
		
		
		//方法14：contains 判断字符串中是否包含指定子串
		boolean contains = s.contains("阿朱");
		System.out.println(contains);
		
		
		//方法15：split 根据指定的字符进行拆分
		String[] split = s.split("\\.");
		
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		
		
		
		

	}
	@Test
	public void test1(){
		//创建了一个String对象
		String s = "www.baidu.com";
		
		//方法1：length获取字符串的字符个数
		//		System.out.println(s.length());
		//方法2：charAt获取指定索引处的字符，索引：0——length-1
		System.out.println(s.charAt(2));
		//方法3：equalsIgnoreCase 忽略大小写判断内容是否相等
		System.out.println(s.equals("中OHN"));
		System.out.println(s.equalsIgnoreCase("中OHN"));
		
		//方法4：compareTo 实现Comparable接口的抽象方法，用于比较两个字符串内容大小
		
		System.out.println("zhangscn".compareTo("zhangsa"));
		
		
		//方法5：indexOf 用于获取某字符或字符串第一次出现的索引，如果没找到，返回-1
		
		//jaohnabababc
		int index = s.indexOf("abc");
		System.out.println(index);
		
		//方法6：lastIndexOf 用于获取某字符或字符串最后一次出现的索引，如果没找到，返回-1
		int index2 = s.lastIndexOf('a');
		
		System.out.println(index2);
		
		//方法7：startsWith 用于判断字符串是否以xx开头
		System.out.println(s.startsWith("www"));
		
		//方法8：endsWith 用于判断字符串是否以xx结尾
		System.out.println(s.endsWith("www"));
		
		//方法9：regionMatchs 用于匹配两个字符串指定位置的子串是否一致
		//www.baidu.com
		boolean regionMatches = s.regionMatches(4, "baiducom", 0, 5);
		
		System.out.println(regionMatches);
		
		
	}
	
	//案例1：保存一个邮箱字符串，进行验证：长度>6并且里面包含@和.并且@在.的前面
	
	@Test
	public void exec1() {

		String s = "wergh@126.com";
		int index1 = s.indexOf('@');
		int index2 = s.indexOf('.');
		if(s.length()>6&& index1>-1&& index1<index2){
			System.out.println("邮箱合法");
		}else{
			System.out.println("邮箱不合法！");
		}
	}
	
	
	@Test
	public void exec2() {
		System.out.println(convertName("zhang_sAn_feng_zi"));
	}
	/**
	 * 功能：输入一个姓名 ，形式为zhang_san_feng，最终转换成 zhangSanFeng
	 * @param oldName 待格式的姓名
	 * @return 格式好的姓名
	 */

	public String convertName(String oldName){//zhang_san_feng
		
		//①分割字符串
		String[] split = oldName.split("_");
		//②遍历split数组
//		String s ="";
		for (int i = 0; i < split.length; i++) {
			if(i==0){
				
				split[i]=split[i].toLowerCase();
			}else{
				split[i]=split[i].substring(0, 1).toUpperCase().concat(split[i].substring(1).toLowerCase());
			}
//			s+=split[i];
		}
		
		return Arrays.toString(split);
		
		
	}

}
