package Java.lebin.Training.InterviewCases.DFS回溯.排列问题;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列有重复数字，需要进行合理的剪枝，去重。
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class _47_全排列II {
    boolean[] used;//与nums大小相同的数组，记录当前数字是否被用过了
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();//记录最终返回
        List<Integer> track = new ArrayList<Integer>();//记录一种排列数
        used = new boolean[nums.length];
        //对于有重复元素的全排列，需要进行排序。以便以后续的去重剪枝操作
        Arrays.sort(nums);
        backtrack(nums, res, 0, track);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> track) {
        //这里是通过idx控制终止条件的，也可以采用 track.length=nums.length作为终止条件
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(track));
            return;
        }

        //层内遍历
        for (int i = 0; i < nums.length; ++i) {
            //做剪枝操作，
            //当前元素被用过，那么跳过
            //当前元素的前一个元素与当前元素相同的情况下，前一个元素还没有被用过，那么
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            used[i] = true;

            backtrack(nums, res, idx + 1, track);
            used[i] = false;
            track.remove(idx);
        }
    }
}
