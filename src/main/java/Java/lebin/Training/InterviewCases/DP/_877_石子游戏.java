package Java.lebin.Training.InterviewCases.DP;
/*
Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
示例 1：
输入：piles = [5,3,4,5]
输出：true
解释：
Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
示例 2：
输入：piles = [3,7,2,3]
输出：true
提示：
2 <= piles.length <= 500
piles.length 是 偶数
1 <= piles[i] <= 500
sum(piles[i]) 是 奇数
 */
/*
定义二维数组 dp，其行数和列数都等于石子的堆数，
dp[i][j] 表示在下标范围 [i,j]中，当前玩家与另一个玩家的石子数量之差的最大值，注意当前玩家不一定是先手 Alice。
只有当 i≤j 时，剩下的石子堆才有意义，因此当 i>j 时，dp[i][j]=0
当 i=j时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有 0≤i<nums.length0，都有 dp[i][i]=piles[i]
当 i<j时，当前玩家可以选择取走 piles[i]或 piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。
在两种方案(取走 piles[i]或 piles[j])中，当前玩家会选择最优的方案，使得自己的石子数量最大化。
状态转移方程：
dp[i][j]=max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])
最后判断 dp[0][piles.length−1]的值，如果大于 0，Alice 赢得比赛，否则 Bob 赢得比赛。
 */
//时间复杂度：O(n^2)，其中 n 是数组的长度。需要计算每个子数组对应的 dp 的值，共有 n(n+1)/2 个子数组。
//空间复杂度：O(n)，其中 n 是数组的长度。空间复杂度取决于额外创建的数组 dp，如果不优化空间，则空间复杂度是O(n^2)，使用一维数组优化之后空间复杂度可以降至 O(n)。
public class _877_石子游戏 {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }
}
