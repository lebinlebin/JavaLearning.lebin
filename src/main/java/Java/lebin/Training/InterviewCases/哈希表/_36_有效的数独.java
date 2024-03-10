package Java.lebin.Training.InterviewCases.哈希表;
/*
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

注意：
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。
 */
public class _36_有效的数独 {
    //方法：布尔数组（哈希表）
    //参考代码 1：box 二维表格，重点理解 int boardIndex = (i / 3) * 3 + j / 3; 这行代码。
    // 知识点：哈希表，空间换时间

    public boolean isValidSudoku(char[][] board) {
        // 设置成为 10 是为了照顾到数字 9 的情况（下标 9 数字需要到 10）
        // 第 1 维表示行的下标
        boolean[][] row = new boolean[9][10];
        // 第 1 维表示列的下标
        boolean[][] col = new boolean[9][10];
        // 第 1 维表示 board 的下标
        boolean[][] box = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 只验证数字，因此 . 跳过
                if (board[i][j] == '.') {
                    continue;
                }

                // 提取出数字
                int num = board[i][j] - '0';
                // 重点：计算在第几格
                int boardIndex =  (i / 3) * 3 + j / 3;

                // 如果发现冲突，直接返回 false
                if (row[i][num] || col[j][num] || box[boardIndex][num]) {
                    return false;
                }

                // 然后占住位置
                row[i][num] = true;
                col[j][num] = true;
                box[boardIndex][num] = true;
            }
        }
        return true;
    }
}
