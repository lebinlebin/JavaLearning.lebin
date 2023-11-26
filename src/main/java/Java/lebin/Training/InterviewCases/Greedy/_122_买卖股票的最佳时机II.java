package Java.lebin.Training.InterviewCases.Greedy;
/**
 * 不限制交易次数。k==无穷大
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
//区别是本题股票可以买卖多次了（注意只有一只股票，所以再次购买前要出售掉之前的股票）
/*
如果想到其实最终利润是可以分解的，那么本题就很容易了！
如何分解呢？
假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]。
相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
此时就是把利润分解为每天为单位的维度，而不是从 0 天到第 3 天整体去考虑！
那么根据 prices 可以得到每天的利润序列：(prices[i] - prices[i - 1]).....(prices[1] - prices[0])。

局部最优：收集每天的正利润，
全局最优：求得最大利润。
     */
public class _122_买卖股票的最佳时机II {
    /*
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
