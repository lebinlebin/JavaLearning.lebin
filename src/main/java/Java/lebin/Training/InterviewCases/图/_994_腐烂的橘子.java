package Java.lebin.Training.InterviewCases.图;

import java.util.ArrayDeque;

/*
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
//采用二叉树层序遍历的思想，腐烂时间就是遍历的层数，遍历过的直接置0就行，无需创建额外空间
//时间复杂度：O(nm),即进行一次广度优先搜索的时间
//空间复杂度：O(nm),需要额外的 dis 数组记录每个新鲜橘子被腐烂的最短时间，大小为 O(nm).
public class _994_腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        //1.定义2个int数组，2个一组来记录腐烂橘子的上下左右位置。腐烂橘子(0，0)
        //在矩阵中 上{-1,0}   下{1,0}  左{0,-1}   右{0,1}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int step = 0;//感染次数
        int flash = 0;//新鲜橘子数（后面用于判定是否为-1）

        int row = grid.length;//所给矩阵行
        int col = grid[0].length;//列

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //2.遍历矩阵 将所有的腐烂橘子入队，并且记录初始新鲜橘子数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    flash++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //3.遍历所有腐烂橘子，同时感染四周
        while (flash > 0 && !queue.isEmpty()) {//有橘子且队列不空
            step++;
            //队列中现有的所有腐烂橘子都要进行一次感染
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();//腐烂橘子
                for (int i = 0; i < 4; i++) {
                    //4个位置dx[i] dy[i]  ， xy 为要感染的橘子位置
                    int x = poll[0] + dx[i];//第x行
                    int y = poll[1] + dy[i];//第y列
                    if ((x >= 0 && x < row) && (y >= 0 && y < col) && grid[x][y] == 1) {
                        //xy不越界，并且要感染的地方是 新鲜橘子
                        grid[x][y] = 2;
                        //把被感染的橘子 入队
                        queue.offer(new int[]{x, y});
                        //新鲜橘子-1
                        flash--;
                    }
                }
            }

        }

        //感染完了之后如果还有新鲜橘子
        if (flash > 0) {
            return -1;
        } else {
            return step;
        }
    }
}
