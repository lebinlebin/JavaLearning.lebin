package Java.lebin.Training.InterviewCases.DisjointSetUnion;
/**
 * 并查集是可以用数组实现的树形结构（二叉堆、优先级队列也是可以用数组实现的树形结构）
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 * 表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 *       1 2 3
     1 [[1,1,0],
     2  [1,1,0],
     3  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 */
public class _547_firendCircle_省份数量 {

    static int[] p;//parent
    public static int findCircleNum(int[][] M) {
        int n = M.length;//行数 3
        p = new int[n+1];//构建树数组,大小就是矩阵的行数 为什么要+1？
        //初始化,首先自己就是一个集合
        for(int i=0; i<n; i++) {//n=3
            p[i] = i;
        }

        /*
        i=0
         0   1  2
        [1,  1, 2, 0]

        i=1
         0   1  2
        [1,  1, 2, 0]


        i=2
         0   1  2
        [1,  1, 2, 0]
        */
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //M[0][0]=1 第0个同学和第0个同学有关系
                //M[0][1]=1 第0个同学和第1个同学有关系
                //M[0][2]=0 第0个同学和第2个同学有关系,不进入循环

                //M[1][0]=1 第1个同学和第0个同学有关系
                //M[1][1]=1 第1个同学和第1个同学有关系,不进入循环
                //M[1][2]=0 第1个同学和第2个同学有关系,不进入循环


                //M[2][0]=0 第2个同学和第0个同学有关系
                //M[2][1]=0 第2个同学和第1个同学有关系,不进入循环
                //M[2][2]=1 第2个同学和第2个同学有关系,不进入循环

                if(M[i][j] == 1){
                    int x = find(i);//找到i最终的parent
                    int y = find(j);//找到j最终的parent
                    if(x != y){//当两个parent不相等的时候，将y作为x的parent
                        p[x] = y;//1
                    }

                }
            }
        }

        /*
        i=2
         0   1  2
        [1,  1, 2, 0]
        */
        int res = 0;
        for(int i = 0; i < n; i++){
            if(p[i] == i)
                res++;
        }
        return res;
    }

    /*
     0   1  2
    [1,  1, 2, 0]
    */
    public static int find(int x){//1
        if(p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];//2
    }

    public static void main(String[] args) {
        int[][] martrix = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(martrix));
    }
}
