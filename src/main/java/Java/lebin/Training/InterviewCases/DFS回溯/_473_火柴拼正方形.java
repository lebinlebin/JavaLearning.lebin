package Java.lebin.Training.InterviewCases.DFS回溯;

import java.util.Arrays;

/*
你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
如果你能使这个正方形，则返回 true ，否则返回 false 。
示例 1:
输入: matchsticks = [1,1,2,2,2]
输出: true
解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:
输入: matchsticks = [3,3,3,3,4]
输出: false
解释: 不能用所有火柴拼成一个正方形。
 */
/*
首先计算所有火柴的总长度 totalLen，如果 totalLen不是 4 的倍数，那么不可能拼成正方形，返回 false
当 totalLen是 4 的倍数时，每条边的边长为 len=totalLen/4，
用 edges来记录 4 条边已经放入的火柴总长度。对于第 index根火柴，尝试把它放入其中一条边内且满足放入后该边的火柴总长度不超过 len，
然后继续枚举第 index+1根火柴的放置情况，如果所有火柴都已经被放置，那么说明可以拼成正方形。
为了减少搜索量，需要对火柴长度从大到小进行排序。
 */
public class _473_火柴拼正方形 {
    //时间复杂度：O(4^n)，其中 n 是火柴的数目。每根火柴都可以选择放在 4 条边上，因此时间复杂度为 O(4^n).
    //空间复杂度：O(n)。递归栈需要占用 O(n)的空间。
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);//减少计算量

        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

}
