package Java.lebin.Training.InterviewCases.binarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 解题思路
 * 此处撰写解题思路
 * 真二分法O（logn），首先要二分法找到最左边的target，其次再去找最右边第一个大于target的值，
 * 因为找右边的时候尽量要让区间靠右取，所以只能去找第一个大于target的值，最后right要减去1才是正确的right下标，思路尽在代码中；
 *
 */

public class _34_在排序数组中查找目标元素的第一个和最后一个位置 {
//	时间复杂度： O(logn) ，其中 n 为数组的长度。二分查找的时间复杂度为 O(logn)，一共会执行两次，因此总时间复杂度为 O(logn)。
//	空间复杂度：O(1) 。只需要常数空间存放若干变量。

	public int[] searchRange(int[] nums, int target) {
		int leftIdx = binarySearch(nums, target, true);
		int rightIdx = binarySearch(nums, target, false) - 1;
		if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
			return new int[]{leftIdx, rightIdx};
		}
		return new int[]{-1, -1};
	}

	public int binarySearch(int[] nums, int target, boolean lower) {
		int left = 0, right = nums.length - 1, ans = nums.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] > target || (lower && nums[mid] >= target)) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}


	public static int[] searchRange2(int[] nums, int target) {
		//找第一个大于等于target的下标
		int leftIdx = left_bound(nums, target);
		//找第一个大于target的下标
		int rightIdx = right_bound(nums, target);

		if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
			return new int[]{leftIdx, rightIdx};
		}
		return new int[]{-1, -1};
	}


	static int left_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {//退出条件是 left= right+1
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 别返回，锁定左侧边界
				right = mid - 1;//这里退出时候right值其实是，第一个等于target的左边一个数字
			}
		}
		// 最后要检查 left 越界的情况
		if (left >= nums.length || nums[left] != target)
			return -1;
		return left;
	}




	static int right_bound(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {//退出条件是 left= right+1
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 别返回，锁定右侧边界
				left = mid + 1;//这里left最终指向的是第一个大于target的位置，返回应该是left-1，而right恰好是left-1
			}
		}
		// 最后要检查 right 越界的情况
		if (right < 0 || nums[right] != target)
			return -1;
		return right;//退出条件是 left= right+1
	}






	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,3,3,6,7};
		/*1,2,4,3,2,3,4,6,7
		  1,2,2,3,3,4,4,6,7
		 */
		System.out.println(Arrays.toString(searchRange2(nums,3)));

	}

}
