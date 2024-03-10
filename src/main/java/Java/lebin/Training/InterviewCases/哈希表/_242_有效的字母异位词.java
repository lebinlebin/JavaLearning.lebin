package Java.lebin.Training.InterviewCases.哈希表;

/**
 * 242. 有效的字母异位词
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 示例 2: 输入: s = "rat", t = "car" 输出: false
 */
//时间复杂度：O(n)，其中 n 为 s 的长度。
//空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。
public class _242_有效的字母异位词 {
	public boolean isAnagram(String s, String t) {
		int[] record = new int[26];

		for (int i = 0; i < s.length(); i++) {
			record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
		}

		for (int i = 0; i < t.length(); i++) {
			record[t.charAt(i) - 'a']--;
		}

		for (int count: record) {
			if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
				return false;
			}
		}
		return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
	}
}
