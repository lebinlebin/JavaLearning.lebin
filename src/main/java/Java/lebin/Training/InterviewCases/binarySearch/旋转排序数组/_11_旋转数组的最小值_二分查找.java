package Java.lebin.Training.InterviewCases.binarySearch.旋转排序数组;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
class _11_旋转数组的最小值_二分查找 {
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
				right--;//第一个比比最小值大的数，应该return right+1的位置，而终止条件正好是left == right +1 ，所以retur  narray[left]
			}
		}
		return array[left];//为什么返回的是 left？？？？？
	}

	public static void main(String[] args) {
		int[] nums = new  int[]{2,2,2,0,1};
		System.out.println(minArray(nums));
	}
}


