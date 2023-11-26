package Java.lebin.Training.TEST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
字节三面
* */
/*
【-1，-2，2，-2，2，-2，3，3，-3】
【-3,-2,-2,-2,-1，，2，，2，，3，3】
 */
    public class _2_test {
         public  int sumcount( int[] nums){
             Arrays.sort(nums);
             int i = 0;
             int l = 0;
             int count = 0;
             int r = nums.length-1;
             while (i<=r){
                 //考虑多个值的情况
                 if(nums[i] + nums[r] == 0){
                     count ++;
                     r--;
                 }else if(nums[i]+nums[r] > 0){
                     r--;
                 }else if(nums[i]+nums[r] < 0){
                     i++;
                 }
             }
             return count;
         }

    public static void main(String[] args) {
    }
    }

