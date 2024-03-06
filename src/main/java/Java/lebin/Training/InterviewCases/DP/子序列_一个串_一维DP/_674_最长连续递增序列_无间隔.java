package Java.lebin.Training.InterviewCases.DP.子序列_一个串_一维DP;
/*
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
关键是: 连续递增!!!!
示例 1：
输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 */
public class _674_最长连续递增序列_无间隔 {
    /*
    1. 确定dp数组含义
        dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
    2. 递推公式
        如果 nums[i] > nums[i - 1]，dp[i] = dp[i - 1] + 1;
        因为本题要求连续递增子序列，所以就只要比较nums[i]与nums[i - 1]，而不用去比较nums[j]与nums[i] （j是在0到i之间遍历）。
        既然不用j了，那么也不用两层for循环，本题一层for循环就行，比较nums[i] 和 nums[i - 1]。
    3. dp数组如何初始化
        以下标i为结尾的连续递增的子序列长度最少也应该是1，即就是nums[i]这一个元素。
        所以dp[i]应该初始1;
    4. 确定遍历顺序
        从递推公式上可以看出， dp[i + 1]依赖dp[i]，所以一定是从前向后遍历。
     */
//    时间复杂度：O(n)
//    空间复杂度：O(n)
    /**
     * 1.dp[i] 代表当前下标最大连续值
     * 2.递推公式 if（nums[i+1]>nums[i]） dp[i+1] = dp[i]+1
     * 3.初始化 都为1
     * 4.遍历方向，从其那往后
     * 5.结果推导 。。。。
     */
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        //可以注意到，这里的 i 是从 0 开始，所以会出现和卡哥的C++ code有差异的地方，在一些地方會看到有 i + 1 的偏移。
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }

}
