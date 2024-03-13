package Java.lebin.Training.InterviewCases.DFS回溯.分割问题分割回文串复原IP;
/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s TODO：所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */

import java.util.*;

/*
复杂度分析：
时间复杂度：O(N*2^N)；这里 N 为输入字符串的长度，每一个位置可拆分，也可不拆分，尝试是否可以拆分的时间复杂度为 O(2^N)，
判断每一个子串是否是回文子串，时间复杂度为 O(N)；
空间复杂度：
如果不计算保存结果的空间，空间复杂度为O(N)，递归调用栈的高度为 N；
如果计算保存答案需要空间 2^N*N，这里为保守估计，实际情况不会这么多。空间复杂度为 O(2^N*N)
 */
public class _131_分割回文串_所有可能的分割方案 {
	List<List<String>> res = new LinkedList<>();
	List<String>  track = new LinkedList<>();

	public List<List<String>> partition(String s) {
		backtracking(s,0);
		return res;
	}
	void backtracking (String s, int startIndex) {
		// 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
		//这里一定是 >= s.length()
		if (startIndex >= s.length()) {
			res.add(new LinkedList(track));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			//做选择
			if (isPalindrome(s, startIndex, i)) {   // 是回文子串
				// 获取[startIndex,i]在s中的子串
				String str = s.substring(startIndex, i+1);
				track.add(str);
			} else {                                // 不是回文，跳过
				continue;
			}
			//回溯
			backtracking(s,i + 1); // 寻找i+1为起始位置的子串
			//撤销选择
			track.remove(track.size()-1); // 回溯过程，弹出本次已经填在的子串
		}

	}

	boolean isPalindrome(String s, int start, int end) {
		char[] ss = s.toCharArray();
		for (int i = start, j = end; i < j; i++, j--) {
			if (ss[i] != ss[j]) {
				return false;
			}
		}
		return true;
	}

	/*
	回溯的优化（使用动态规划得到所有子串是否是回文）
	 */
	/*
	复杂度分析：
	时间复杂度：O(2^N)；这里 N 为输入字符串的长度，每一个位置可拆分，也可不拆分，尝试是否可以拆分的时间复杂度为 O(2^N)，
	动态规划得到所有子串是否为回文子串的时间复杂度为 O(N^2)，所以总的时间复杂度为 O(N^2+2^N)=O(2^N)；
	空间复杂度：
	如果不计算保存结果的空间，动态规划表格的大小为N^2 ，递归调用栈的高度为 N，空间复杂度为 O(N^2 + N) = O(N)。
	如果计算保存答案需要空间 2^N×N，这里 2^N 为保守估计，实际情况不会这么多。
	空间复杂度为 O(2^N×N+N^2+N)=O(2^N×N)
	 */
	public List<List<String>> partition2(String s) {
		int len = s.length();
		List<List<String>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}

		char[] charArray = s.toCharArray();
		// 预处理
		// 状态：dp[i][j] 表示 s[i][j] 是否是回文
		boolean[][] dp = new boolean[len][len];
		// 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
		for (int right = 0; right < len; right++) {
			// 注意：left <= right 取等号表示 1 个字符的时候也需要判断
			for (int left = 0; left <= right; left++) {
				if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
					dp[left][right] = true;
				}
			}
		}

		Deque<String> stack = new ArrayDeque<>();
		dfs(s, 0, len, dp, stack, res);
		return res;
	}

	private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
		if (index == len) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = index; i < len; i++) {
			if (dp[index][i]) {
				path.addLast(s.substring(index, i + 1));
				dfs(s, i + 1, len, dp, path, res);
				path.removeLast();
			}
		}
	}
}
