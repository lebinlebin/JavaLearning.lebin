package Java.lebin.Training.InterviewCases.SortArray;
/*
给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个非空子数组，且数组内部是连续的 。 分数 由每个子数组内的平均值的总和构成。
注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
示例 1:
输入: nums = [9,1,2,3,9], k = 3
输出: 20.00000
解释:
nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
我们也可以把 nums 分成[9, 1], [2], [3, 9].
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
示例 2:
输入: nums = [1,2,3,4,5,6,7], k = 4
输出: 20.50000
 */
//时间复杂度：O(k×n^2)，其中 k 是分组的最大子数组数目，n 是数组 nums 的长度。计算前缀和需要 O(n) 的时间，动态规划需要计算 O(k×n)个状态，每个状态的计算时间是 O(n)。
//空间复杂度：O(k×n) 或 O(n)，其中 k 是分组的最大子数组数目，n 是数组 nums 的长度。二维数组实现的空间复杂度是 O(k×n)，一维数组实现的空间复杂度是 O(n)。
public class _813_最大平均值和的分组 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
    //由于 dp[i][j]的计算只利用到 j−1的数据，因此也可以使用一维数组对 dp[i][j]进行计算，在计算过程中，要注意对 i 进行逆序遍历。

    public double largestSumOfAveragesOpt(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = n; i >= j; i--) {
                for (int x = j - 1; x < i; x++) {
                    dp[i] = Math.max(dp[i], dp[x] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n];
    }
}
