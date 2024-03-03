package Java.lebin.Training.InterviewCases.DFS回溯;
/*
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
//时间复杂度：O(1)O(1)O(1)。数独共有 818181 个单元格，只需要对每个单元格遍历一次即可。
//空间复杂度：O(1)O(1)O(1)。由于数独的大小固定，因此哈希表的空间也是固定的。
public class _36_有效的数独 {
    //可以使用哈希表记录每一行、每一列和每一个小九宫格中，每个数字出现的次数。只需要遍历数独一次，在遍历的过程中更新哈希表中的计数，并判断是否满足有效的数独的条件即可。
    //由于数独中的数字范围是 1 到 9，因此可以使用数组代替哈希表进行计数。
    //如果遍历结束之后没有出现计数大于 1 的情况，则符合有效的数独的条件，返回 true
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
