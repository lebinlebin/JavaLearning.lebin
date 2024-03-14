package Java.lebin.Training.InterviewCases.SortArray.重复元素_没有出现的元素_只出现一次的元素;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 */
public class _287_寻找重复数 {
    //思路: 二分查找，找到mid，[0~mid]的数的个数应该就等于mid位置的数，否则重复的数就在[0~mid]范围内；相反就在[mid+1,n]内
    //时间复杂度：O(nlogn)，其中 n 为 nums 数组的长度。二分查找最多需要二分 O(logn) 次，每次判断的时候需要O(n) 遍历 nums 数组求解小于等于 mid 的数的个数，
    // 因此总时间复杂度为 O(nlogn)。
    //空间复杂度：O(1)。
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;//中间的数
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {//小于等于mid的数应该有mid个
                    cnt++;
                }
            }
            if (cnt <= mid) {//那么前mid个是没有重复的
                l = mid + 1;//在【mid+1，n】中去查找
            } else {//cnt > mid 范围就是在[0，mid-1]中
                r = mid - 1;
                ans = mid;
            }
        }//直到l=r+1循环终止，此时的mid就是要找的重复数
        return ans;
    }
}
