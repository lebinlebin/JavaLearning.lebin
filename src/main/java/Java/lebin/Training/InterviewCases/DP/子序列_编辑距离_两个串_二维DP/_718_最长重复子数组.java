package Java.lebin.Training.InterviewCases.DP.子序列_编辑距离_两个串_二维DP;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
示例：
输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3, 2, 1] 。
 */

public class _718_最长重复子数组 {
/** 子数组就是连续子序列
 * 1. dp定义
 *      dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
 * 2. 递推公式
 *      当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;
 *      根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
 * 3. 初始化
 *      根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的！
 *      但dp[i][0] 和dp[0][j]要初始值，因为 为了方便递归公式dp[i][j] = dp[i - 1][j - 1] + 1;
 *       所以dp[i][0] 和dp[0][j]初始化为0。
 *      举个例子A[0]如果和B[0]相同的话，dp[1][1] = dp[0][0] + 1，只有dp[0][0]初始为0，正好符合递推公式逐步累加起来。
 * 4. 确定遍历顺序
 *      外层for循环遍历A，内层for循环遍历B。
 */
//    时间复杂度：O(n × m)，n 为A长度，m为B长度
//    空间复杂度：O(n × m)
public int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];

    for (int i = 1; i < nums1.length + 1; i++) {
        for (int j = 1; j < nums2.length + 1; j++) {
            if (nums1[i - 1] == nums2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
    }
    return result;
}
}
