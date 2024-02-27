package Java.lebin.Training.InterviewCases.图;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 */
/*
本题思路，是用遇到一个没有遍历过的节点陆地，计数器就加一，然后把该节点陆地所能遍历到的陆地都标记上。
在遇到标记过的陆地节点和海洋节点的时候直接跳过。 这样计数器就是最终岛屿的数量。
 */
public class _200_岛屿数量 {
    boolean[][] visited;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    //将这片岛屿上的所有陆地都访问到
    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];//x
            int cury = cur[1];//y
            for(int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][1];
                int nexty = cury + dir[i][0];
                if(nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;// 越界了，直接跳过
                if(!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                    queue.offer(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true; //只要加入队列就标记为访问
                }
            }
        }
    }



    // 版本二 DFS
    boolean[][] visited2;
    int[][] dir2 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands2(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited2 = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited2[i][j] && grid[i][j] == '1') {
                        result++; // 遇到没访问过的陆地，+1
                        dfs(grid, visited2, i, j); // 将与其链接的陆地都标记上 true
                    }
                }
            }
            return result;
        }

    void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if (visited[x][y] || grid[x][y] == '0') return; // 终止条件：访问过的节点 或者 遇到海水
        visited[x][y] = true; // 标记访问过
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir2[i][0];
            int nexty = y + dir2[i][1];
            if (nextx < 0 || nextx >= grid.length|| nexty < 0 || nexty >= grid[0].length) continue;  // 越界了，直接跳过
            dfs(grid, visited, nextx, nexty);
        }
    }

}
