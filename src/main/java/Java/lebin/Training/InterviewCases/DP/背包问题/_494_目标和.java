package Java.lebin.Training.InterviewCases.DP.背包问题;
/*
494.目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数 S。
现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例：
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
 */
//todo:
// 加法一个集合和为left，减法一个集合和为right；left + right =sum(所有元素之和)；left-right=target；right=sum-left；
// left = target+ right = target + sum-left；==> 2left-sum = target;其中sum和target都是固定的数
// left = (target+sum)/2 例如: nums: [1, 1, 1, 1, 1], S: 3   taregt=3  sum=5,那么left=(3+5)/2=4，
// 对于不能整除的情况，说明不能凑成这样的一个加法集合，返回0
// 要凑一个4的容量的背包，组成加法集合的种数。就能找到题目要求的所有组合
//
/*
1. dp定义
    dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
    其实也可以使用二维dp数组来求解，dp[i][j]：使用 下标为[0, i]的nums[i]能够凑满j（包括j）这么大容量的包，有dp[i][j]种方法。
2. 递推公式
    有哪些来源可以推出dp[j]呢？
    只要搞到nums[i]，凑成dp[j]就有dp[j - nums[i]] 种方法。
    例如：dp[j]，j 为5，
    已经有一个1（nums[i]） 的话，有 dp[4]种方法 凑成 容量为5的背包。
    已经有一个2（nums[i]） 的话，有 dp[3]种方法 凑成 容量为5的背包。
    已经有一个3（nums[i]） 的话，有 dp[2]中方法 凑成 容量为5的背包
    已经有一个4（nums[i]） 的话，有 dp[1]中方法 凑成 容量为5的背包
    已经有一个5 （nums[i]）的话，有 dp[0]中方法 凑成 容量为5的背包
    那么凑整dp[5]有多少方法呢，也就是把 所有的 dp[j - nums[i]] 累加起来。
    所以求组合类问题的公式，都是类似这种：
        dp[j] += dp[j - nums[i]]
    这个公式在后面在讲解背包解决排列组合问题的时候还会用到！
3.初始化
    候dp[0] 一定要初始化为1，因为dp[0]是在公式中一切递推结果的起源，如果dp[0]是0的话，递推结果将都是0。
4. 遍历顺序
    对于01背包问题一维dp的遍历，nums放在外循环，target在内循环，且内循环倒序。
 */
public class _494_目标和 {
    //时间复杂度：O(n × m)，n为正数个数，m为背包容量
    //空间复杂度：O(m)，m为背包容量
    public int findTargetSumWays1D(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //如果target过大 sum将无法满足
        if ( target < 0 && sum < -target) return 0;

        if ((target + sum) % 2 != 0) return 0;

        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }

    public int findTargetSumWays2D(int[] nums, int target) {

        // 01背包应用之“有多少种不同的填满背包最大容量的方法“
        // 易于理解的二维数组解法及详细注释

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 注意nums[i] >= 0的题目条件，意味着sum也是所有nums[i]的绝对值之和
        // 这里保证了sum + target一定是大于等于零的，也就是left大于等于零（毕竟我们定义left大于right）
        if(sum < Math.abs(target)){
            return 0;
        }

        // 利用二元一次方程组将left用target和sum表示出来（替换掉right组合），详见代码随想录对此题的分析
        // 如果所求的left数组和为小数，则作为整数数组的nums里的任何元素自然是没有办法凑出这个小数的
        if((sum + target) % 2 != 0) {
            return 0;
        }

        int left = (sum + target) / 2;

        // dp[i][j]：遍历到数组第i个数时， left为j时的能装满背包的方法总数
        int[][] dp = new int[nums.length][left + 1];

        // 初始化最上行（dp[0][j])，当nums[0] == j时（注意nums[0]和j都一定是大于等于零的，因此不需要判断等于-j时的情况），有唯一一种取法可取到j，dp[0][j]此时等于1
        // 其他情况dp[0][j] = 0
        // java整数数组默认初始值为0
        for(int j = 0; j <= left; j++) {
            if(nums[0] == j) {
                dp[0][j] = 1;
            }
        }

        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

        // 递推公式分析：
        // 当nums[i] > j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        // nums[i] <= j时，num[i]可取可不取，因此方案数是dp[i - 1][j] + dp[i - 1][j - nums[i]]
        // 由递推公式可知，先遍历i或j都可
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= left; j++) {
                if(nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        // 打印dp数组
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j <= left; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println("");
        // }

        return dp[nums.length - 1][left];

    }
}
