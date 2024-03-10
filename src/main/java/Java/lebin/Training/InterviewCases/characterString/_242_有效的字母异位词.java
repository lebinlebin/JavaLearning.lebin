package Java.lebin.Training.InterviewCases.characterString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

	//方法一
	//把两个字符串都转换成字符数组以后，进行排序，然后逐位进行比较。
	public boolean isAnagram2(String s, String t) {
		boolean isAnagram = true;
		if (s.length() != t.length()) {
			isAnagram = false;
		} else {
			char[] sArray = s.toCharArray();
			Arrays.sort(sArray);
			char[] tArray = t.toCharArray();
			Arrays.sort(tArray);
			for (int i = 0; i < sArray.length; i++) {
				if (sArray[i] != tArray[i]) {
					isAnagram = false;
					break;
				}
			}
		}
		return isAnagram;
	}
	//放入一个 Map 中，只要后面有一个元素不出现在 Map 中，就退出，最后应该使得这个 Map 里所有元素的 value 值都为 0。
	public boolean isAnagram3(String s, String t) {
		boolean isAnagram = true;
		if (s.length() != t.length()) {
			isAnagram = false;
		} else {
			char[] sArray = s.toCharArray();
			Map<Character, Integer> map1 = new HashMap<>();
			for (char c : sArray) {
				if (map1.containsKey(c)) {
					map1.put(c, map1.get(c) + 1);
				} else {
					map1.put(c, 1);
				}
			}

			char[] tArray = t.toCharArray();
			for (char c : tArray) {
				if (map1.containsKey(c) && map1.get(c) >= 1) {
					map1.put(c, map1.get(c) - 1);
				} else {
					isAnagram = false;
					break;
				}
			}
		}
		return isAnagram;
	}
}
