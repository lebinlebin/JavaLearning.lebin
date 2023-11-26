package Java.lebin.Training.InterviewCases.binarySearch;

/**
 * 33. 搜索旋转排序数组的具体值
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 */
//时间复杂度:O(logn),其中 n 为nums 数组的大小。
// 空间复杂度: O(1) ,我们只需要常数级别的空间存放变量。
public class _33_搜索旋转排序数组的某个具体值 {
	public int search(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) { return -1; }
		if (n == 1) {return nums[0] == target ? 0 : -1; }
		int l = 0, r = n - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) { return mid;}
			//判定属于哪一部分，左边大的一部分还是右边大的一部分
			//属于左边大的部分的话，就按照左边的二分查找，l和r都要有变动
			//同理属于右边部分的话也是左右两边都要变动
			//左边大的一部分
			if (nums[0] <= nums[mid]) {//左边部分
				if (nums[0] <= target && target < nums[mid]) {//[0,mid)
					r = mid - 1;
				} else  {//[mid,]
					l = mid + 1;
				}
			} else if(nums[0] > nums[mid]){//右边部分
				if (nums[mid] < target && target <= nums[n - 1]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}

		return -1;
	}
}
