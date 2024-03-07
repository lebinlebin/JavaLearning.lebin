package Java.lebin.Training.InterviewCases.characterString;

/**
 剑指 Offer 58 - II. 左旋转字符串
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 示例 1：
 输入: s = "abcdefg", k = 2
 输出: "cdefgab"
 示例 2：

 输入: s = "lrloseumgh", k = 6
 输出: "umghlrlose"
 */
public class _58_左旋转字符串 {
	/*
	时间复杂度: O(n)
	空间复杂度：O(1)
	 */
	public String reverseLeftWords(String s, int n) {
		return s.substring(n, s.length()) + s.substring(0, n);
	}
	/*
	 原地 局部反转+整体反转
	 */
	public String reverseLeftWords2(String s, int n) {
		char[] ch = s.toCharArray();
		int len = ch.length;
		reverse(ch,0,n-1);
		reverse(ch,n,len-1);
		reverse(ch,0,len-1);
		return new String(ch);
	}
	public void reverse(char[] ch,int start, int end){
		int count = (end-start)/2;
		for(int i =0;i<=count;i++){
			char temp = ch[start+i];
			ch[start+i] = ch[end-i];
			ch[end-i] = temp;
		}
	}
}
