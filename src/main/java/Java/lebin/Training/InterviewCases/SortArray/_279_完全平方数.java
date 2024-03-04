package Java.lebin.Training.InterviewCases.SortArray;
/*
279.完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

示例 1：
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：
输入：n = 13
输出：2
解释：13 = 4 + 9
 */
//todo：完全平方数就是物品（可以无限件使用），凑个正整数n就是背包，问凑满这个背包最少有多少物品？
public class _279_完全平方数 {
    /*
1. dp定义
    dp[j]：和为j的完全平方数的最少数量为dp[j]
2. 递推公式
    dp[j] 可以由dp[j - i * i]推出， dp[j - i * i] + 1 便可以凑成dp[j]。
    我们要选择最小的dp[j]，所以递推公式：dp[j] = min(dp[j - i * i] + 1, dp[j]);
3. 初始化
    dp[0]表示 和为0的完全平方数的最小数量，那么dp[0]一定是0。
4. 遍历顺序
    外层for遍历背包，内层for遍历物品，还是外层for遍历物品，内层for遍历背包，都是可以的！
*/
//    时间复杂度: O(n * √n)
//    空间复杂度: O(n)
    // 版本一，先遍历物品, 再遍历背包
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //如果不想要寫for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
        //Arrays.fill(dp, Integer.MAX_VALUE);
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                //if (dp[j - i * i] != max) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                //}
                //不需要這個if statement，因爲在完全平方數這一題不會有"湊不成"的狀況發生（ 一定可以用"1"來組成任何一個n），故comment掉這個if statement。
            }
        }
        return dp[n];
    }

    // 版本二， 先遍历背包, 再遍历物品
    public int numSquares2(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        // 初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        // 当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历背包
        for (int j = 1; j <= n; j++) {
            // 遍历物品
            for (int i = 1; i * i <= j; i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
