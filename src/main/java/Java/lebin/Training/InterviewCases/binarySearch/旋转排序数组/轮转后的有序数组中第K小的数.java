package Java.lebin.Training.InterviewCases.binarySearch.旋转排序数组;
/*
对于普通的有序数组来说，这个问题是非常简单的，因为数组中的第K-1个数（即A[K-1]）就是所要找的数，
时间复杂度是O(1)常量。但是对于轮转后的有序数组，在不知道轮转的偏移位置，我们就没有办法快速定位第K个数了。

不过我们还是可以通过二分查找法，在log(n)的时间内找到最小数的在数组中的位置，
然后通过偏移来快速定位任意第K个数。当然此处还是假设数组中没有相同的数，原排列顺序是递增排列。
 */
public class 轮转后的有序数组中第K小的数 {
    //返回最小值的所在的数组索引
    public static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 下一轮搜索区间 [left..mid]
                right = mid;
            } else {
                // 因为题目中说：你可以假设数组中不存在重复元素
                // 此时一定有 nums[mid] > nums[right]
                // 下一轮搜索区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        // 一定存在最小元素，因此无需再做判断
        return left;
    }
    //旋转排序数组A,返回第k小的数，m是数组长度
    public static int findKthElement(int A[], int m, int k) {
        if (k > m) return -1;
        int base = findMin(A);
        int index = (base+k-1) % m;
        return index;//返回的是index
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,3};
        System.out.println(findKthElement(nums,nums.length-1,4));

    }

}
