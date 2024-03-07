package Java.lebin.Training.InterviewCases.SortArray;
/*
有序数组中的单一元素,二分查找
给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
请你找出并返回只出现一次的那个数。
你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
示例 1:
输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2
 */
/*
时间复杂度：O(logn)，其中 n 是数组 nums 的长度。需要在全数组范围内二分查找，二分查找的时间复杂度是 O(logn)。
空间复杂度：O(1)。
 */
public class _540_有序数组中的单一元素_唯一一个出现一次 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int len = nums.length;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if(mid % 2 == 0){//偶数比较的是自己和下一个数字
                if(mid + 1 < len && nums[mid] == nums[mid+1]){
                    low = mid + 1;
                }else{//
                    high = mid;
                }
            } else{//奇数，比较的是他的前一个
                if(mid - 1 >= 0 && nums[mid] == nums[mid-1]){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}
