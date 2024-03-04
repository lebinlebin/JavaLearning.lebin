package Java.lebin.Training.InterviewCases.DFS回溯;

/**
 剑指 Offer 12. 矩阵中的路径
 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 如果 word 存在于网格中，返回 true ；否则，返回 false 。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

 示例 1：
 输入：board =
 [["A","B","C","E"],
 ["S","F","C","S"],
 ["A","D","E","E"]], word = "ABCCED"
 输出：true
 示例 2：
 输入：board =
 [["a","b"],
 ["c","d"]],
 word = "abcd"
 输出：false
 */
public class _79_单词搜索_矩阵中的路径 {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		char[] chars = word.toCharArray();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
				// 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
				if (dfs(board, chars, visited, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
    //                                                                                  start记录匹配到字符串的第哪个位置。直到字符串的长度
	private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| chars[start] != board[i][j] || visited[i][j]) {
			return false;
		}

		//返回结果。即只要能到达目标字符串的最后一位就可以返回true
		if (start == chars.length - 1) {
			return true;
		}

		visited[i][j] = true;
		boolean ans = false;
		ans = dfs(board, chars, visited, i + 1, j, start + 1)
				|| dfs(board, chars, visited, i - 1, j, start + 1)
				|| dfs(board, chars, visited, i, j + 1, start + 1)
				|| dfs(board, chars, visited, i, j - 1, start + 1);
		visited[i][j] = false;//撤销选择
		return ans;
	}
}

