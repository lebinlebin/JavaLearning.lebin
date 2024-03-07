package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashMap;
import java.util.Map;

/*
LCR 070. 有序数组中的单一元素
给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
示例 1:
输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:
输入: nums =  [3,3,7,7,10,11,11]
输出: 10
 */
public class _LCR070_有序数组中的单一元素_其它都出现两次 {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Integer num:nums){
            if(map.getOrDefault(num,0)==1){
                return num;
            }
        }
        return 0;
    }
    //二分查找
    public int singleNonDuplicate2(int[] nums) {
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
