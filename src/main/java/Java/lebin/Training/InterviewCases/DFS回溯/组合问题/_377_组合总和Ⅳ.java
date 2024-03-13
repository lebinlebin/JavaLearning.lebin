package Java.lebin.Training.InterviewCases.DFS回溯.组合问题;
/*
377. 组合总和 Ⅳ
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
示例:
nums = [1, 2, 3]
target = 4
所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
todo：请注意，顺序不同的序列被视作不同的组合。这里其实求得是排列
因此输出为 7。
 */
/*
思路:
弄清什么是组合，什么是排列很重要。
组合不强调顺序，(1,5)和(5,1)是同一个组合。
排列强调顺序，(1,5)和(5,1)是两个不同的排列。
如果本题要把排列都列出来的话，只能使用回溯算法爆搜。
 */
public class _377_组合总和Ⅳ {
    /*
1. dp定义
    dp[i]: 凑成目标正整数为i的排列个数为dp[i]
2. 递推公式
    dp[i]（考虑nums[j]）可以由 dp[i - nums[j]]（不考虑nums[j]） 推导出来。
    因为只要得到nums[j]，排列个数dp[i - nums[j]]，就是dp[i]的一部分。
    求装满背包有几种方法，递推公式一般都是dp[i] += dp[i - nums[j]];
    递推公式: dp[i] += dp[i - nums[j]];
3. 初始化
    dp[0]要初始化为1，这样递归其他dp[i]的时候才会有数值基础。
4. 遍历顺序
    本题: target（背包）放在外循环，将nums（物品）放在内循环，内循环从前到后遍历。
    个数可以不限使用，说明这是一个完全背包。
    得到的集合是排列，说明需要考虑元素之间的顺序。
    如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    如果求排列数就是外层for遍历背包，内层for循环遍历物品。
*/
    //时间复杂度: O(target * n)，其中 n 为 nums 的长度
    //空间复杂度: O(target)
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
