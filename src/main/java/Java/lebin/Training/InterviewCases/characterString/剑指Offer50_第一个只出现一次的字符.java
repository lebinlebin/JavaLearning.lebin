package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashMap;
import java.util.Map;

/**
 剑指 Offer 50. 第一个只出现一次的字符
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 示例:
 s = "abaccdeff"
 返回 "b"
 s = ""
 返回 " "
 */
//时间复杂度：O(n)
//空间复杂度：O(1)
public class 剑指Offer50_第一个只出现一次的字符 {
	public char firstUniqChar(String s) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
		}
		for (int i = 0; i < s.length(); ++i) {
			if (frequency.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
		}
		return ' ';
	}
}
