package Java.lebin.Training.InterviewCases.哈希表;

/**
 349. 两个数组的交集
 题意：给定两个数组，编写一个函数来计算它们的交集。
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2]
  */
/**
 *
 * 时间复杂度：O(m+n)
 * 优化方法： 使用两个集合分别存储两个数组中的元素，然后遍历较小的集合，判断其中的每个元素是否在另一个集合中，如果元素也在另一个集合中，则将该元素添加到返回值。
 * 时间复杂度降低到O(m+n)
 *
 * 时间复杂度：O(mn)
 * 暴力方法: 遍历数组 nums1，对其中每个元素，遍历数组 nums2 判断该元素是否在数组 nums2 中，如果存在，则将该元素添加到返回值。
 */

import java.util.HashSet;
import java.util.Set;

public class _349_两个数组的交集 {
	//时间复杂度：O(m+n)
	//空间复杂度O(m+n)
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> resSet = new HashSet<>();
		//遍历数组1
		for (int i : nums1) {
			set1.add(i);
		}
		//遍历数组2的过程中判断哈希表中是否存在该元素
		for (int i : nums2) {
			if (set1.contains(i)) {
				resSet.add(i);
			}
		}

		int[] arr = new int[resSet.size()];
		int j = 0;
		for(int i : resSet){
			arr[j++] = i;
		}

		return arr;
	}

	/*
	数组来做哈希表方法:
	//时间复杂度：O(m+n)
	//空间复杂度O(1005)
	 */
	public int[] intersection2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> resSet = new HashSet<>();
		int[] hashArr = new int[1005];// 默认数值为0
		//遍历数组1
		for (int i : nums1) {
			hashArr[i]=1;
		}
		//遍历数组2的过程中判断哈希表中是否存在该元素
		for (int i : nums2) {
			if (hashArr[i]==1) {
				resSet.add(i);
			}
		}

		//另外申请一个数组存放setRes中的元素,最后返回数组
		int[] arr = new int[resSet.size()];
		int j = 0;
		for(int i : resSet){
			arr[j++] = i;
		}

		return arr;
	}

}
