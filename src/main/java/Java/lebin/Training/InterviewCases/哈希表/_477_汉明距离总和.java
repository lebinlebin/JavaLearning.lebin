package Java.lebin.Training.InterviewCases.哈希表;

/*
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间 汉明距离的总和 。

示例 1：
输入：nums = [4,14,2]
输出：6
解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6
示例 2：

输入：nums = [4,14,4]
输出：4
 */
//时间复杂度：O(n⋅L)。其中 n 是数组 nums 的长度，L=30
//空间复杂度：O(1)
public class _477_汉明距离总和 {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
