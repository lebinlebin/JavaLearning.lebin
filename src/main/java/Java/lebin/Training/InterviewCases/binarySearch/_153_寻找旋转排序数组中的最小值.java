package Java.lebin.Training.InterviewCases.binarySearch;
/*
已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class _153_寻找旋转排序数组中的最小值 {
    //时间复杂度：O(logn)，这里N 是输入数组的长度；
    //空间复杂度：O(1)，只使用了常数个临时变量。
    public int findMin(int[] nums) {
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
        return nums[left];
    }

    //存在重复元素的情况
    public static int minArray(int[] array) {
        int left = 0;
        int right = array.length-1;
        //		左闭右开
        while (left < right){//终止条件  left == right
            int mid = left +((right-left)>>1);
            //判定是属于前边部分还是后边部分，不管是和right比还是和left比都是要判定属于哪一部分
            if(array[mid] > array[right]){//前边部分，大的部分
                left = mid+1;//left 是可以取到的所以需要+1
            }else if(array[mid] < array[right]){//后边部分
                right = mid;//右边是取不到的所以不需要+1
            }else if(array[mid] == array[right]){//存在两个连续值相等的情况，直接让右侧向左移动即可
                right--;
            }
        }
        return array[left];//为什么返回的是 left？？？？？
    }

    //修改了边界条件
    public static int minArray2(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left <= right){//终止条件  left == right +1
            int mid = left +((right-left)>>1);
            //判定是属于前边部分还是后边部分，不管是和right比还是和left比都是要判定属于哪一部分
            if(array[mid] > array[right]){//前边部分，大的部分
                left = mid+1;//left 是可以取到的所以需要+1
            }else if(array[mid] < array[right]){//后边部分，这里mid不确定是不是最小值，所以mid还要保留，
                right = mid;//这里mid不确定是不是最小值，所以mid还要保留，right = mid而不是right = mid-1
            }else if(array[mid] == array[right]){//存在两个连续值相等的情况，直接让右侧向左移动即可
                right--;//第一个比比最小值大的数，应该return right+1的位置，而终止条件正好是left == right +1 ，所以return  narray[left]
            }
        }
        return array[left];//为什么返回的是 left？？？？？
    }
}
