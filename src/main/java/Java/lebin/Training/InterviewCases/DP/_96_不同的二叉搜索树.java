package Java.lebin.Training.InterviewCases.DP;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class _96_不同的二叉搜索树 {
    /*
    1. dp定义
        dp[i] ： 1到i为节点组成的二叉搜索树的种树为dp[i]。
    2. 递推公式
        例子: dp[3]，就是 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
        元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量  因为是二叉搜索树，右边的一定比左边的大
        元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
        元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
        有2个元素的搜索树数量就是dp[2]。
        有1个元素的搜索树数量就是dp[1]。
        有0个元素的搜索树数量就是dp[0]。
        所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        ===> 在上面的分析中，其实已经看出其递推关系， dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
        j相当于是头结点的元素，从1遍历到i为止。
        所以递推公式：dp[i] += dp[j - 1] * dp[i - j]; ，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量 二叉搜索树的性质
    3. 初始化
        只需要初始化dp[0]就可以了，推导的基础，都是dp[0]。
        从定义上来讲，空节点也是一棵二叉树，所以初始化dp[0] = 1
    4. 确定遍历顺序
        首先一定是遍历节点数，从递归公式：dp[i] += dp[j - 1] * dp[i - j]可以看出，节点数为i的状态是依靠 i之前节点数的状态。
    */
//    时间复杂度：O(n^2)
//    空间复杂度：O(n)
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
