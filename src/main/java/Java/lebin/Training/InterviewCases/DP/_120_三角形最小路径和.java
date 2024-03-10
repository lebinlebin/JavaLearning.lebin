package Java.lebin.Training.InterviewCases.DP;

import java.util.ArrayList;
import java.util.List;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：
输入：triangle = [[-10]]
输出：-10

 */
public class _120_三角形最小路径和 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) {
            return 0;
        }
        // 注意：这里 len + 1 是为了防止越界
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            // 每一步观察是不是我们想要的，这是调试的重要方法
            // System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
    private static List<Integer> generateIntegerList(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        return arr;
    }
    public static void main(String[] args) {

        List<Integer> step1 = generateIntegerList(new int[]{2});
        List<Integer> step2 = generateIntegerList(new int[]{3, 4});
        List<Integer> step3 = generateIntegerList(new int[]{6, 5, 7});
        List<Integer> step4 = generateIntegerList(new int[]{4, 1, 8, 3});


        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(step1);
        triangle.add(step2);
        triangle.add(step3);
        triangle.add(step4);
        int minimumTotal = minimumTotal(triangle);
        System.out.println(minimumTotal);
    }



}
