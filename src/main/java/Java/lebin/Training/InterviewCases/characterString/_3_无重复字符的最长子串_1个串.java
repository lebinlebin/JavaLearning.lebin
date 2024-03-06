package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
//时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
//空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符）
//在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符，即 ∣Σ∣=128。
// 我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣ 个，因此空间复杂度为O(∣Σ∣)。
public class _3_无重复字符的最长子串_1个串 {

	public static int lengthOfLongestSubstring(String s) {
		//本题两个Map是统一的。只有一个string
		//当涉及两个string的时候，需要两个Map进行处理，这里只有一个，就只构建一个map就可以
		if (s == null||s.length() == 0) return 0;
		char[] chars = s.toCharArray();
		if (chars.length == 0) return 0;
		int left = 0;
		int right = 0;
		// 用来保存每一个字符上一次出现的位置
		Map<Character, Integer> window = new HashMap<>();
		int res = Integer.MIN_VALUE;
		/*
		思路:
		滑动窗口(计数窗口)构建:
		遇到一个字符就把字符放到window里面(hashMap),hashmap的value记录字符出现的次数:count++
		下一次遇见一个字符，到这个map中去get,如果>1说明窗口内该字符有重复，就要去缩减窗口。
		缩减窗口是从左边读取元素，然后从hashmap中对应的字符count--；
		缩减窗口的条件: hashmap中的count>1就进行缩减，直到窗口内的所有字符count==1
		当窗口的所有字符的count都为1，记录一次最长的不重复字符长度。选择最长的字符
		 */
		while(right<s.length()){
			char c1 = chars[right];
			window.put(c1,window.getOrDefault(c1,0)+1);
			right++;
			//符合条件的进行窗口缩减。  这里符合条件就是当窗口的 当前字符的count > 1
			while(window.get(c1) > 1 && left < right){
				char c2 = chars[left];
				// 移除window中的left字符，直到window.get(c1) ==1
				window.put(c2,window.get(c2)-1);
				left++;
			}
			res = Math.max(res,right-left);
		}
		return res;
	}


	public static String lengthOfLongestSubstring2(String s) {
		//本题两个Map是统一的。只有一个string
		//当涉及两个string的时候，需要两个Map进行处理，这里只有一个，就只构建一个map就可以
		if (s == null||s.length() == 0) return "";
		char[] chars = s.toCharArray();
		if (chars.length == 0) return "";
		int left = 0;
		int right = 0;
		// 用来保存每一个字符上一次出现的位置
		Map<Character, Integer> window = new HashMap<>();
		int res = Integer.MIN_VALUE;
		String resstr = "";
		/*
		思路:
		滑动窗口(计数窗口)构建:
		遇到一个字符就把字符放到window里面(hashMap),hashmap的value记录字符出现的次数:count++
		下一次遇见一个字符，到这个map中去get,如果>1说明窗口内该字符有重复，就要去缩减窗口。
		缩减窗口是从左边读取元素，然后从hashmap中对应的字符count--；
		缩减窗口的条件: hashmap中的count>1就进行缩减，直到窗口内的所有字符count==1
		当窗口的所有字符的count都为1，记录一次最长的不重复字符长度。选择最长的字符
		 */
		while(right<s.length()){
			char c1 = chars[right];
			window.put(c1,window.getOrDefault(c1,0)+1);
			right++;
			//符合条件的进行窗口缩减。  这里符合条件就是当窗口的 当前字符的count > 1
			while(window.get(c1) > 1 && left < right){
				char c2 = chars[left];
				// 移除window中的left字符，直到window.get(c1) ==1
				window.put(c2,window.get(c2)-1);
				left++;
			}
			int maxlen = right-left;
			if(maxlen > res){
				resstr = s.substring(left,right);
			}
//			res = Math.max(res,right-left);
		}
		return resstr;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("==================");
		String ss = lengthOfLongestSubstring2(s);
		System.out.println(ss);
		System.out.println("==================");
	}
}
