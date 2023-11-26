package Java.lebin.Training.InterviewCases.MathOperator;

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
}