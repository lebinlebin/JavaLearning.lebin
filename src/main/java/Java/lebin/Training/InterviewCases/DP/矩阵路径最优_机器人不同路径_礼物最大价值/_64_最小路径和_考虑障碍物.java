package Java.lebin.Training.InterviewCases.DP.矩阵路径最优_机器人不同路径_礼物最大价值;

/**
 算法题：求从左上角到右下角的最小开销。给定一个二维数组arr[i][j]，数组中每个点表示经过该点的开销，
 求从左上角为起点，右下角为终点的最小开销，在每个点时只能往右或者往下走，同时中途可能会有障碍，
 即有些点不能走，obs[i][j]=1时表示(i, j)不能走。dp和dp状态压缩。
 */
public class _64_最小路径和_考虑障碍物 {
        public static int minPathSum(int[][] obstacleGrid, int[][] costGrid) {
            if (obstacleGrid == null || costGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0
                    || obstacleGrid.length != costGrid.length || obstacleGrid[0].length != costGrid[0].length) {
                throw new IllegalArgumentException("Grids must be non-null and have the same dimensions.");
            }

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            // 如果起点或终点是障碍物，则无法到达
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return -1; // 无法到达
            }

            // dp数组，dp[i][j]表示到达(i, j)位置的最小路径和
            int[][] dp = new int[m][n];

            // 初始化左上角的起点
            dp[0][0] = costGrid[0][0];

            // 初始化第一行
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[0][j] == 1) {
                    dp[0][j] = Integer.MAX_VALUE; // 障碍物，标记为不可达
                } else {
                    dp[0][j] = dp[0][j - 1] + costGrid[0][j];
                }
            }

            // 初始化第一列
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 1) {
                    dp[i][0] = Integer.MAX_VALUE; // 障碍物，标记为不可达
                } else {
                    dp[i][0] = dp[i - 1][0] + costGrid[i][0];
                }
            }

            // 填充剩余的dp数组
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = Integer.MAX_VALUE; // 障碍物，标记为不可达
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + costGrid[i][j];
                    }
                }
            }

            // 返回右下角的最小路径和，如果右下角是障碍物则返回-1
            return dp[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1][n - 1];
        }
        public static void main(String[] args) {
            int[][] obstacleGrid = {
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            };
            int[][] costGrid = {
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}
            };

            int minPathSum = minPathSum(obstacleGrid, costGrid);
            System.out.println("Minimum path sum: " + minPathSum); // 输出应为7，因为路径为(0,0)->(0,2)->(1,2)->(2,2)
        }
    }
