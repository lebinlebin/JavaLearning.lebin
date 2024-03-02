package Java.lebin.Training.InterviewCases.characterString;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 示例 1：
 * 输入: s1 = "ab"  s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
//时间复杂度：O(n+m+∣Σ∣)，其中 n 是字符串 s1 的长度，m 是字符串 s2 的长度，Σ 是字符集，这道题中的字符集是小写字母，∣Σ∣=26。
//空间复杂度：O(∣Σ∣)。
public class _567_字符串的排列 {
	public boolean checkInclusion(String s1, String s2) {
			int groudtruthLen = s1.length(), baseStrLen = s2.length();
			if (groudtruthLen > baseStrLen) {
				return false;
			}

			int[] groudtruth = new int[26];//全部都是字符，26个字母就覆盖所有了
			int[] window = new int[26];

			for (int i = 0; i < groudtruthLen; i++) {
				groudtruth[s1.charAt(i) - 'a']++;
				window[s2.charAt(i) - 'a']++;
			}

			//第一次比较。这样for循环里面i就可以从下一个窗口开始了
			if (Arrays.equals(groudtruth, window)) {
				return true;
			}

			//循环遍历
			for (int i = groudtruthLen; i < baseStrLen; i++) {
				window[s2.charAt(i) - 'a']++;
				/*
				  滑动窗口每次进来一个单词，将进来的单词在window++，将移动出窗口的单词--
				   0 1 2 3
				  [][][][]
				  -----
				    ------
				  比如滑动窗口长度为3，当前i的位置正好为groudtruthLen=3
				  那么index=0的位置移动出窗口，index=3的位置移动入窗口。
				  通过i推断移除窗口的index为： i-groudtruthLen
				 */
				window[s2.charAt(i - groudtruthLen) - 'a']--;
				if (Arrays.equals(groudtruth, window)) {
					return true;
				}
			}
			return false;
	}
}
