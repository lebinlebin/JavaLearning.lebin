package Java.lebin.Training.InterviewCases.slidingWindow;
/*
给你一个二进制数组 nums ，你需要从中删掉一个元素。
请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
如果不存在这样的子数组，请返回 0 。

提示 1：
输入：nums = [1,1,0,1]
输出：3
解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
示例 2：

输入：nums = [0,1,1,1,0,1,1,0,1]
输出：5
解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
示例 3：

输入：nums = [1,1,1]
输出：2
解释：你必须要删除一个元素。
 */
public class _1493_删掉一个元素以后全为1的最长子数组 {
    public static int longestSubarray(int[] nums) {

        int len = nums.length;
        int left = 0;
        int right = 0;

        int ones = 0;

        int maxCount = 0;
        int res = 0;

        while (right < len) {
            if (nums[right] == 1) {
                ones++;
            }
            maxCount = Math.max(maxCount, ones);
            right++;
            // System.out.println(maxCount);
            while (right - left > maxCount + 1) {
                if (nums[left] == 1) {
                    ones--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res - 1;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 1, 0, 1};
        // int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        // int[] nums = {1, 1, 1};
        // int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        int[] nums = {0, 0, 0};
        int res = longestSubarray(nums);
        System.out.println(res);
    }
}
