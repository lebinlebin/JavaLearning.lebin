package Java.lebin.Training.InterviewCases.DP.背包问题_零钱兑换_目标和_单词拆分;

import java.util.HashSet;
import java.util.List;

/*
139.单词拆分
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

 */
//todo：单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。
// 拆分时可以重复使用字典中的单词，说明就是一个完全背包！
public class _139_单词拆分 {
    /*
1. dp定义
    dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
2. 递推公式
    如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
    所以递推公式是: if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
3. 初始化
    从递推公式中可以看出，dp[i] 的状态依靠 dp[j]是否为true，那么dp[0]就是递推的根基，dp[0]一定要为true，否则递推下去后面都都是false了。
4. 遍历顺序
    题目中说是拆分为一个或多个在字典中出现的单词，所以这是完全背包。
    本题其实我们求的是排列数 因此 先遍历 背包，再遍历物品。
    还要讨论两层for循环的前后顺序。本题其实我们求的是排列数
    如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     */
    //时间复杂度：O(n^3)，因为substr返回子串的副本是O(n)的复杂度（这里的n是substring的长度）
    //空间复杂度：O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
