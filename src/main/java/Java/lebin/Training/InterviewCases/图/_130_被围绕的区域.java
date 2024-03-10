package Java.lebin.Training.InterviewCases.图;
/*
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
示例 2：

输入：board = [["X"]]
输出：[["X"]]
 */
//时间复杂度：O(rows∗cols)，其中 rows 和 cols 分别为矩阵的行数和列数，深度优先遍历过程中，每一个单元格至多只会被标记一次；
//空间复杂度：O(rows∗cols)，深度优先遍历最多使用的栈的开销为整个棋盘的大小。
public class _130_被围绕的区域 {
    public void solve(char[][] board) {
        // 特殊判断
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        if (cols == 0) {
            return;
        }

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // 第 1 步：把四周的 `0` 以及与 `0` 连通的 `0` 都设置成 `-`
        // 第 1 列和最后 1 列
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, rows, cols, board, directions);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, rows, cols, board, directions);
            }
        }
        // 第 1 行和最后 1 行
        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, rows, cols, board, directions);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(rows - 1, j, rows, cols, board, directions);
            }
        }

        // 第 2 步：遍历一次棋盘，
        // 1. 剩下的 0 就是被 X 包围的 0，
        // 2. - 是原来不能被包围的 0，恢复成 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
                // 已经是 X 的地方不用管
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private void dfs(int i, int j, int rows, int cols, char[][] board, int[][] directions) {
        if (inArea(i, j, rows, cols) && board[i][j] == 'O') {
            board[i][j] = '-';
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                dfs(newX, newY, rows, cols, board, directions);
            }
        }
    }
}
