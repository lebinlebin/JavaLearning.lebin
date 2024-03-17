package Java.lebin.Training.InterviewCases.DP.背包问题_零钱兑换_目标和_单词拆分;

import java.util.HashSet;
import java.util.Set;

/*
805. 数组的均值分割
给定你一个整数数组 nums
我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
如果可以完成则返回true ， 否则返回 false  。
注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。
示例 1:
输入: nums = [1,2,3,4,5,6,7,8]
输出: true
解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
示例 2:
输入: nums = [3,1]
输出: false
 */
/*
时间复杂度：O(n^2×sum(nums)))，其中 n 表示数组的长度，sum(nums)表示数组 nums 的和。
我们需要求出给定长度下所有可能的子集元素之和，数组的长度为 n，每种长度下子集的和最多有 sum(nums)个，
因此总的时间复杂度为 O(n^2×sum(nums))
空间复杂度：O(n×sum(nums)))。一共有 n 种长度的子集，每种长度的子集和最多有 sum(nums)个，因此需要的空间为 O(n×sum(nums)))。
 */
public class _805_数组的均值分割 {
    /*
   将数组的元素，分到两个数组AB中
   即从nums选取k个元素，放到A中，剩下的就给B
   要求avg(A)==avg(B),也等于原数组的平均值avg(nums)
   如果这个k存在
   sum(A)/k = sum(nums)/n
   即sum(A)*n = sum(nums)*k
   动态规划01背包问题
     */
    public boolean splitArraySameAverage(int[] nums) {
        //只有一个元素，不可能分到两个数组
        if (nums.length == 1) {
            return false;
        }

        int n = nums.length, m = n / 2;
        int sum = 0;
        //对sum求和
        for (int num : nums) {
            sum += num;
        }
        //sum(A)/k = sum(nums)/n
        //sum(A) = sum(nums)*k/n
        //因为nums 是整数数组，则sum(A)也是整数
        //如果k存在，则存在sum(nums)*k 也能被n整除
        //又因为分成两个数组，元素较少的数组，元素个数小于等于n/2
        //只判断较小的那个k
        boolean isPossible = false;
        for (int i = 1; i <= m; i++) {
            if (sum * i % n == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) {
            return false;
        }
        //前边分析将问题变成对sum(A)的检查
        //需要记录被选取的k个元素的和
        //定义dp[i]表示已遍历的元素中，选取i个元素，求和
        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashSet<Integer>();
        }
        //dp[0]表示无选择的元素
        dp[0].add(0);
        //遍历数组，每次检查一个元素
        //检查一下如果该元素被选中，加上该元素后的和是否满足条件
        for (int num : nums) {
            //对dp数组的遍历；对所有已经记录的元素和，再加上当前元素
            //本次处理后，会更新对应的dp[i]
            //如果这个i是递增的，那么后续dp[i-1]，会取到刚被更新，添加了当前元素的元素和
            //相当于多次添加了num，num被多次选取
            //这里不能递增，改成递减，避免重复计算num
            for (int i = m; i >= 1; i--) {
                for (int x : dp[i - 1]) {
                    int curr = x + num;
                    //如果该元素被选中，加上该元素后的和是否满足条件
                    //即sum(A)*n == sum(nums)*k
                    if (curr * n == sum * i) {
                        return true;
                    }
                    //将当前选取的i个元素和，记录下来
                    dp[i].add(curr);
                }
            }
        }
        return false;
    }
    //不剪枝
    public boolean splitArraySameAverage2(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, nsum = 0;
        for (int num : nums) nsum += num;

        Set<Integer>[] dp = new Set[n + 1]; //任意选择i个元素并求和，dp[i]表示的是所有i个元素的可能的和。
        for (int i = 0; i <=n; i++) dp[i] = new HashSet<Integer>();
        dp[0].add(0); //选择0个元素，和只可能是0

        for(int j = 0; j < n; j++){// 从左到右遍历数组nums，j表示当前遍历到的元素的下标
            int num = nums[j];
            for(int k = j + 1; k > 0;k--){ //前j+1个元素中，可以任意挑出j+1、j、j-1、j-2 …… 2、1个元素求和，用k表示可能的被挑出的元素个数。
                for(int x: dp[k - 1]){
                    // 此时，dp[k - 1]存储着前j+1个元素中，任意挑出k - 1个元素求并和，和的所有可能性。
                    // 对于一个可能的k-1个元素的和x，x+num必然是前j+1个元素中任意挑出k个元素得到的某个和；注意是”某个“。
                    //这里开始选择第k个数，也就是num
                    int sum = x + num;
                    dp[k].add(sum);
                    if(sum * n == nsum * k && k < n)return true;//直到找到满足这个条件的k个元素
                }
            }
            // 对于k < j + 1，此时，dp[k]存储着前j+1个元素中，任意选出k个元素求和，和的所有可能性。j继续向前推进。
        }
        return false;
    }
    //下面尝试进行初剪枝。因为A、B两个数组有对称性，可以只考虑n/2个元素的和。剪枝后，执行时间确实缩短了很多。
    public boolean splitArraySameAverage3(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n/2,  nsum = 0;
        for (int num : nums) nsum += num;

        Set<Integer>[] dp = new Set[n + 1]; //任意选择i个元素并求和，dp[i]表是所有可能的和。
        for (int i = 0; i <=n; i++) dp[i] = new HashSet<Integer>();
        dp[0].add(0); //选择0个元素，和只可能是0

        for(int j = 0; j < n; j++){// 从左到右遍历数组nums，j表示当前遍历到的元素的下标
            int num = nums[j];
            for(int k = Math.min(j + 1, m); k > 0;k--){ //前j+1个元素中，可以任意挑出j+1、j、j-1、j-2 …… 2、1个元素求和，用k表示可能的被挑出的元素个数。假设能找到符合题意的A、B两个数组，则根据对称性，这两个数组必然最多只含有一半元素，所以只需要从Math.min(j + 1, m)考察起，而不必从j+1开始考察。
                for(int x: dp[k - 1]){// 此时，dp[i - 1]存储着前j+1个元素中，任意挑出k - 1个元素求并和，和的所有可能性。对于一个可能的k-1个元素的和x，x+num必然是前j+1个元素中任意挑出k个元素得到的某个和；注意是”某个“。
                    int sum = x + num;
                    dp[k].add(sum);
                    if(sum * n == nsum * k)return true; //此时，某k个元素的平均值，恰好等于所有元素的平均值，并且k < n，这意味着某k个元素的平均值，等于剩下的n-k个元素的平均值，故返回之。
                }
            }
            // 对于k < j + 1，此时，dp[k]存储着前j+1个元素中，任意选出k个元素求和，和的所有可能性。j继续向前推进。
        }

        return false;
    }

}
