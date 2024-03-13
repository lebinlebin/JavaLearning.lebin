package Java.lebin.Training.InterviewCases.DFS回溯.排列问题;

import java.util.Arrays;

/*
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

示例 1：
输入：n = 3, k = 3
输出："213"

示例 2：
输入：n = 4, k = 9
输出："2314"

示例 3：
输入：n = 3, k = 1
输出："123"
 */
/*
通过 计算剩余数字个数的阶乘数，一位一位选出第 k 个排列的数位。
根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的 叶子结点 的个数：
如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
 */

//时间复杂度：O({N^2})，时间复杂度不对，最坏是O(N^2)。最坏肯定是要找到第N！个，但是第1层你只需要比较N-1次，第2层比较N-2次，以此类推。
//空间复杂度：O(N)，nums、used、path 都与 N 等长，factorial 数组就 101010 个数，是常数级别的。
/*
这里递归次数为N，且在递归函数里的for循环里，只会发生一次递归（不符合条件的不递归，也就是剪枝），
for循环每次最多循环N遍（k=n! 就是这种情况），最少循环N-depth（depth为递归的深度，k=1就是这种情况），
所以最坏时间复杂度为：N+N+....+N=O(N的平方)，最好时间复杂度为：N+N-1+...+1=N*(N+1)/2=O(N的平方），
因此，时间复杂度应该是O(N的平方）才对吧。
 */
public class _60_排列序列_返回第k个排列 {
    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);
        // 查找全排列需要的布尔数组
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组
     */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
