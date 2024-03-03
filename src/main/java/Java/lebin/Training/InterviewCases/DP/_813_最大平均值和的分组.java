package Java.lebin.Training.InterviewCases.DP;
/*
给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个非空子数组，且数组内部是连续的 。 分数 由每个子数组内的平均值的总和构成。
注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
将 n 个元素划分为「最多」m 个连续段，最大化连续段的平均值之和。
示例 1:
输入: nums = [9,1,2,3,9], k = 3
输出: 20.00000
解释:
nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
我们也可以把 nums 分成[9, 1], [2], [3, 9].
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 */
/*
dp[i][j]表示 nums 在区间 [0,i−1]被切分成 j个子数组的最大平均值和，显然 i≥j(最多每个数字一个分组,不能为空)
两种情况：
1. 当 j=1时，dp[i][j] 是对应区间 [0,i−1]的平均值；
2. 当 j>1 时，此时枚举最后一个子数组的起点 x，其中 2≤x≤i，将区间 [0,i−1] 分成 [0,x−1]和 [x,i−1]两个部分，
其中 x≥j−1,
那么 dp[i][j]等于所有这些合法的切分方式的平均值和的最大值。
转移方程：
dp[i][j]=∑r=0,i−1 nums[r]/i,    j=1
dp[i][j]=max x≥j−1 {dp[x][j−1]+∑r=x,i−1 nums[r]/(i−x)},  j>1
前x个数分成j-1组就是dp[x][j−1] ，后边的分为1组，那么 dp[i][j] = dp[x][j−1] + ∑r=x,i−1 nums[r]/(i−x)
前x个数分成j-1组，因为一组至少一个数，所以x≥j-1.
枚举所有的切分x，取最大值。
假设数组 nums的长度为 n，那么 dp[n][k]表示数组 nums分成 k 个子数组后的最大平均值和，即最大分数。
用一个数组 prefix来保存数组 nums的前缀和，计算子数组的平均值。

 */
public class _813_最大平均值和的分组 {
    //时间复杂度：O(k×n^2)，其中 k 是分组的最大子数组数目，n 是数组 nums 的长度。计算前缀和需要 O(n)的时间，
    // 动态规划需要计算 O(k×n)个状态，每个状态的计算时间是 O(n)。
    //二维数组实现的空间复杂度是 O(k×n)，一维数组实现的空间复杂度是 O(n)。
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
    //由于 dp[i][j]的计算只利用到 j−1的数据，因此也可以使用一维数组对 dp[i][j] 进行计算，在计算过程中，要注意对 i 进行逆序遍历。
    public double largestSumOfAveragesOPT(int[] nums, int k) {
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
