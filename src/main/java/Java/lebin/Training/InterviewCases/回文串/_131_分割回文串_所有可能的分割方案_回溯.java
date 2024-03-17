package Java.lebin.Training.InterviewCases.回文串;
/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */

import java.util.LinkedList;
import java.util.List;

public class _131_分割回文串_所有可能的分割方案_回溯 {
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
}
