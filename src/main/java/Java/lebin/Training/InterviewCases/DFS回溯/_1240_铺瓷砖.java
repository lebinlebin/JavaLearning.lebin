package Java.lebin.Training.InterviewCases.DFS回溯;
/*
你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
假设正方形瓷砖的规格不限，边长都是整数。
请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 */
/*
回溯：考虑从矩形左上角(0,0)位置开始递归回溯,先用大的正方形尝试再用小的正方形。
 */
public class _1240_铺瓷砖 {
    int res;
    boolean[][] tiled;
    public int tilingRectangle(int n, int m) {
        if(n == m) return 1;
        tiled = new boolean[n][m];
        res = Math.max(m,n);//m* n
        dfs(0);
        return res;
    }

    //已经铺了count个，继续铺下去铺满
    void dfs(int count) {
        if (count >= res) return;// 剪枝
        int[] pos = findEmpty(tiled); // 地上没瓷砖的第一个位置
        if (pos[0] == -1 && pos[1] == -1) { // 已经铺完了所有地方，收集答案
            res = count;
            return;
        }
        if(count + 1 >= res) return;
        // 从大到小，开始尝试 4ms (从小到大 155ms)
        int maxLen = Math.min(tiled.length - pos[0], tiled[0].length - pos[1]);
        for (int len = maxLen; len >= 1; len--) {
            // 尝试用len*len的去填
            int row1 = pos[0], col1 = pos[1];
            int row2 = pos[0] + len-1, col2 = pos[1] + len-1;
            if(canFill(row1,col1,row2,col2)){
                //回溯
                fill(row1,col1,row2,col2,true);
                dfs(count+1);
                fill(row1,col1,row2,col2,false);
            }
        }
    }

    // 从上到下，从左到右找第一个没铺的位置
    private int[] findEmpty(boolean[][] tiled) {
        for (int i = 0; i < tiled.length; i++) {
            for (int j = 0; j < tiled[0].length; j++) {
                if (!tiled[i][j]) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    //是否全为false未填充
    boolean canFill(int row1,int col1,int row2,int col2){
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (tiled[i][j]) return false;
            }
        }
        return true;
    }
    //赋值整个正方形
    void fill(int row1,int col1,int row2,int col2,boolean f){
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                tiled[i][j] = f;
            }
        }
    }
}
