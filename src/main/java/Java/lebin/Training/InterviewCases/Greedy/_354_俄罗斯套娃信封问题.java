package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
注意：不允许旋转信封。


示例 1：
输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出：3
解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
示例 2：
输入：envelopes = [[1,1],[1,1],[1,1]]
输出：1
 */
//时间复杂度为 O(NlogN)，因为排序和计算 LIS 各需要 O(NlogN)的时间。
//空间复杂度为 O(N)，因为计算 LIS 的函数中需要一个 top 数组。
public class _354_俄罗斯套娃信封问题 {
    /*
    先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。
    之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
    对于宽度 w 相同的数对，要对其高度 h 进行降序排序。
    逆序排序保证在 w 相同的数对中最多只选取一个。
     */
    // envelopes = [[w, h], [w, h]...]
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLISdp(height);
    }


    static int lengthOfLISdp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //dp定义是以当前位置i数字结尾的最长递增序列长度为dp[i].
        //dp数组与输入的数组的长度是相同的
        int[] dp = new int[nums.length];
        //base case lcs最小为1；max一定要赋值初始值为1
        int max = dp[0] = 1;
        //确定了basecase之后就要从下一个index开始遍历。dp数组为一维数组，那么遍历是一重遍历
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;//最小为1，dp数组按照1进行初始化
            //每个i都要遍历i之前的所有数组，进行比较大小
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;//没法接在后边
                //nums[i] > nums[j] 那么包含当前遍历元素nums[i]在内，可以组成一个新的递增序列，长度是dp[j] + 1
                dp[i] = Math.max(dp[i], dp[j] + 1);//可以接在后边组成新的lis
            }
            //把最大值记录下来
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /* 返回 nums 中 LIS 的长度 */
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
