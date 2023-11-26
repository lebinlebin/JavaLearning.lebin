package Java.lebin.Training.InterviewCases.characterString;

/**
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 */
//时间复杂度：O(n)
//空间复杂度：O(n)
public class 面试题_01_09_字符串轮转 {
	public static boolean isRevolving(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		// 这里还可以考虑使用KMP算法
		return (s1 + s1).contains(s2);
	}
	
//	public static void main(String[] args) {
//		System.out.println(isRevolving("cdab", "abdd"));
//	}
}
