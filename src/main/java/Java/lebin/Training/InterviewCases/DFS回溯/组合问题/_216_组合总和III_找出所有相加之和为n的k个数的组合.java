package Java.lebin.Training.InterviewCases.DFS回溯.组合问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
//1. 递归函数的返回值以及参数
//2. 回溯函数终止条件
//3. 单层搜索的过程
// 在集合[1,2,3,4,5,6,7,8,9]中求 k（个数）, 和为n的组合
public class _216_组合总和III_找出所有相加之和为n的k个数的组合 {
    //时间复杂度: O(n * 2^n)
    //空间复杂度: O(n)
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        //找出所有相加之和为 n 的 k 个数的组合
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) { return; }
        //收集结果
        if (path.size() == k) {
            if (sum == targetSum)
                result.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }

        // 未进行剪枝的版本
        LinkedList<Integer> path2 = new LinkedList<>();
        List<List<Integer>> ans2 = new ArrayList<>();
        public List<List<Integer>> combinationSum3_2(int k, int n) {
            build(k, n, 1, 0);
            return ans2;
        }

        private void build(int k, int n, int startIndex, int sum) {

            if (sum > n) return;

            if (path2.size() > k) return;

            if (sum == n && path2.size() == k) {
                ans2.add(new ArrayList<>(path2));
                return;
            }

            for(int i = startIndex; i <= 9; i++) {
                path2.add(i);
                sum += i;
                build(k, n, i + 1, sum);
                sum -= i;
                path2.removeLast();
            }
        }
}
