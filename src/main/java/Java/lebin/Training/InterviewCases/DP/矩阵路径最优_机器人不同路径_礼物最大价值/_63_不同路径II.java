package Java.lebin.Training.InterviewCases.DP.矩阵路径最优_机器人不同路径_礼物最大价值;
//有障碍物
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//网格中的障碍物和空位置分别用 1 和 0 来表示。
public class _63_不同路径II {
    /*
    时间复杂度：O(n × m)，n、m 分别为obstacleGrid 长度和宽度
    空间复杂度：O(n × m)
    本题是62.不同路径 (opens new window)的障碍版，整体思路大体一致。
    但就算是做过62.不同路径，在做本题也会有感觉遇到障碍无从下手。
    其实只要考虑到，遇到障碍dp[i][j]保持0就可以了。
    也有一些小细节，例如：初始化的部分，很容易忽略了障碍之后应该都是0的情况。
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}
