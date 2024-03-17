package Java.lebin.Training.InterviewCases.characterString.KMP;

/**
 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 如果 needle 不是 haystack 的一部分，则返回  -1 。
 示例 1：
 输入：haystack = "sadbutsad", needle = "sad"
 输出：0
 解释："sad" 在下标 0 和 6 处匹配。
 第一个匹配项的下标是 0 ，所以返回 0 。
 示例 2：
 输入：haystack = "leetcode", needle = "leeto"
 输出：-1
 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
/*
其中n为文本串长度，m为模式串长度，在匹配的过程中，根据前缀表不断调整匹配的位置，匹配的过程是O(n)，
生成next数组，时间复杂度是O(m)。所以整个KMP算法的时间复杂度是O(n+m)的。
暴力的解法显而易见是O(n × m)，所以KMP在字符串匹配中极大地提高了搜索的效率。
 */
public class _28_找出字符串中第一个匹配项的下标_kmp {
	/**
	 * 基于窗口滑动的算法
	 * 时间复杂度：O(m*n)
	 * 空间复杂度：O(1)
	 * 注：n为haystack的长度，m为needle的长度
	 */
	//前缀表（不减一）
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		int[] next = new int[needle.length()];
		getNext(next, needle);

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
				j = next[j - 1];//遇到不等的情况，从next的j-1获得跳过的位置
			}
			if (needle.charAt(j) == haystack.charAt(i)){
				j++;
			}
			if (j == needle.length())
				return i - needle.length() + 1;//返回起始匹配到的位置
		}
		return -1;

	}
	//最长相等前后缀的计算
	private void getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			while (j > 0 && s.charAt(j) != s.charAt(i))//需要一直回跳
				j = next[j - 1];//取前边一位作为下标
			if (s.charAt(j) == s.charAt(i))
				j++;
			next[i] = j;
		}
	}
}
