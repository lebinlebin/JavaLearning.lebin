package Java.lebin.Training.InterviewCases.矩阵;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid =
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class _64_最小路径和 {
//时间复杂度：O(mn)
//空间复杂度：O(mn)
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        //第0行
        for(int j=1; j<col; j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        //第0列
        for(int i=1;i<row;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //从上边走过来还是从左边走过来，取最小的
                dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
