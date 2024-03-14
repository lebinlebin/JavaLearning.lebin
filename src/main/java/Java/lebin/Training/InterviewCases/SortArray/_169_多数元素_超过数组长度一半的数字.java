package Java.lebin.Training.InterviewCases.SortArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 剑指 Offer 39. 数组中出现次数超过一半的数字，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 示例 1:
 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 输出: 2
 时间复杂度：O(nlogn)。将数组排序的时间复杂度为 O(nlogn)。
 空间复杂度：O(logn)。如果使用语言自带的排序算法，需要使用 O(logn) 的栈空间
 */
public class _169_多数元素_超过数组长度一半的数字 {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

//	暴力穷举
//	时间复杂度O(n^2)，空间复杂度O(n)
public int majorityElement3(int[] nums) {
	// 遍历数组
	// 定义map用来记录每个数字在数组中出现的次数
	HashMap<Integer,Integer> map = new HashMap<>();
	for(int i = 0; i < nums.length; i++){
		if (!map.containsKey(nums[i])) map.put(nums[i],1);
		else map.put(nums[i], map.get(nums[i])+1);
	}

	// 遍历map，找出超过一半数组长度的数字
	for(Map.Entry<Integer,Integer> entry : map.entrySet()){
		if (entry.getValue() > nums.length/2) return entry.getKey();
	}
	return 0;
	}
}
