package Java.lebin.Training.InterviewCases.characterString;

/**
 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 示例 1：
 输入：strs = ["flower","flow","flight"]
 输出："fl"
 示例 2：
 输入：strs = ["dog","racecar","car"]
 输出：""
 解释：输入不存在公共前缀。
 */
/*
时间复杂度：O(mn)，其中  m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
空间复杂度：O(1)。使用的额外空间复杂度为常数。
 */
public class _14_最长公共前缀 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		int count = strs.length;
		for (int i = 1; i < count; i++) {
			prefix = longestCommonPrefix(prefix, strs[i]);
			if (prefix.length() == 0) {
				break;
			}
		}
		return prefix;
	}

	public String longestCommonPrefix(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < length && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}
}
