package Java.lebin.Training.InterviewCases.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * 题目：设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * 示例 1:
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 */
/*
 * 思路一：hash表
 * hash 用来存储数组中数据，key为值，value为这个数在数组中出现的次数。
 * 从左到右遍历数组：
 * 如果hash表中存在target - num 这个key，就添加这对数到结果集中，并且判断这个数在左边出现的次数是否为1
 * 1）如果为1，那么就删除这个key
 * 2）如果不为1，那么将value - 1
 * 如果hash表中不存在target - num这个key，那么就将当前的值放入到hash表中，等待后面需要
 * 这样只需要一次从左到右的遍历就可以获取到了所有的数对
 */
    //时间复杂度O(n)  该算法的时间复杂度主要取决于两个循环。第一个循环用于填充映射，第二个循环用于找到和为目标值的整数对。因为这两个循环都是线性的，所以总的时间复杂度是O(n) + O(n) = O(2n)。。
    //空间复杂度O(n)
public class 面试题16_24数对和_两数之和为指定值的整数对 {
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer count = map.get(target - num);
            if (count != null) {
                res.add(Arrays.asList(target-num, num));
                if (count == 1) {
                    map.remove(target - num);
                }else{
                    map.put(target - num, --count);
                }
            }else{
                map.put(num, map.getOrDefault(num,0) + 1);
            }
        }

        return res;
    }

    /*
    思路二：排序后双指针
    排序后可以通过双指针在O(N)的时间复杂度下找出等于目标值的数对
    所谓的双指针就是通过先排序将遍历的方式简单化了，每次只要移动一个指针就可以将结果变为最接近的大一点的结果或者最接近的小一点的结果，
    可以把时间复杂度由纯暴力的O(n^2)降为双指针的O(nlogn).
     */
    public static List<List<Integer>> pairSums2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            //如果小于目标值，左指针右移动一位
            if (nums[left] + nums[right] < target) {
                left++;
            }else if (nums[left] + nums[right] > target) {
                //大于目标值，右指针向左移动一位
                right--;
            }else if(nums[left] + nums[right] == target){
                //相等时，添加到结果集，并且移动左右指针，继续找下一个数对
                res.add(Arrays.asList(nums[left],nums[right]));
                left++;
                right--;
            }
        }
        return res;
    }



    //变种
    //如果返回的是所有可能的组合，比如
    //[-1,-2,2,-2,2,-2,3,3,-3]
    //[-3,-2,-2,-2,-1,2,2,3,3]
    //返回 8对，即  [-3,3],[-3,3],[-2,2],[-2,2],[-2,2],[-2,2],[-2,2],[-2,2]共八个
    public static List<List<Integer>> pairSums3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            //如果小于目标值，左指针右移动一位
            if (nums[left] + nums[right] < target) {
                left++;
            }else if (nums[left] + nums[right] > target) {
                //大于目标值，右指针向左移动一位
                right--;
            }else if(nums[left] + nums[right] == target){//对相等的情况进行改进
                //相等时，添加到结果集，并且移动左右指针，继续找下一个数对
                int tmp = left;//left记录下来
                while(nums[left] + nums[right] == target){
                    res.add(Arrays.asList(nums[left],nums[right]));
                    left++;
                }
                while(nums[tmp] + nums[right] == target){
                    res.add(Arrays.asList(nums[tmp],nums[right]));
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,2,-2,2,-2,3,3,-3};
        System.out.println(pairSums3(nums,0));
    }
}