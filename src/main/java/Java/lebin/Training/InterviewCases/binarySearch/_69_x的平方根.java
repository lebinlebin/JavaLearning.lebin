package Java.lebin.Training.InterviewCases.binarySearch;
/*
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
示例 1：
输入：x = 4
输出：2
示例 2：
输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
//时间复杂度：O(logx)，即为二分查找需要的次数。
// 空间复杂度：O(1)。
public class _69_x的平方根 {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    /*
    返回的整数是有范围的，直觉上一个整数的平方根肯定不会超过它自己的一半，但是 0 和  1除外，因此我们可以在 1 到输入整数除以 2 这个范围里查找我们要找的平方根整数。0 单独判断一下就好。
     */
    //时间复杂度：O(logx)，每一次搜索的区间大小约为原来的1/2
    //空间复杂度：O(1)。
    public int mySqrt2(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }
}