package Java.lebin.Training.InterviewCases.SortArray;

import java.math.BigDecimal;
import java.util.Arrays;

/*
给你一个整数数组 nums 和一个整数 target 。
请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
由于答案可能很大，请将结果对 109 + 7 取余后返回。
示例 1：
输入：nums = [3,5,6,7], target = 9
输出：4
解释：有 4 个子序列满足该条件。
[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)
示例 2：
输入：nums = [3,3,6,8], target = 10
输出：6
解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
示例 3：

输入：nums = [2,3,3,4,6,7], target = 12
输出：61
解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
有效序列总数为（63 - 2 = 61）
 */
//时间复杂度：O(nlogn)
//空间复杂度：O(n)
/*
第一步，若 num1+num5<=targer，这里num1和num5是一对最小值和最大值,output=output+2^4
第二步，双指针向内移动，left=left+1 -> num2+num5>target -> right=right-1 -> num2+num4<=target, 这里num2和num4 是一对最小值和最大值， output=output+2^2
如此迭代至 left>right 的时候，即可结束。
 */
public class _1498_满足条件的子序列数目 {
    //java求幂会溢出所以用了 BigDecimal，超时了
    private final static int MOD = (int)1e9+7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] * 2 > target) return 0;
        int left = 0, right = nums.length-1;
        BigDecimal res = new BigDecimal("0");
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = res.add(new BigDecimal(2).pow(right-left));     // res += pow(2,r-l)
                res = res.divideAndRemainder(new BigDecimal(MOD))[1]; // res %= MOD
                left += 1;
            } else {
                right -= 1;
            }
        }
        return res.intValue() % MOD;
    }
    //所以提前对幂进行求模预处理(或提前算好打表)，减少计算范围 （AC）排序 + 预处理 + 双指针：
    private final static int MOD2 = (int)1e9+7;
    public int numSubseq2(int[] nums, int target) {
        int MOD2 = (int)1e9+7;
        int n = nums.length;
        // 预处理2的n次方
        int[] pow2arr = new int[n];
        pow2arr[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2arr[i] = (pow2arr[i - 1] << 1) % MOD2;
        }

        Arrays.sort(nums);
        if (nums[0] * 2 > target) return 0;
        int left = 0, right = n-1;
        long res = 0;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res += pow2arr[right-left] % MOD2;
                left += 1;
            } else {
                right -= 1;
            }
        }
        return (int) (res % MOD2); // 注意这个 MOD 要放在括号里...
    }
}

//python 排序+双指针
//class Solution:
//    def numSubseq(self, nums: List[int], target: int) -> int:
//    nums.sort()
//    if nums[0] * 2 > target:
//    return 0
//
//    left = 0
//    right = len(nums) - 1
//    res = 0
//    while left <= right:
//    if nums[left] + nums[right] <= target:
//    res += 2**(right-left)
//    left += 1
//    else:
//    right -= 1
//    return res%(10**9+7)
