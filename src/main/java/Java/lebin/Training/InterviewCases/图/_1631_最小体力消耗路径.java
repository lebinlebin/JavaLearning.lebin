package Java.lebin.Training.InterviewCases.图;

import java.util.LinkedList;
import java.util.Queue;

/*
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
请你返回从左上角走到右下角的最小 体力消耗值 。
 */
/*
是否存在一条从左上角到右下角的路径，其经过的所有边权的最大值不超过 x？
根据提示可以先将输入数组转换为图结构，每个[i][j]对应一个点，相邻节点的权重则是这两个相邻节点的值的差的绝对值，这样我们的目的就是找到一个k值，使得k尽量小的情况下能够满足从出发点到达右下角。因此 k从小到大，但是使用二分确定k值。
首先将二维数组转为图节点，将位置(i,j)进行编号，常用方法是位置(i, j)对应编号为 ixn+j,n为列数。实现mn的数组对应到[0, mn)范围内的整数。
假如使用BFS，给定一个k值，判断不超过k的情况下能不能搜索到一条从左上角到右下角的路径，因为我们对k进行二分查找，所以需要确定二分范围，每个格子高度范围在 1<=h<=10^6,所以在该范围内进行二分。
 */
//广度优先搜索 用队列
//深度度优先搜索 用栈
public class _1631_最小体力消耗路径 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(new int[]{nx, ny});
                        seen[nx * n + ny] = true;
                    }
                }
            }

            if (seen[m * n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
