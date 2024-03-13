package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;
/*
1035.不相交的线
我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
以这种方法绘制线条，并返回我们可以绘制的最大连线数。
示例 1：
输入：nums1 = [1,4,2],
     nums2 = [1,2,4]
输出：2
解释：可以画出两条不交叉的线，1和1相连，4和4相连
但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 */
/**
 * 本题说是求绘制的最大连线数，其实就是求两个字符串的最长公共子序列的长度！
 */
	/*
	1.dp定义
		dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j];
	2.递推公式
		如果text1[i - 1] 与 text2[j - 1]相同，dp[i][j] = dp[i - 1][j - 1] + 1;
		如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
		即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
	3. 确定遍历顺序
		i 从上向下；j 从左往右
	4. 初始化
		先看看dp[i][0]应该是多少呢？
		test1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;同理dp[0][j]也是0。
		其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0。
	 */
    //时间复杂度：O(mn)
    //空间复杂度：O(mn)
public class _1035_不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
