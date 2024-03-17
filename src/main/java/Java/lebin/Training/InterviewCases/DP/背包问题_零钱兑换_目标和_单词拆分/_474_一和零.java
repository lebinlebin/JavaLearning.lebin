package Java.lebin.Training.InterviewCases.DP.背包问题_零钱兑换_目标和_单词拆分;
/*
474.一和零
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
示例 1：
输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。
{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 */
//todo:思路: m个0和n个1 可以理解为一种容器，装满这个容器，最多有多少个元素，我们就输出多少个。
// m个0和n个1就是我们容器的一个标签。容器就相当于一个背包，这个背包最多有m个0和n个1，问装满这个背包最多有多少个物品。

public class _474_一和零 {
/*
1. dp定义
    dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
2. 确定递推公式
    dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。
    dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。
    在遍历的过程中，取dp[i][j]的最大值。
    所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
3. 初始化
   01背包的dp数组初始化为0就可以。
    因为物品价值不会是负数，初始为0，保证递推的时候dp[i][j]不会被初始值覆盖。
4. 确定遍历顺序
    外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！
    那么本题也是，物品就是strs里的字符串，背包容量就是题目描述中的m和n。
 */

//时间复杂度: O(kmn)，k 为strs的长度
//空间复杂度: O(mn)
public int findMaxForm(String[] strs, int m, int n) {
    //dp[i][j]表示i个0和j个1时的最大子集
    int[][] dp = new int[m + 1][n + 1];
    int oneNum, zeroNum;
    for (String str : strs) {
        oneNum = 0;
        zeroNum = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                zeroNum++;
            } else {
                oneNum++;
            }
        }
        //倒序遍历
        for (int i = m; i >= zeroNum; i--) {
            for (int j = n; j >= oneNum; j--) {
                dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
            }
        }
    }
    return dp[m][n];
}
}
