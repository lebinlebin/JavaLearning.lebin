package Java.lebin.Training.InterviewCases.binarySearch;

/**
 * 二分查找
 */
//时间复杂度：O(logn)，其中 n 是数组的长度。
//空间复杂度：O(1)。
public class _704_二分查找 {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1; // 注意

		while(left <= right) {//"<="的情况下对应的mid要加减1
			int mid = left + (right - left) / 2;
			if(nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1; // 注意
			else if (nums[mid] > target)
				right = mid - 1; // 注意
		}
		return -1;
	}



	//寻找左边界
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

	//	（版本一）左闭右闭区间
	public int search_left_right(int[] nums, int target) {
		// 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
		if (target < nums[0] || target > nums[nums.length - 1]) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid - 1;//todo：mid已经比过了，不需要再比了。
		}
		return -1;
	}
	public int search_left(int[] nums, int target) {
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid;//todo：mid已经比过了，这里是开区间比不到这个mid了
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,3,3,4,6,7};
		System.out.println(left_bound(nums,3));
		System.out.println(right_bound(nums,3));
//		System.out.println(search_left(nums,3));
		/*1,2,4,3,2,3,4,6,7
		  1,2,2,3,3,4,4,6,7
		 */
	}
}


