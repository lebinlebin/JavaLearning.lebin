package Java.lebin.Training.InterviewCases.DFS回溯.子集问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**90. 子集 II
 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 示例 1：

 输入：nums = [1,2,2]
 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 示例 2：
 输入：nums = [0]
 输出：[[],[0]]

 */
public class _90_子集2_含重复元素 {
    //时间复杂度: O(n * 2^n) 整棵树的结点个数最多2^N个；
    //空间复杂度: O(N×2^N)，保存子集需要长度为2^N 的列表，每一个子集的元素最多长度为N。
    private List<List<Integer>> ans;
    private List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        // 首先排序，让相同的两个元素排到一起去，便于去重
        Arrays.sort(nums);
        int n = nums.length;
        // 使用 visited 数组来记录哪一个元素在当前路径中被使用了
        boolean[] used = new boolean[n];
        // 开始回溯
        backtrace(nums, 0, used, n);
        return ans;
    }

    private void backtrace(int[] nums, int start, boolean[] used, int n) {
        // 首先加入当前路径
        ans.add(new ArrayList<>(path));
        // 从 start 开始遍历每一个元素，尝试加入路径中
        for (int i = start; i < n; ++i) {
            // 如果当前元素和前一个元素相同，而且前一个元素没有被访问，说明前一个相同的元素在当前层已经被用过了
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            // 记录下来，用过了当前的元素
            used[i] = true;
            path.add(nums[i]); // 放到路径中
            backtrace(nums, i + 1, used, n); // 向下一个递归
            used[i] = false; // 回溯
            path.remove(path.size() - 1);
        }
    }
}
