package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.List;

/**
 剑指 Offer 57 - II. 和为s的连续正数序列
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 示例 1：
 输入：target = 9
 输出：[[2,3,4],[4,5]]
 */
/*
双指针
用两个指针 l 和 r 表示当前枚举到的以 l 为起点到 r 的区间，sum 表示 [l,r] 的区间和，由求和公式可 O(1) 求得为 (l+r)×(r−l+1)/2，起始 l=1,r=2。
一共有三种情况：
如果 sum<target 则说明指针 r 还可以向右拓展使得 sum 增大，此时指针 r 向右移动，即 r+=1
如果 sum>target 则说明以 l 为起点不存在一个 r 使得 sum=target ，此时要枚举下一个起点，指针 l 向右移动，即 l+=1
如果 sum==target 则说明我们找到了以 l 为起点得合法解 [l,r]，我们需要将 [l,r] 的序列放进答案数组，且我们知道以 l 为起点的合法解最多只有一个，
所以需要枚举下一个起点，指针 l 向右移动，即 l+=1
终止条件即为 l>=r 的时候，这种情况的发生指针 r 移动到了target/2+1 的位置，导致l<r 的时候区间和始终大于 target。

复杂度分析
窗口只向右移动，左右边界最多移动 target/2次，所以整体时间复杂度为O(N)。
空间复杂度：O(1)。
 */
public class 剑指Offer57II和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }
}
