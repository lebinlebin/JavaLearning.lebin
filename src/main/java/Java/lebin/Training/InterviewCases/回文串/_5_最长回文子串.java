package Java.lebin.Training.InterviewCases.回文串;

/**
 *5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class _5_最长回文子串 {
	/**
	回文子串是要连续的，回文子序列可不是连续的！ 回文子串，回文子序列都是动态规划经典题目。
	 1. dp定义
	 	布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
	 2. 递推公式
	 	当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
	 	当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
	 		情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
	        情况二：下标i 与 j相差为1，例如aa，也是回文子串
	 		情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
	 		那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
	 3. 初始化  全部默认初始化为false
	 */

	public String longestPalindromeDp(String s) {
		if (s == null) return null;
		char[] cs = s.toCharArray();
		if (cs.length <= 1) return s;
		// 最长回文子串的长度（至少是1）
		int maxLen = 1;
		// 最长回文子串的开始索引
		int begin = 0;
		boolean[][] dp = new boolean[cs.length][cs.length];//对于boolean而言：默认值为false
		// 从下到上（i由大到小）
		for (int i = cs.length - 1; i >= 0; i--) {
			// 从左到右（j由小到大） j从i开始
			for (int j = i; j < cs.length; j++) {
				// cs[i, j]的长度
				int len = j - i + 1;
				if(len <= 2){
					dp[i][j] = (cs[i] == cs[j]);//情况一，二
				}else{
					//距离大于2
					dp[i][j] = (cs[i] == cs[j]) && dp[i + 1][j - 1];//i和j对应元素相等，而且i+1,j-1已经是回文串，那么这里一定是ture
				}

				if (dp[i][j] && len > maxLen) { // 说明cs[i, j]是回文子串
					maxLen = len;
					begin = i;
				}
			}
		}
		return new String(cs, begin, maxLen);
	}
}
