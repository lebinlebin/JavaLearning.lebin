package Java.lebin.Training.InterviewCases.binarySearch;
/*
已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
给你一个 todo 可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
你必须尽可能减少整个过程的操作步骤。
示例 1：
输入：nums = [1,3,5]
输出：1
示例 2：
输入：nums = [2,2,2,0,1]
输出：0
 */
/*
这道题是 寻找旋转排序数组中的最小值 的延伸题目。
允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
理解题意
其实重点和关键字题目已经标注出来了，有序数组「旋转一次」得到的数组是「旋转有序数组」；
有序数组有可能存在 重复 值。
思路分析
虽然不是严格意义上的有序数组，但依然可以使用「二分查找」，可以认为「旋转有序数组」是 部分有序。只要是一次可以排除一半，都可以用「二分查找」。那么如何使用二分法呢？我们很自然会想到 使用边界的值和中间位置的值进行比较。
方法一：二分法
注意：这里的说是「中间数」，即 位于中间的那个数，不是数学意义上的中位数。
可以分为以下两种情况：中间数与左边界比较、中间数与右边界比较
 */
public class _154_寻找旋转排序数组中的最小值2 {
    public int findMin1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                assert nums[mid] == nums[right];
                right--;
            }
        }
        return nums[left];
    }

//    方法二：分治法
//    分治法将原问题划分成若干与原问题同结构且规模更小的子问题，等到这些子问题解决了以后，原问题也得到了解决。
    public int findMin2(int[] nums) {
        // 在 nums[left..right] 里查找目标元素
        return findMin3(nums, 0, nums.length - 1);
    }

    private int findMin3(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        if (nums[mid] == nums[right]) {
            return findMin3(nums, left, right - 1);
        } else if (nums[mid] < nums[right]) {
            // 下一轮搜索区间是 [left..mid]
            return findMin3(nums, left, mid);
        } else {
            // 下一轮搜索区间是 [mid + 1..right]
            return findMin3(nums, mid + 1, right);
        }
    }
    //如果你愿意写得再细致一点，还可以这样写。
    public int findMin4(int[] nums) {
        int len = nums.length;
        return findMin5(nums, 0, len - 1);
    }

    private int findMin5(int[] nums, int left, int right) {
        // 递归终止条件，区间里只有 1 个元素的时候，返回这个元素
        if (left == right) {
            return nums[left];
        }
        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // 分治：设置分治的界限
        int mid = left + (right - left) / 2;

        if (nums[mid] == nums[right]) {
            return findMin5(nums, left, right - 1);
        } else if (nums[mid] < nums[right]) {
            return findMin5(nums, left, mid);
        } else {
            return findMin5(nums, mid + 1, right);
        }
    }
}
