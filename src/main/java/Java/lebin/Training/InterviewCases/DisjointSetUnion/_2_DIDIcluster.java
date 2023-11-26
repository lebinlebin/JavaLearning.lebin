//package Java.lebin.Training.InterviewCases.DisjointSetUnion;
//
//import Java.lebin.Training.DSA._10_HashMap.map.HashMap;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 滴滴二面代码题：
// *       输入：[1, 5, 7, 3, 9, 8, 10]
// *             [(1, 3), (5, 7), (7, 1), (9, 8)]
// *             -- 表示1和3有关，5和7有关，7和1有关，9和8有关。
// *       输出：[(1, 3, 7, 5), (8, 9), (10)]
// *
// * 思路:
// *  [(1, 3), (5, 7), (7, 1), (9, 8)]
// *   先把这个玩意合并了
// *   [(1,3,5,7), (9, 8)]
// *   Map(1->1,3->1,5->1,7->1,9->2,8->2)
// *   遍历     [1, 5, 7, 3, 9, 8, 10]
// *   Getindex  1 1  1 1  2 2  -1
// *
// */
//public class _2_DIDIcluster {
//
//    static int[] p;//parent
//    public static int[]  findCircleNum(int[] nums) {
//        int n = nums.length;
//        p = new int[n];
//        //初始化,首先自己就是一个集合
//        for(int i = 0; i < n; i++) {//n=3
//            p[i] = nums[i];
//        }
//        //初始化关系矩阵
//        int[][] matrix = new int[n][n];
//        HashMap<Integer,Integer> map = new HashMap<>();
////        [(1, 3), (5, 7), (7, 1), (9, 8)]
//        //[1, 5, 7, 3, 9, 8, 10]
//        // 0  1  2  3  4  5  6
//        for (int i = 0; i < n; i++) {
//            map.put(nums[i],i);//数值对应的下标
//        }
//
//
//        for(int i = 0; i < n; i++){
//                //判断是否有关系
//                //[(1, 3), (5, 7), (7, 1), (9, 8)]
//            map.get(nums[i]) =
//                if(matrix[i][j] == 1){
//                    int x = find(i);//找到i最终的parent
//                    int y = find(j);//找到j最终的parent
//                    if(x != y){//当两个parent不相等的时候，将y作为x的parent
//                        p[x] = y;//1
//                    }
//                }
//
//        }
//
////        List<List> res = new LinkedList<>();
////
////        /*
////         *   遍历     [1, 5, 7, 3, 9, 8, 10]
////         *   Getindex  1 1  1 1  2 2  -1
////         */
////        for(int i = 0; i < n; i++){
////            HashMap<Integer,Integer> pmap = new HashMap<>();
////            pmap.put(nums[i],p[i]);
////        }
//
//
//        return p;
//    }
//
//    /*
//     0   1  2
//    [1,  1, 2, 0]
//    */
//    public static int find(int x){//1
//        if(p[x] != x){
//            p[x] = find(p[x]);
//        }
//        return p[x];//2
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{1, 5, 7, 3, 9, 8, 10};
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(1,3);//[(1, 3), (5, 7), (7, 1), (9, 8)]
//        map.put(5,7);//[(1, 3), (5, 7), (7, 1), (9, 8)]
//        map.put(7,1);//[(1, 3), (5, 7), (7, 1), (9, 8)]
//        map.put(9,8);//[(1, 3), (5, 7), (7, 1), (9, 8)]
//        System.out.println(findCircleNum(nums,map));
//    }
//}
