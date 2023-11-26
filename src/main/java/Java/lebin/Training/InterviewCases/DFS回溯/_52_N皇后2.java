package Java.lebin.Training.InterviewCases.DFS回溯;
/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * 示例 1：
 *输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 */

import java.util.*;

public class _52_N皇后2 {
	Set<Integer> col = new HashSet<>();
	Set<Integer> pos = new HashSet<>();
	Set<Integer> neg = new HashSet<>();
	int res = 0;

	public int totalNQueens(int n) {
		backtrack(0, n);
		return res;
	}

	private void backtrack(int i, int n){
		if(i == n){
			res++;
			return;
		}
		for(int j = 0; j < n; j++){
			if(col.contains(j) || pos.contains(i - j) || neg.contains(i + j)){
				continue;
			}
			col.add(j);
			pos.add(i - j);
			neg.add(i + j);
			backtrack(i + 1, n);
			col.remove(j);
			pos.remove(i - j);
			neg.remove(i + j);
		}
	}
}
