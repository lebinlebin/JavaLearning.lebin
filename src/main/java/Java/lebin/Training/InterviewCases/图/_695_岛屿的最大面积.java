package Java.lebin.Training.InterviewCases.图;
/*
给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class _695_岛屿的最大面积 {
    //深度优先搜索
    /*
    我们想知道网格中每个连通形状的面积，然后取最大值。
    如果我们在一个土地上，以 4 个方向探索与之相连的每一个土地（以及与这些土地相连的土地），那么探索过的土地总数将是该连通形状的面积。
    为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 0。这样我们就不会多次访问同一土地。
     */
    //时间复杂度：O(m×n)。其中 m 是给定网格中的行数，n 是列数。我们访问每个网格最多一次。
    //空间复杂度：O(m×n)，递归的深度最大可能是整个网格的大小，因此最大可能使用 O(m×n) 的栈空间。
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = cur_i + di[index], next_j = cur_j + dj[index];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }
}
